package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.Command;

public class EliminarInstrumento extends Command {
    private final ZonaDeTrabajoId zonaDeTrabajoId;
    private final InstrumentoId instrumentoId;

    public EliminarInstrumento(ZonaDeTrabajoId zonaDeTrabajoId, InstrumentoId instrumentoId) {
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
