package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.entity.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.*;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

import java.util.List;

/**
 * Agregado ZonaDeTrabajo
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class ZonaDeTrabajo extends AggregateEvent<ZonaDeTrabajoId> {

    /**
     * caracteristicas
     */

    protected EmpleadoId empleadoId;
    protected Instrumento instrumento;
    protected PedidoId pedidoId;
    protected MateriaPrima materiaPrima;
    protected Lavado lavado;

    /**
     * constructor ZonaDeTrabajo
     * @param id tipo ZonaDeTrabajoId
     * @param empleadoId tipo EmpleadoId
     * @param instrumento tipo Instrumento
     * @param pedidoId tipo PedidoId
     * @param materiaPrima tpo MateriaPrima
     * @param zonaDeTrabajoId tipo ZonaDeTrabajoId
     * @param lavado tipo Lavado
     */
    public ZonaDeTrabajo(ZonaDeTrabajoId id, EmpleadoId empleadoId, Instrumento instrumento, PedidoId pedidoId, MateriaPrima materiaPrima, ZonaDeTrabajoId zonaDeTrabajoId, Lavado lavado) {
        super(id);
        appendChange(new ZonaDeTrabajoAgregada(empleadoId, pedidoId, instrumento, materiaPrima, zonaDeTrabajoId, lavado));
        subscribe(new ZonaDeTrabajoEventChange(this));
    }

    public ZonaDeTrabajo(ZonaDeTrabajoId zonaDeTrabajoId) {
        super(zonaDeTrabajoId);
        subscribe(new ZonaDeTrabajoEventChange(this));
    }


    public static ZonaDeTrabajo from(ZonaDeTrabajoId zonaDeTrabajoId, List<DomainEvent> events) {
        var zonaDeTrabajo = new ZonaDeTrabajo(zonaDeTrabajoId);
        events.forEach(zonaDeTrabajo::applyEvent);
        return zonaDeTrabajo;
    }

    /**
     * Comportamiento AgregarInstrumento a Zona de trabajo
     * @param zonaDeTrabajoId
     * @param instrumentoId
     * @param nombre
     * @param categoria
     */
    public void agregarInstrumento(ZonaDeTrabajoId zonaDeTrabajoId, InstrumentoId instrumentoId, Nombre nombre, Categoria categoria) {
        appendChange(new InstrumentoAgregado(zonaDeTrabajoId, instrumentoId, nombre, categoria)).apply();
    }

    /**
     * comportamiento EliminarInstrumento de zona de trabajo
     * @param zonaDeTrabajoId
     * @param instrumentoId
     */

    public void eliminarInstrumento(ZonaDeTrabajoId zonaDeTrabajoId, InstrumentoId instrumentoId) {
        appendChange(new InstrumentoEliminado(zonaDeTrabajoId, instrumentoId)).apply();
    }

    /**
     * comportamiento EliminarEmpleado de zona de trabajo
     * @param zonaDeTrabajoId
     * @param empleadoId
     */

    public void eliminarEmpleado(ZonaDeTrabajoId zonaDeTrabajoId, EmpleadoId empleadoId) {
        appendChange(new EmpleadoEliminado(zonaDeTrabajoId, empleadoId)).apply();
    }

    /**
     * Comportamiento ActualizarZonaDeTrabajo
     * @param zonaDeTrabajoId
     */

    public void actualizarZonaDeTrabajo(ZonaDeTrabajoId zonaDeTrabajoId) {
        appendChange(new ZonaDeTrabajoActualizada(zonaDeTrabajoId)).apply();
    }
}
