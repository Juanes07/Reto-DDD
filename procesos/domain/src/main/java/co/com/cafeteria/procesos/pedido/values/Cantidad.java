package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<String> {
    private final String cantidad;

    public Cantidad(String cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad);
        if(this.cantidad.isBlank()){
            throw new IllegalArgumentException("La cantidad del producto no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return cantidad;
    }
}
