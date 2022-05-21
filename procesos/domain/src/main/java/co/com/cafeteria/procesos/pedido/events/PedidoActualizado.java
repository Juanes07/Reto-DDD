package co.com.cafeteria.procesos.pedido.events;

import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * Evento de dominio Pedido Actualizado
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class PedidoActualizado extends DomainEvent {
    /**
     * caracteristicas
     */
    private final PedidoId pedidoId;


    /**
     * constructor PedidoActualizado
     * @param pedidoId tipo PedidoId
     */

    public PedidoActualizado(PedidoId pedidoId) {
        super("co.com.cafeteria.procesos.PedidoActualizado");
        this.pedidoId = pedidoId;
    }

    /**
     * getter
     */

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
