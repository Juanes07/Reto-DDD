package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.events.ContratoAgregado;
import co.com.sofka.domain.generic.EventChange;

public class EmpleadoEventChange extends EventChange {
    public EmpleadoEventChange(Empleado empleado) {
        apply((ContratoAgregado event) -> {
            var contrato = new Contrato(event.getContratoId(),event.getTipoDeContrato());
            empleado.contrato = contrato;
        });
    }
}
