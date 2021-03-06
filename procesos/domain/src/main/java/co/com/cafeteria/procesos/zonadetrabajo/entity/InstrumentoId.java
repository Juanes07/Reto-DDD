package co.com.cafeteria.procesos.zonadetrabajo.entity;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.Identity;

public class InstrumentoId extends Identity {
    public InstrumentoId(String id) {
        super(id);
    }

    public static InstrumentoId of(String id) {
        return new InstrumentoId(id);
    }

}
