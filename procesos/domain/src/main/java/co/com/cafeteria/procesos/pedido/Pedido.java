package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Local local;
    protected Fecha fecha;
    protected Cliente cliente;
    protected List<Producto> producto;



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
