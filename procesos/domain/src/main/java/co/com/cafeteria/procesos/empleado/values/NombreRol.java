package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Objeto de valor NombreRol
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

import java.util.Objects;

public class NombreRol implements ValueObject<String> {
    /**
     * caracteristica
     */
    private final String nombreRol;

    /**
     * Constructor NombreRol
     * @param nombreRol tipo String
     */

    public NombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String value() {
        return nombreRol;
    }
}
