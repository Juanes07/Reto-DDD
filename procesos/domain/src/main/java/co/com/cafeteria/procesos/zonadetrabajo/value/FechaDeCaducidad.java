package co.com.cafeteria.procesos.zonadetrabajo.value;

import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class FechaDeCaducidad implements ValueObject<FechaDeCaducidad.Pros> {

    private final LocalDate dia;


    public FechaDeCaducidad(LocalDate dia) {
        this.dia = Objects.requireNonNull(dia);
    }


    @Override
    public FechaDeCaducidad.Pros value() {
        return new FechaDeCaducidad.Pros() {
            @Override
            public LocalDate dia() {
                return dia;
            }
        };
    }


    public interface Pros {
        LocalDate dia();
    }
}

