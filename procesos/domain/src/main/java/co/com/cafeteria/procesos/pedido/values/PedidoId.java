package co.com.cafeteria.procesos.pedido.values;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.Identity;

public class PedidoId extends Identity {
    public PedidoId(String id) {
        super(id);
    }

    public static PedidoId of(String id) {
        return new PedidoId(id);
    }
}
