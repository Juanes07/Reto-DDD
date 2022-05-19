package co.com.cafeteria.procesos.empleado.entity;

import co.com.cafeteria.procesos.empleado.values.ContratoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import co.com.sofka.domain.generic.Entity;

public class Contrato extends Entity<ContratoId> {
    protected TipoDeContrato tipoDeContrato;

    public Contrato(ContratoId id, TipoDeContrato tipoDeContrato) {
        super(id);
        this.tipoDeContrato = tipoDeContrato;
    }

    public void crearTipoDeContrato(String tipoDeContrato, String horasDeTrabajo){
        this.tipoDeContrato = new TipoDeContrato(tipoDeContrato, horasDeTrabajo);
    }
}
