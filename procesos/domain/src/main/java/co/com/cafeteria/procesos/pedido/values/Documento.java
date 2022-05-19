package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Documento implements ValueObject<String> {
    private final String documento;

    public Documento(String documento) {
        this.documento = documento;

    }

    @Override
    public String value() {
        return documento;
    }
}
