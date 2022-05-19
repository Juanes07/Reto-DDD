package co.com.cafeteria.procesos.pedido.entity;

import co.com.sofka.domain.generic.Entity;

public class Local extends Entity<LocalId> {
    protected Ubicacion ubicacion;

    public Local(LocalId id, Ubicacion ubicacion) {
        super(id);
        this.ubicacion = ubicacion;
    }

    public void agregarLocal(String ubicacion){
        this.ubicacion = new Ubicacion(ubicacion);
    }
}
