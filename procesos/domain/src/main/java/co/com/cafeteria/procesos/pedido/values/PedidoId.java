package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Id del agregado Pedido
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */
public class PedidoId extends Identity {
    /**
     * constructor pedidoId
     * @param id tipo String
     */
    public PedidoId(String id) {
        super(id);
    }

    public static PedidoId of(String id) {
        return new PedidoId(id);
    }
}
