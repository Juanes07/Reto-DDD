package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoEliminado extends DomainEvent {
    private final PedidoId pedidoId;

    public PedidoEliminado(PedidoId pedidoId) {
        super("co.com.cafeteria.procesos.PedidoEliminado");
        this.pedidoId = pedidoId;
    }

    public PedidoId PedidoId() {
        return pedidoId;
    }
}
