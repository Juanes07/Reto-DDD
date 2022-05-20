package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<String> {
    private final String cantidad;

    public Cantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String value() {
        return cantidad;
    }
}
