package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Lavado;
import co.com.cafeteria.procesos.zonadetrabajo.entity.MateriaPrima;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaDeTrabajoAgregada extends DomainEvent {

    private final EmpleadoId empleadoId;
    private final PedidoId pedidoId;
    private final Instrumento instrumento;
    private final MateriaPrima materiaPrima;
    private final ZonaDeTrabajoId zonaDeTrabajoId;
    private final Lavado lavado;

    public ZonaDeTrabajoAgregada(EmpleadoId empleadoId, PedidoId pedidoId, Instrumento instrumento, MateriaPrima materiaPrima, ZonaDeTrabajoId zonaDeTrabajoId, Lavado lavado) {
        super("co.com.cafeteria.procesos.ZonaDeTrabajoAgregada");
        this.empleadoId = empleadoId;
        this.pedidoId = pedidoId;
        this.instrumento = instrumento;
        this.materiaPrima = materiaPrima;
        this.zonaDeTrabajoId = zonaDeTrabajoId;
        this.lavado = lavado;
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

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public ZonaDeTrabajoId getZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }

    public Lavado getLavado() {
        return lavado;
    }
}
