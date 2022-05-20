package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class PedidoEventChange extends EventChange {

    public PedidoEventChange(Pedido pedido){
        apply((PedidoCreado event)->{
            pedido.cliente = event.Cliente();
            pedido.fecha = event.Fecha();
            pedido.local = event.Local();
            pedido.producto = new HashSet<>();
        });
    }
}
