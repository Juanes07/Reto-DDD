package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.events.EmpleadoAgregado;
import co.com.sofka.domain.generic.EventChange;

public class EmpleadoEventChange extends EventChange {
    public EmpleadoEventChange(Empleado empleado) {
        apply((EmpleadoAgregado event) -> {
            empleado.contrato = event.getContrato();
            empleado.nombre = event.getNombre();
            empleado.rol = event.getRol();
            empleado.uniforme = event.getUniforme();
        });
    }
}
