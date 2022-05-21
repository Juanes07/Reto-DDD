package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor ubicacion
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Ubicacion implements ValueObject<String> {
    /**
     * caracteristicas
     */
    private final String ubicacion;

    /**
     * constructor Ubicacion
     * @param ubicacion de tipo String
     */
    public Ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String value() {
        return ubicacion;
    }
}
