package co.com.cafeteria.procesos.empleado.commands;

import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import co.com.sofka.domain.generic.Command;
import generic.Nombre;

public class AgregarContrato extends Command {
    protected EmpleadoId empleadoId;
    protected Nombre nombre;
    protected Rol rol;
    protected Uniforme uniforme;
    protected TipoDeContrato tipoDeContrato;

    public AgregarContrato(EmpleadoId id, Nombre nombre, Rol rol, Uniforme uniforme, TipoDeContrato tipoDeContrato) {
        this.empleadoId = id;
        this.nombre = nombre;
        this.rol = rol;
        this.uniforme = uniforme;
        this.tipoDeContrato = tipoDeContrato;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
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

    public TipoDeContrato TipoDeContrato() {
        return tipoDeContrato;
    }
}
