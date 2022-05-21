package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.cafeteria.procesos.pedido.events.PedidoActualizado;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.PedidoEliminado;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Local local;
    protected Fecha fecha;
    protected Cliente cliente;
    protected Producto producto;

    public Pedido(PedidoId id, Local local, Fecha fecha, Cliente cliente, Producto producto) {
        super(id);
        appendChange(new PedidoCreado(id,cliente,fecha,local,producto));
        subscribe(new PedidoEventChange(this));
    }

    public Pedido(PedidoId pedidoId){
        super(pedidoId);
        subscribe(new PedidoEventChange(this));
    }



    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void crearPedido(PedidoId pedidoId,Cliente cliente, Fecha fecha,Local local, Producto producto){
        appendChange(new PedidoCreado(pedidoId,cliente,fecha,local,producto)).apply();
    }

    public void eliminarPedido(PedidoId pedidoId){
        appendChange(new PedidoEliminado(pedidoId)).apply();
    }

    public void actualizarPedido(PedidoId pedidoId){
        appendChange(new PedidoActualizado(pedidoId)).apply();
    }

}
