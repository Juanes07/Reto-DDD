package co.com.cafeteria.procesos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;


/**
 * Objeto de valor Documento
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Documento implements ValueObject<String> {
    /**
     * caracteristica
     */
    private final String documento;

    /**
     * Constructor documento
     * @param documento tipo String
     */
    public Documento(String documento) {
        this.documento = documento;

    }

    @Override
    public String value() {
        return documento;
    }
}
