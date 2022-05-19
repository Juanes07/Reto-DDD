package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.events.EmpleadoAgregado;
import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.AggregateEvent;
import generic.Nombre;

public class Empleado extends AggregateEvent<EmpleadoId> {
    protected Contrato contrato;
    protected Nombre nombre;
    protected Rol rol;
    protected Uniforme uniforme;

    public Empleado(EmpleadoId id, Contrato contrato, Nombre nombre, Rol rol, Uniforme uniforme) {
        super(id);
        appendChange(new EmpleadoAgregado(nombre,contrato,rol,uniforme));
        subscribe(new EmpleadoEventChange(this));
    }

    public Empleado(EmpleadoId empleadoId) {
        super(empleadoId);
        subscribe(new EmpleadoEventChange(this));
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

    public Uniforme Uniforme() {
        return uniforme;
    }
}
