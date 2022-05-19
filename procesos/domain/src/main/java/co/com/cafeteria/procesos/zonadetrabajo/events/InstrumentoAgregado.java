package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.entity.Categoria;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

public class InstrumentoAgregado extends DomainEvent {
    private final Nombre nombre;
    private final Categoria categoria;

    public InstrumentoAgregado(Nombre nombre, Categoria categoria) {
        super("co.com.cafeteria.procesos.InstrumentoAgregado");
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Categoria Categoria() {
        return categoria;
    }
}
