package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.events.RolEmpleadoAgregado;
import co.com.cafeteria.procesos.empleado.events.UniformeEmpleadoAgregado;
import co.com.cafeteria.procesos.empleado.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.EmpleadoAgregado;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

import java.util.List;

public class Empleado extends AggregateEvent<EmpleadoId> {

    protected Contrato contrato;
    protected Nombre nombre;
    protected Rol rol;
    protected Uniforme uniforme;


    public Empleado(EmpleadoId id, Contrato Contrato, Nombre nombre, Rol rol, Uniforme uniforme) {
        super(id);
       appendChange(new EmpleadoAgregado(Contrato,nombre,rol,uniforme)).apply();
       subscribe(new EmpleadoEventChange(this));
    }

    private Empleado(EmpleadoId empleadoId) {
        super(empleadoId);
        subscribe(new EmpleadoEventChange(this));
    }

    public static Empleado from(EmpleadoId empleadoId, List<DomainEvent> events){
        var empleado = new Empleado(empleadoId);
        events.forEach(empleado::applyEvent);
        return empleado;
    }

    public  void agregarUniforme(Uniforme uniforme){
        var empleadoId = new EmpleadoId("da");
        appendChange(new UniformeEmpleadoAgregado(uniforme, empleadoId)).apply();
    }

    public void agregarRol(Rol rol){
        var empleadoId = new EmpleadoId("da");
        var nombre = new Nombre("Juan");
        var contrato = new Contrato(new ContratoId("da"),new TipoDeContrato("horas","10"));
        appendChange(new RolEmpleadoAgregado(empleadoId, contrato,nombre,rol)).apply();
    }


}
