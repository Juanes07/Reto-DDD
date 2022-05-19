package co.com.cafeteria.procesos.pedido.commands;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.Command;

public class AgregarPedido extends Command {
    private final PedidoId pedidoId;
    private final Cliente cliente;
    private final Fecha fecha;
    private final Local local;

    public AgregarPedido(PedidoId pedidoId, Cliente cliente, Fecha fecha, Local local) {
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.fecha = fecha;
        this.local = local;
    }

    public PedidoId PedidoId() {
        return pedidoId;
    }

    public Cliente Cliente() {
        return cliente;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Local Local() {
        return local;
    }
}
