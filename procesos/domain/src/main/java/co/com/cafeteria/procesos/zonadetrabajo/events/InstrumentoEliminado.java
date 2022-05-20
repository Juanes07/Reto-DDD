package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.DomainEvent;

public class InstrumentoEliminado extends DomainEvent {
    private final ZonaDeTrabajoId zonaDeTrabajoId;
    private final InstrumentoId instrumentoId;

    public InstrumentoEliminado(ZonaDeTrabajoId zonaDeTrabajoId, InstrumentoId instrumentoId) {
        super("co.com.cafeteria.procesos.InstrumentoEliminado");
        this.zonaDeTrabajoId = zonaDeTrabajoId;
        this.instrumentoId = instrumentoId;
    }

    public InstrumentoId InstrumentoId() {
        return instrumentoId;
    }

    public ZonaDeTrabajoId getZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }
}
