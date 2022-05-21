package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor Precio
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Precio implements ValueObject<String> {
    /**
     * caracteristicas
     */
    private final String precio;

    /**
     * Constructor precio
     * @param precio
     */

    public Precio(String precio) {
        this.precio = precio;
    }

    @Override
    public String value() {
        return precio;
    }
}
