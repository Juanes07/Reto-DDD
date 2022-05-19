package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
        if(this.descripcion.isBlank()){
            throw new IllegalArgumentException("La descripcion del uniforme no debe estar vacia");
        }

    }

    @Override
    public String value() {
        return descripcion;
    }
}
