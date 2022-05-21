package co.com.cafeteria.procesos.pedido.entity;

import co.com.cafeteria.procesos.pedido.values.ClienteId;
import co.com.cafeteria.procesos.pedido.values.Documento;
import co.com.sofka.domain.generic.Entity;
import generic.Nombre;

/**
 * Entidad Cliente
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Cliente extends Entity<ClienteId> {
    protected Nombre nombre;
    protected Documento documento;

    public Cliente(ClienteId id, Nombre nombre, Documento documento) {
        super(id);
        this.nombre = nombre;
    }

}
