package co.com.cafeteria.procesos.pedido.entity;

import co.com.cafeteria.procesos.pedido.values.LocalId;
import co.com.cafeteria.procesos.pedido.values.Ubicacion;
import co.com.sofka.domain.generic.Entity;

public class Local extends Entity<LocalId> {
    protected Ubicacion ubicacion;

    public Local(LocalId id, Ubicacion ubicacion) {
        super(id);
        this.ubicacion = ubicacion;
    }

}
