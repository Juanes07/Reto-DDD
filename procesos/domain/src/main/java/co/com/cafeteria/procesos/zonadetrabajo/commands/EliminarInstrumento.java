package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.sofka.domain.generic.Command;

public class EliminarInstrumento extends Command {
    private final InstrumentoId instrumentoId;

    public EliminarInstrumento(InstrumentoId instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public InstrumentoId InstrumentoId() {
        return instrumentoId;
    }
}
