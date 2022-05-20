package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeContrato implements ValueObject<String> {
    private final String tipoDeContrato;
    private final String horasDeTrabajo;

    public TipoDeContrato(String tipoDeContrato, String horasDeTrabajo) {
        this.tipoDeContrato = tipoDeContrato;
        this.horasDeTrabajo = horasDeTrabajo;
    }

    @Override
    public String value() {
        return tipoDeContrato;
    }
}
