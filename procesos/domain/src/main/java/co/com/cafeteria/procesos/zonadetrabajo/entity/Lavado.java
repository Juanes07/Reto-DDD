package co.com.cafeteria.procesos.zonadetrabajo.entity;

import co.com.cafeteria.procesos.pedido.values.Ubicacion;
import co.com.cafeteria.procesos.zonadetrabajo.value.LavadoId;
import co.com.sofka.domain.generic.Entity;

public class Lavado extends Entity<LavadoId> {
    protected Ubicacion ubicacion;

    public Lavado(LavadoId id, Ubicacion ubicacion) {
        super(id);
        this.ubicacion = ubicacion;
    }

}
