package co.com.cafeteria.procesos.zonadetrabajo.entity;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Categoria implements ValueObject {
    private final String categoria;

    public Categoria(String categoria) {
        this.categoria = Objects.requireNonNull(categoria);
        if(this.categoria.isBlank()){
            throw new IllegalArgumentException("La categoria del instrumento no puede estar vacia");
        }
    }

    @Override
    public Object value() {
        return categoria;
    }
}
