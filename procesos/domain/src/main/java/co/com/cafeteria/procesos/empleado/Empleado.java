package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.events.ContratoAgregado;
import co.com.cafeteria.procesos.empleado.events.RolEmpleadoAgregado;
import co.com.cafeteria.procesos.empleado.events.UniformeEmpleadoAgregado;
import co.com.cafeteria.procesos.empleado.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.EmpleadoAgregado;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

import java.util.List;

/**
 * Agregado Empleado
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Empleado extends AggregateEvent<EmpleadoId> {

    /**
     * Caracteristicas
     */

    protected Contrato contrato;
    protected Nombre nombre;
    protected Rol rol;
    protected Uniforme uniforme;

    /**
     * constructor Empleado
     *
     * @param id       tipo EmpleadoId
     * @param Contrato tipo Contrato
     * @param nombre   tipo Nombre
     * @param rol      tipo Rol
     * @param uniforme tipo Uniforme
     */
    public Empleado(EmpleadoId id, Contrato Contrato, Nombre nombre, Rol rol, Uniforme uniforme) {
        super(id);
        appendChange(new EmpleadoAgregado(Contrato, nombre, rol, uniforme)).apply();
        subscribe(new EmpleadoEventChange(this));
    }

    /**
     * Constructor
     *
     * @param empleadoId
     */

    private Empleado(EmpleadoId empleadoId) {
        super(empleadoId);
        subscribe(new EmpleadoEventChange(this));
    }

    public static Empleado from(EmpleadoId empleadoId, List<DomainEvent> events) {
        var empleado = new Empleado(empleadoId);
        events.forEach(empleado::applyEvent);
        return empleado;
    }

    /**
     * comportamiento AgregarUniforme a empleado
     *
     * @param empleadoId tipo EmpleadoId
     * @param uniforme   tipo Uniforme
     */

    public void agregarUniforme(EmpleadoId empleadoId, Uniforme uniforme) {
        appendChange(new UniformeEmpleadoAgregado(uniforme, empleadoId)).apply();
    }

    /**
     * Comportamiento AgregarRol a empleado
     *
     * @param empleadoId tipo EmpleadoId
     * @param nombre     tipo Nombre
     * @param contrato   Tipo Contrato
     * @param rol        tipo Rol
     */

    public void agregarRol(EmpleadoId empleadoId, Nombre nombre, Contrato contrato, Rol rol) {
        appendChange(new RolEmpleadoAgregado(empleadoId, contrato, nombre, rol)).apply();
    }

    /**
     * Comportamiento AgregarContrato a empleado
     *
     * @param contratoId     tipo ContratoId
     * @param tipoDeContrato tipo TipoDeContrato
     */

    public void agregarContrato(ContratoId contratoId, TipoDeContrato tipoDeContrato) {
        appendChange(new ContratoAgregado(contratoId, tipoDeContrato)).apply();
    }


}
