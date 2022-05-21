package co.com.cafeteria.procesos.pedido.events;

import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoActualizado extends DomainEvent {
    private  final PedidoId   pedidoId;

    public PedidoActualizado(PedidoId pedidoId) {
        super("co.com.cafeteria.procesos.PedidoActualizado");
        this.pedidoId = pedidoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
