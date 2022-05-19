package co.com.cafeteria.procesos.zonadetrabajo.value;

import co.com.cafeteria.procesos.pedido.values.Fecha;
import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class FechaDeProduccion implements ValueObject<Fecha.Pros> {

    private final LocalDateTime hora;
    private final LocalDate dia;


    public FechaDeProduccion(LocalDateTime hora, LocalDate dia) {
        this.hora = Objects.requireNonNull(hora);
        this.dia = Objects.requireNonNull(dia);
    }



    @Override
    public Fecha.Pros value() {
        return new Fecha.Pros() {
            @Override
            public LocalDateTime hora() {
                return hora;
            }

            @Override
            public LocalDate dia() {
                return dia;
            }

        };
    }


    public interface Pros {

        LocalDateTime hora();

        LocalDate dia();
    }
}
