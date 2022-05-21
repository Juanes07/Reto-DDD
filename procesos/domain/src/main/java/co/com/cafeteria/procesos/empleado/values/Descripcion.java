package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Objeto de valor Descripcion
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Descripcion implements ValueObject<String> {

    /**
     * caracteristica
     */

    private final String descripcion;

    /**
     * Constructor Descripcion
     *
     * @param descripcion tipo String
     */

    public Descripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String value() {
        return descripcion;
    }
}
