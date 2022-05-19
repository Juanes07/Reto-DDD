package co.com.cafeteria.procesos.zonadetrabajo.entity;

import co.com.sofka.domain.generic.Entity;
import generic.Nombre;

public class Instrumento extends Entity<InstrumentoId> {
    protected Nombre nombre;
    protected Categoria categoria;

    public Instrumento(InstrumentoId id, Nombre nombre, Categoria categoria) {
        super(id);
        this.nombre = nombre;
        this.categoria = categoria;

    }

    public void asignarCategoria(String categoria){
        this.categoria = new Categoria(categoria);
    }

}
