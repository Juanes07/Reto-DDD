package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.Command;

public class EliminarEmpleado extends Command {
    private final ZonaDeTrabajoId zonaDeTrabajoId;
    private final EmpleadoId empleadoId;

    public EliminarEmpleado(ZonaDeTrabajoId zonaDeTrabajoId, EmpleadoId empleadoId) {
        this.zonaDeTrabajoId = zonaDeTrabajoId;
        this.empleadoId = empleadoId;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public ZonaDeTrabajoId getZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }
}
