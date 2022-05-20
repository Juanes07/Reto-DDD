package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.entity.Categoria;
import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.Command;
import generic.Nombre;

public class AgregarInstrumento extends Command {
    private final ZonaDeTrabajoId zonaDeTrabajoId;
    private final InstrumentoId instrumentoId;
    private final Nombre nombre;
    private final Categoria categoria;


    public AgregarInstrumento(ZonaDeTrabajoId zonaDeTrabajoId, InstrumentoId instrumentoId, Nombre nombre, Categoria categoria) {
        this.zonaDeTrabajoId = zonaDeTrabajoId;
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

    public ZonaDeTrabajoId zonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }
}
