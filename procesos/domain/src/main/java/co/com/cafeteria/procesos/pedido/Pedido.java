package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Local local;
    protected Fecha fecha;
    protected Cliente cliente;
    protected Set<Producto> producto;
    protected Precio precio;
    protected Cantidad cantidad;

    public Pedido(PedidoId id, Local local, Fecha fecha, Cliente cliente, Set<Producto> producto) {
        super(id);
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

    public Set<Producto> Producto() {
        return producto;
    }

    public Precio Precio() {
        return precio;
    }

    public Cantidad Cantidad() {
        return cantidad;
    }
}
