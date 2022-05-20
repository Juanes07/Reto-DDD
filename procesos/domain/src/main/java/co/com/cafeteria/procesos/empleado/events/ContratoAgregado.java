package co.com.cafeteria.procesos.empleado.events;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.values.ContratoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import generic.Nombre;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.sofka.domain.generic.DomainEvent;

public class ContratoAgregado extends DomainEvent {

    private final ContratoId contratoId;
    private final TipoDeContrato tipoDeContrato;


    public ContratoAgregado(ContratoId contratoId, TipoDeContrato tipoDeContrato) {
        super("co.com.cafeteria.procesos.ContratoAgregado");
        this.contratoId = contratoId;
        this.tipoDeContrato = tipoDeContrato;
    }


    public ContratoId getContratoId() {
        return contratoId;
    }

    public TipoDeContrato getTipoDeContrato() {
        return tipoDeContrato;
    }
}
