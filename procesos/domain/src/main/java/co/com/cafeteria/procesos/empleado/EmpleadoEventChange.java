package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.events.ContratoAgregado;
import co.com.sofka.domain.generic.EventChange;

public class EmpleadoEventChange extends EventChange {
    public EmpleadoEventChange(Empleado empleado) {
        apply((ContratoAgregado event) -> {
            empleado.contrato = event.contrato();
            empleado.nombre = event.Nombre();
            empleado.rol = event.Rol();
            empleado.uniforme = event.Uniforme();
        });
    }
}
