package co.com.cafeteria.procesos.zonadetrabajo.entity;

import co.com.sofka.domain.generic.ValueObject;


public class Categoria implements ValueObject {
    private final String categoria;

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public Object value() {
        return categoria;
    }
}
