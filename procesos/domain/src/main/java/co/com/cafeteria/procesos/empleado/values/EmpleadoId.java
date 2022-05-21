package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.Identity;


/**
 * Agregado Pedido
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */


public class EmpleadoId extends Identity {

    /**
     * caracteristicas
     * @param id tipo String
     */
    public EmpleadoId(String id) {
        super(id);
    }

    public static EmpleadoId of(String id) {
        return new EmpleadoId(id);
    }
}
