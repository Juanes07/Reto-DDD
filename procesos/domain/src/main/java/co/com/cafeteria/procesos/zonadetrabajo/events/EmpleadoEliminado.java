package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EmpleadoEliminado extends DomainEvent {
    private final ZonaDeTrabajoId zonaDeTrabajoId;
    private final EmpleadoId empleadoId;

    public EmpleadoEliminado(ZonaDeTrabajoId zonaDeTrabajoId, EmpleadoId empleadoId) {
        super("co.com.cafeteria.procesos.EmpleadoEliminado");
        this.zonaDeTrabajoId = zonaDeTrabajoId;
        this.empleadoId = empleadoId;
    }

    public EmpleadoId EmpleadoId() {
            return empleadoId;
    }

    public ZonaDeTrabajoId getZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }
}
