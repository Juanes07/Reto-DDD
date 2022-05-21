package co.com.cafeteria.procesos.empleado.entity;

import co.com.cafeteria.procesos.empleado.values.NombreRol;
import co.com.cafeteria.procesos.empleado.values.RolId;
import co.com.sofka.domain.generic.Entity;

/**
 * Entidad Rol
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Rol extends Entity<RolId> {
    protected NombreRol nombreRol;

    public Rol(RolId id, NombreRol nombreRol) {
        super(id);
        this.nombreRol = nombreRol;
    }

//    public void agregarRol(String nombreRol){
//        this.nombreRol = new NombreRol(nombreRol);
//    }
}
