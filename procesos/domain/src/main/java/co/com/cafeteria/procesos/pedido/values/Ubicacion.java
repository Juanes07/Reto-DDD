package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ubicacion implements ValueObject<String> {
    private final String ubicacion;

    public Ubicacion(String ubicacion) {
        this.ubicacion = Objects.requireNonNull(ubicacion);
        if(this.ubicacion.isBlank()){
            throw new IllegalArgumentException("La ubicacion del local no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return ubicacion;
    }
}
