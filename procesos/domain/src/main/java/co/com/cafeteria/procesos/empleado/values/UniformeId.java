package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Id del agregado UniformeId
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class UniformeId extends Identity {

    /**
     * Constructor UniformeId
     *
     * @param id tipo UniformeId
     */

    public UniformeId(String id) {
        super(id);
    }

    public static UniformeId of(String id) {
        return new UniformeId(id);
    }
}
