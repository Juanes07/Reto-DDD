package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.Identity;

/**
 * id de la entidad cliente
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class ClienteId extends Identity {

    /**
     * constructor ClienteId
     * @param id tipo Striing
     */

    public ClienteId(String id) {
        super(id);
    }
}
