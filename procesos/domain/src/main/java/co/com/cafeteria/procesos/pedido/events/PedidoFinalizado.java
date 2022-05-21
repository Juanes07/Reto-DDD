package co.com.cafeteria.procesos.pedido.events;

import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;


/**
 * Evento de dominio PedidoFinalizado
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class PedidoFinalizado extends DomainEvent {
    /**
     * caracteristica
     */
    private final PedidoId pedidoId;

    /**
     * constructor PedidoFinalizado
     *
     * @param pedidoId tipo PedidoId
     */
    public PedidoFinalizado(PedidoId pedidoId) {
        super("co.com.cafeteria.procesos.PedidoFinalizado");
        this.pedidoId = pedidoId;
    }

    /**
     * getter
     */
    public PedidoId getPedidoId() {
        return pedidoId;
    }

}
