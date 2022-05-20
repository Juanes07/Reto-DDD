package co.com.cafeteria.procesos.pedido.events;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoAgregado extends DomainEvent {
    private final Cliente cliente;
    private final Fecha fecha;
    private final Local local;
    private final Producto producto;

    public PedidoAgregado(Cliente cliente, Fecha fecha, Local local, Producto producto) {
        super("co.com.cafeteria.procesos.PedidoAgregado");
        this.cliente = cliente;
        this.fecha = fecha;
        this.local = local;
        this.producto = producto;
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
}
