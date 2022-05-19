package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaDeTrabajoAgregada extends DomainEvent {

    private final EmpleadoId empleadoId;
    private final PedidoId pedidoId;
    private final Instrumento instrumento;

    public ZonaDeTrabajoAgregada(EmpleadoId empleadoId, PedidoId pedidoId, Instrumento instrumento) {
        super("co.com.cafeteria.procesos.ZonaDeTrabajoAgregada");
        this.empleadoId = empleadoId;
        this.pedidoId = pedidoId;
        this.instrumento = instrumento;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public PedidoId PedidoId() {
        return pedidoId;
    }

    public Instrumento Instrumento() {
        return instrumento;
    }
}
