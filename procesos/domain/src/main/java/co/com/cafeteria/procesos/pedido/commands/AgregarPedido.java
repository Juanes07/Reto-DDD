package co.com.cafeteria.procesos.pedido.commands;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarPedido extends Command {
    private final PedidoId pedidoId;
    private final Cliente cliente;
    private final Fecha fecha;
    private final Local local;
    private final Producto producto;
    private final Precio precio;
    private final Cantidad cantidad;

    public AgregarPedido(PedidoId pedidoId, Cliente cliente, Fecha fecha, Local local, Producto producto, Precio precio, Cantidad cantidad) {
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.fecha = fecha;
        this.local = local;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
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

    public Producto Producto() {
        return producto;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
