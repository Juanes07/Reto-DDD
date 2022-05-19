package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.MateriaPrima;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoAgregada;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class ZonaDeTrabajo extends AggregateEvent<ZonaDeTrabajoId> {
    protected EmpleadoId empleadoId;
    protected Instrumento instrumento;
    protected PedidoId pedidoId;
    protected List<MateriaPrima> materiaPrima;

    public ZonaDeTrabajo(ZonaDeTrabajoId id, EmpleadoId empleadoId, Instrumento instrumento, PedidoId pedidoId) {
        super(id);
        appendChange(new ZonaDeTrabajoAgregada(empleadoId,pedidoId,instrumento));
        subscribe(new ZonaDeTrabajoEventChange(this));
    }

    public ZonaDeTrabajo(ZonaDeTrabajoId zonaDeTrabajoId){
        super(zonaDeTrabajoId);
        subscribe(new ZonaDeTrabajoEventChange(this));
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public Instrumento Instrumento() {
        return instrumento;
    }

    public PedidoId PedidoId() {
        return pedidoId;
    }

    public List<MateriaPrima> MateriaPrima() {
        return materiaPrima;
    }
}
