package co.com.cafeteria.procesos.empleado.entity;

import co.com.cafeteria.procesos.empleado.values.Descripcion;
import co.com.cafeteria.procesos.empleado.values.UniformeId;
import co.com.sofka.domain.generic.Entity;


/**
 * Entidad Uniforme
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Uniforme extends Entity<UniformeId> {
    protected Descripcion descripcion;

    public Uniforme(UniformeId id, Descripcion descripcion) {
        super(id);
        this.descripcion = descripcion;
    }

}
