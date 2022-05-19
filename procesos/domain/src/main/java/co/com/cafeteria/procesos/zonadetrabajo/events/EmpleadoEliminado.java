package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EmpleadoEliminado extends DomainEvent {
    private final EmpleadoId empleadoId;

    public EmpleadoEliminado(EmpleadoId empleadoId) {
        super("co.com.cafeteria.procesos.EmpleadoEliminado");
        this.empleadoId = empleadoId;
    }

    public EmpleadoId EmpleadoId() {
            return empleadoId;
    }
}
