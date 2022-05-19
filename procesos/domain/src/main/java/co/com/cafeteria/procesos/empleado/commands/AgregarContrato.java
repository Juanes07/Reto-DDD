package co.com.cafeteria.procesos.empleado.commands;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import co.com.sofka.domain.generic.Command;

public class AgregarContrato extends Command {
    private final EmpleadoId empleadoId;
    private final TipoDeContrato tipoDeContrato;

    public AgregarContrato(EmpleadoId empleadoId, TipoDeContrato tipoDeContrato) {
        this.empleadoId = empleadoId;
        this.tipoDeContrato = tipoDeContrato;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public TipoDeContrato TipoDeContrato() {
        return tipoDeContrato;
    }
}
