package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoAgregada;
import co.com.sofka.domain.generic.EventChange;

/**
 * Evento de cambios ZonaDeTrabajo
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class ZonaDeTrabajoEventChange extends EventChange {
    public ZonaDeTrabajoEventChange(ZonaDeTrabajo zonaDeTrabajo) {
        apply((ZonaDeTrabajoAgregada event) -> {
            zonaDeTrabajo.empleadoId = event.EmpleadoId();
            zonaDeTrabajo.instrumento = event.Instrumento();
            zonaDeTrabajo.pedidoId = event.PedidoId();
            zonaDeTrabajo.materiaPrima = event.getMateriaPrima();
        });
    }
}
