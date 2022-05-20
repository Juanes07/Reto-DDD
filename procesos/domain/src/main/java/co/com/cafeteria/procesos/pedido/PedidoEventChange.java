package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class PedidoEventChange extends EventChange {

    public PedidoEventChange(Pedido pedido){
        apply((PedidoCreado event)->{
            pedido.cliente = event.getCliente();
            pedido.fecha = event.getFecha();
            pedido.local = event.getLocal();
            pedido.producto = event.getProducto();
        });
    }
}
