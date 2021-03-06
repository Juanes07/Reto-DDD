package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.Command;
import generic.Nombre;

public class AgregarEmpleado extends Command {
    private final EmpleadoId empleadoId;
    private final Contrato contrato;
    private final Nombre nombre;
    private final Rol rol;
    private final Uniforme uniforme;

    public AgregarEmpleado(EmpleadoId empleadoId, Contrato contrato, Nombre nombre, Rol rol, Uniforme uniforme) {
        this.empleadoId = empleadoId;
        this.contrato = contrato;
        this.nombre = nombre;
        this.rol = rol;
        this.uniforme = uniforme;
    }

    public EmpleadoId empleadoId() {
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

    public Uniforme Uniforme() {
        return uniforme;
    }
}
