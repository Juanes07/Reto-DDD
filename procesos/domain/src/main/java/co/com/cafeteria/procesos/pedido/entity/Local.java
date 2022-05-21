package co.com.cafeteria.procesos.pedido.entity;

import co.com.cafeteria.procesos.pedido.values.LocalId;
import co.com.cafeteria.procesos.pedido.values.Ubicacion;
import co.com.sofka.domain.generic.Entity;

/**
 * Entidad Local
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Local extends Entity<LocalId> {
    protected Ubicacion ubicacion;

    public Local(LocalId id, Ubicacion ubicacion) {
        super(id);
        this.ubicacion = ubicacion;
    }

}
