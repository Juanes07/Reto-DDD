package co.com.cafeteria.procesos.pedido.events;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.Cantidad;
import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.pedido.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoCreado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Cliente cliente;
    private final Fecha fecha;
    private final Local local;
    private final Producto producto;

    public PedidoCreado(PedidoId pedidoId, Cliente cliente, Fecha fecha, Local local, Producto producto) {
        super("co.com.cafeteria.procesos.PedidoCreado");
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.fecha = fecha;
        this.local = local;
        this.producto = producto;

    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Local getLocal() {
        return local;
    }

    public Producto getProducto() {
        return producto;
    }

}
