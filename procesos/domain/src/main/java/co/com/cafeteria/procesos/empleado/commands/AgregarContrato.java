package co.com.cafeteria.procesos.empleado.commands;

import co.com.cafeteria.procesos.empleado.values.ContratoId;
import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import co.com.sofka.domain.generic.Command;

/**
 * Comando AgregarContrato
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarContrato extends Command {
    private final EmpleadoId empleadoId;
    private final ContratoId contratoId;
    private final TipoDeContrato tipoDeContrato;

    public AgregarContrato(EmpleadoId id, ContratoId contratoId, TipoDeContrato tipoDeContrato) {
        this.empleadoId = id;
        this.contratoId = contratoId;
        this.tipoDeContrato = tipoDeContrato;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public ContratoId ContratoId() {
        return contratoId;
    }

    public TipoDeContrato TipoDeContrato() {
        return tipoDeContrato;
    }
}
