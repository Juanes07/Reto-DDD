package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class AgregarPedido extends Command {
    private final PedidoId pedidoId;
    private final Local local;
    private final Fecha fecha;
    private final Cliente cliente;
    private final List<Producto> producto;

    public AgregarPedido(PedidoId pedidoId, Local local, Fecha fecha, Cliente cliente, List<Producto> producto) {
        this.pedidoId = pedidoId;
        this.local = local;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
    }

    public PedidoId PedidoId() {
        return pedidoId;
    }

    public Local Local() {
        return local;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Cliente Cliente() {
        return cliente;
    }

    public List<Producto> Producto() {
        return producto;
    }
}
