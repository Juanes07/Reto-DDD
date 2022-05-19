package co.com.cafeteria.procesos.empleado.entity;

import co.com.cafeteria.procesos.values.Descripcion;
import co.com.cafeteria.procesos.values.UniformeId;
import co.com.sofka.domain.generic.Entity;

public class Uniforme extends Entity<UniformeId> {
    protected Descripcion descripcion;

    public Uniforme(UniformeId id, Descripcion descripcion) {
        super(id);
        this.descripcion = descripcion;
    }

    public void agregarUniforme(String descripcion){
        this.descripcion = new Descripcion(descripcion);
    }
}
