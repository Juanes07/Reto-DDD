package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.entity.Categoria;
import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.sofka.domain.generic.Command;
import generic.Nombre;

public class AgregarInstrumento extends Command {
    private final InstrumentoId instrumentoId;
    private final Nombre nombre;
    private final Categoria categoria;


    public AgregarInstrumento(InstrumentoId instrumentoId, Nombre nombre, Categoria categoria) {
        this.instrumentoId = instrumentoId;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Categoria Categoria() {
        return categoria;
    }

    public InstrumentoId InstrumentoId() {
        return instrumentoId;
    }
}
