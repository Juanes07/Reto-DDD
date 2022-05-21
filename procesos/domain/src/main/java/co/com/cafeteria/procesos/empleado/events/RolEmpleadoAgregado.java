package co.com.cafeteria.procesos.empleado.events;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

/**
 *  Evento de Dominio RolEmpleadoAgregado
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class RolEmpleadoAgregado extends DomainEvent {
    private final EmpleadoId empleadoId;
    private final Contrato contrato;
    private final Nombre nombre;
    private final Rol rol;

    public RolEmpleadoAgregado(EmpleadoId empleadoId, Contrato contrato, Nombre nombre, Rol rol) {
        super("co.com.cafeteria.procesos.RolEmpleadoAgregado");
        this.empleadoId = empleadoId;
        this.contrato = contrato;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Contrato Contrato() {
        return contrato;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Rol Rol() {
        return rol;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }
}
