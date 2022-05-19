package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.Command;

public class EliminarEmpleado extends Command {
    private final EmpleadoId empleadoId;

    public EliminarEmpleado(EmpleadoId empleadoId) {
        this.empleadoId = empleadoId;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }
}
