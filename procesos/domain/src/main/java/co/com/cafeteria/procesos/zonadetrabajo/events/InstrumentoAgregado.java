package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.entity.Categoria;
import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

public class InstrumentoAgregado extends DomainEvent {
    private final ZonaDeTrabajoId zonaDeTrabajoId;
    private final InstrumentoId instrumentoId;
    private final Nombre nombre;
    private final Categoria categoria;

    public InstrumentoAgregado(ZonaDeTrabajoId zonaDeTrabajoId, InstrumentoId instrumentoId, Nombre nombre, Categoria categoria) {
        super("co.com.cafeteria.procesos.InstrumentoAgregado");
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

    public InstrumentoId getInstrumentoId() {
        return instrumentoId;
    }

    public ZonaDeTrabajoId getZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }
}
