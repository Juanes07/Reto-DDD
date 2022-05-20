package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.sofka.domain.generic.DomainEvent;

public class InstrumentoEliminado extends DomainEvent {

    private final InstrumentoId instrumentoId;

    public InstrumentoEliminado(InstrumentoId instrumentoId) {
        super("co.com.cafeteria.procesos.ContratoAgregado");
        this.instrumentoId = instrumentoId;
    }

    public InstrumentoId InstrumentoId() {
        return instrumentoId;
    }
}
