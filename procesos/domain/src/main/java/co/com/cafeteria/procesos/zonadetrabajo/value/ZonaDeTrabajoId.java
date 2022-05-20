package co.com.cafeteria.procesos.zonadetrabajo.value;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.Identity;

public class ZonaDeTrabajoId extends Identity {
    public ZonaDeTrabajoId(String id) {
        super(id);
    }

    public static ZonaDeTrabajoId of(String id) {
        return new ZonaDeTrabajoId(id);
    }
}
