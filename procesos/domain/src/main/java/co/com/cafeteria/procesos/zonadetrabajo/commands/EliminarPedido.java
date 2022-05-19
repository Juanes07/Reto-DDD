package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.Command;

public class EliminarPedido extends Command {
    private final PedidoId pedidoId;

    public EliminarPedido(PedidoId pedidoId) {
        this.pedidoId = pedidoId;
    }

    public PedidoId PedidoId() {
        return pedidoId;
    }
}
