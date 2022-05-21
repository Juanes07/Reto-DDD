package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaDeTrabajoActualizada extends DomainEvent {
    private  final ZonaDeTrabajoId zonaDeTrabajoId;

    public ZonaDeTrabajoActualizada(ZonaDeTrabajoId zonaDeTrabajoId) {
        super("co.com.cafeteria.procesos.ZonaDeTrabajoActualizada");
        this.zonaDeTrabajoId = zonaDeTrabajoId;
    }

    public ZonaDeTrabajoId getZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }

}
