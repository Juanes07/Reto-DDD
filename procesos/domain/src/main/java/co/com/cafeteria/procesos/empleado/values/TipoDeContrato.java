package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeContrato implements ValueObject<String> {
    private final String tipoDeContrato;
    private final String HorasDeTrabajo;

    public TipoDeContrato(String tipoDeContrato, String horasDeTrabajo) {
        this.tipoDeContrato = Objects.requireNonNull(tipoDeContrato);
        if(this.tipoDeContrato.isBlank()){
            throw new IllegalArgumentException("El tipo de contrato no puede estar vacio");
        }
        this.HorasDeTrabajo = Objects.requireNonNull(horasDeTrabajo);
        if(this.HorasDeTrabajo.isBlank()){
            throw new IllegalArgumentException("Las horas de trabajo no deben estar vacias");
        }
    }

    @Override
    public String value() {
        return tipoDeContrato;
    }
}
