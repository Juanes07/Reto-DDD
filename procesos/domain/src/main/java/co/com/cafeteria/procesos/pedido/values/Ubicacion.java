package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ubicacion implements ValueObject<String> {
    private final String ubicacion;

    public Ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String value() {
        return ubicacion;
    }
}
