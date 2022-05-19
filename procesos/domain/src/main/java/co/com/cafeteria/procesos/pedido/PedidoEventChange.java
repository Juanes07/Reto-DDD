package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.events.PedidoAgregado;
import co.com.sofka.domain.generic.EventChange;
import jdk.jfr.Event;

public class PedidoEventChange extends EventChange {

    public PedidoEventChange(Pedido pedido){
        apply((PedidoAgregado event)->{
            pedido.cliente = event.Cliente();
            pedido.fecha = event.Fecha();
            pedido.local = event.Local();
        });
    }
}
