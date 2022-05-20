package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.entity.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.EmpleadoEliminado;
import co.com.cafeteria.procesos.zonadetrabajo.events.InstrumentoAgregado;
import co.com.cafeteria.procesos.zonadetrabajo.events.InstrumentoEliminado;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoAgregada;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

import java.util.List;

public class ZonaDeTrabajo extends AggregateEvent<ZonaDeTrabajoId> {
    protected EmpleadoId empleadoId;
    protected Instrumento instrumento;
    protected PedidoId pedidoId;
    protected MateriaPrima materiaPrima;
    protected Lavado lavado;

    public ZonaDeTrabajo(ZonaDeTrabajoId id, EmpleadoId empleadoId, Instrumento instrumento, PedidoId pedidoId, MateriaPrima materiaPrima, ZonaDeTrabajoId zonaDeTrabajoId, Lavado lavado) {
        super(id);
        appendChange(new ZonaDeTrabajoAgregada(empleadoId,pedidoId,instrumento, materiaPrima, zonaDeTrabajoId, lavado));
        subscribe(new ZonaDeTrabajoEventChange(this));
    }

    public ZonaDeTrabajo(ZonaDeTrabajoId zonaDeTrabajoId){
        super(zonaDeTrabajoId);
        subscribe(new ZonaDeTrabajoEventChange(this));
    }



    public static ZonaDeTrabajo from(ZonaDeTrabajoId zonaDeTrabajoId, List<DomainEvent> events){
        var zonaDeTrabajo = new ZonaDeTrabajo(zonaDeTrabajoId);
        events.forEach(zonaDeTrabajo::applyEvent);
        return zonaDeTrabajo;
    }

    public void agregarInstrumento(ZonaDeTrabajoId zonaDeTrabajoId , InstrumentoId instrumentoId, Nombre nombre, Categoria categoria){
        appendChange(new InstrumentoAgregado(zonaDeTrabajoId, instrumentoId, nombre,categoria)).apply();
    }

    public void eliminarInstrumento(ZonaDeTrabajoId zonaDeTrabajoId, InstrumentoId instrumentoId){
        appendChange(new InstrumentoEliminado(zonaDeTrabajoId,instrumentoId)).apply();
    }

    public void eliminarEmpleado(ZonaDeTrabajoId zonaDeTrabajoId, EmpleadoId empleadoId){
        appendChange(new EmpleadoEliminado(zonaDeTrabajoId,empleadoId)).apply();
    }
}
