package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class PedidoAgregado extends DomainEvent {
    private final Local local;
    private final Fecha fecha;
    private final Cliente cliente;
    private final List<Producto> producto;

    public PedidoAgregado(Local local, Fecha fecha, Cliente cliente, List<Producto> producto) {
        super("co.com.cafeteria.procesos.PedidoAgregado");
        this.local = local;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
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
