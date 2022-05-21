package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Objeto de valor TipoDeContrato
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class TipoDeContrato implements ValueObject<String> {

    /**
     * Caracteristicas
     */
    private final String tipoDeContrato;
    private final String horasDeTrabajo;

    /**
     * Constructor TipoDeContrato
     *
     * @param tipoDeContrato tipo String
     * @param horasDeTrabajo tipo String
     */

    public TipoDeContrato(String tipoDeContrato, String horasDeTrabajo) {
        this.tipoDeContrato = tipoDeContrato;
        this.horasDeTrabajo = horasDeTrabajo;
    }

    @Override
    public String value() {
        return tipoDeContrato;
    }
}
