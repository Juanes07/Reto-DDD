package co.com.cafeteria.procesos.pedido.events;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoAgregado extends DomainEvent {
    private final Cliente cliente;
    private final Fecha fecha;
    private final Local local;

    public PedidoAgregado(Cliente cliente, Fecha fecha, Local local) {
        super("co.com.cafeteria.procesos.PedidoAgregado");
        this.cliente = cliente;
        this.fecha = fecha;
        this.local = local;
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
}
