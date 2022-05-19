package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaDeTrabajoEliminada extends DomainEvent {
    private final ZonaDeTrabajoId zonaDeTrabajoId;

    public ZonaDeTrabajoEliminada(ZonaDeTrabajoId zonaDeTrabajoId) {
        super("co.com.cafeteria.procesos.ZonaDeTrabajoEliminada");
        this.zonaDeTrabajoId = zonaDeTrabajoId;
    }

    public ZonaDeTrabajoId ZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }
}
