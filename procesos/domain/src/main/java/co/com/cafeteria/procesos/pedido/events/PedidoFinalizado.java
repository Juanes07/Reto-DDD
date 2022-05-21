package co.com.cafeteria.procesos.pedido.events;

import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoFinalizado extends DomainEvent {
    private final PedidoId pedidoId;

    public PedidoFinalizado(PedidoId pedidoId) {
        super("co.com.cafeteria.procesos.PedidoFinalizado");
        this.pedidoId = pedidoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

}
