package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreRol implements ValueObject<String> {
    private final String nombreRol;

    public NombreRol(String nombreRol) {
        this.nombreRol = Objects.requireNonNull(nombreRol);
        if (this.nombreRol.isBlank()) {
            throw new IllegalArgumentException("El nombre del rol no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return nombreRol;
    }
}
