package co.com.cafeteria.procesos.empleado.commands;

import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.values.Descripcion;
import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.Command;

public class AgregarUniformeEmpleado extends Command {
    private final EmpleadoId empleadoId;
    private final Uniforme uniforme;

    public AgregarUniformeEmpleado(EmpleadoId empleadoId, Uniforme uniforme) {
        this.empleadoId = empleadoId;
        this.uniforme = uniforme;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public Uniforme uniforme() {
        return uniforme;
    }
}
