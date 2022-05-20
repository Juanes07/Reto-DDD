package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<String> {
    private final String precio;

    public Precio(String precio) {
        this.precio = precio;
    }

    @Override
    public String value() {
        return precio;
    }
}
