package generic;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Objeto de valor Nombre
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    /**
     * caracteristicas
     */
    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return nombre;
    }
}
