package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.events.ContratoAgregado;
import co.com.sofka.domain.generic.EventChange;

/**
 * Cambios de Evento Empleado
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class EmpleadoEventChange extends EventChange {
    public EmpleadoEventChange(Empleado empleado) {
        apply((ContratoAgregado event) -> {
            var contrato = new Contrato(event.getContratoId(), event.getTipoDeContrato());
            empleado.contrato = contrato;
        });
    }
}
