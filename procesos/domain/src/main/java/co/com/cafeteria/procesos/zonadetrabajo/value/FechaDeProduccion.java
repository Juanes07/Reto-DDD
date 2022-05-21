package co.com.cafeteria.procesos.zonadetrabajo.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Objeto de valor FechaDeProduccion
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class FechaDeProduccion implements ValueObject<FechaDeProduccion.Pros> {
    /**
     * caracteristicas
     */
    private final LocalDateTime hora;
    private final LocalDate dia;

    /**
     * constructor FechaDeProduccion
     *
     * @param hora
     * @param dia
     */


    public FechaDeProduccion(LocalDateTime hora, LocalDate dia) {
        this.hora = Objects.requireNonNull(hora);
        this.dia = Objects.requireNonNull(dia);
    }


    @Override
    public FechaDeProduccion.Pros value() {
        return new FechaDeProduccion.Pros() {
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
