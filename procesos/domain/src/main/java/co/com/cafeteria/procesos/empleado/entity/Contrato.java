package co.com.cafeteria.procesos.empleado.entity;

import co.com.cafeteria.procesos.empleado.values.ContratoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import co.com.sofka.domain.generic.Entity;

/**
 * Entidad Contrato
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Contrato extends Entity<ContratoId> {
    protected TipoDeContrato tipoDeContrato;

    public Contrato(ContratoId id, TipoDeContrato tipoDeContrato) {
        super(id);
        this.tipoDeContrato = tipoDeContrato;
    }
}
