package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Local local;
    protected Fecha fecha;
    protected Cliente cliente;
    protected Producto producto;

    public Pedido(PedidoId id, Local local, Fecha fecha, Cliente cliente, Producto producto) {
        super(id);
        this.local = local;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
    }

    public void crearPedido(PedidoId pedidoId,Cliente cliente, Fecha fecha,Local local, Producto producto){
        appendChange(new PedidoCreado(pedidoId,cliente,fecha,local,producto)).apply();
    }

}
