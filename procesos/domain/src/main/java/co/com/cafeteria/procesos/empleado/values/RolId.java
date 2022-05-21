package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Id de la entidad Rol
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class RolId extends Identity {

    /**
     * Conscturctor RolId
     *
     * @param id
     */
    public RolId(String id) {
        super(id);
    }

    public static RolId of(String id) {
        return new RolId(id);
    }
}
