package co.com.cafeteria.procesos.empleado.values;

import co.com.sofka.domain.generic.Identity;

public class UniformeId extends Identity {
    public UniformeId(String id) {
        super(id);
    }
    public static UniformeId of(String id) {
        return new UniformeId(id);
    }
}
