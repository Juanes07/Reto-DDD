package co.com.cafeteria.procesos.empleado.events;


import co.com.cafeteria.procesos.empleado.values.ContratoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * Evento De Dominio ContratoAgregado
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

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
