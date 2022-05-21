package co.com.cafeteria.procesos.zonadetrabajo.value;


import co.com.sofka.domain.generic.Identity;

/**
 * Id de la entidad ZonaDeTrabajo
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class ZonaDeTrabajoId extends Identity {
    /**
     * Constructor ZonaDeTrabajoId
     * @param id tipo String
     */
    public ZonaDeTrabajoId(String id) {
        super(id);
    }

    public static ZonaDeTrabajoId of(String id) {
        return new ZonaDeTrabajoId(id);
    }
}
