package co.com.cafeteria.procesos.empleado.commands;

import co.com.cafeteria.procesos.empleado.Nombre;
import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.values.EmpleadoId;
import co.com.sofka.domain.generic.Command;

public class AgregarRolEmpleado extends Command {
    private final EmpleadoId empleadoId;
    private final Contrato contrato;
    private final Nombre nombre;
    private final Rol rol;

    public AgregarRolEmpleado(EmpleadoId empleadoId, Contrato contrato, Nombre nombre, Rol rol) {
        this.empleadoId = empleadoId;
        this.contrato = contrato;
        this.nombre = nombre;
        this.rol = rol;
    }


    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public Contrato Contrato() {
        return contrato;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Rol Rol() {
        return rol;
    }
}
