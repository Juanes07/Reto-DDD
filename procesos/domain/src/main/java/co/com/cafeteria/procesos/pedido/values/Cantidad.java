package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

/**
 * Objeto de valor cantidad
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Cantidad implements ValueObject<String> {
    /**
     * caracteristica cantidad
     */
    private final String cantidad;

    /**
     * constructor cantidad
     *
     * @param cantidad tipo String
     */
    public Cantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String value() {
        return cantidad;
    }
}
