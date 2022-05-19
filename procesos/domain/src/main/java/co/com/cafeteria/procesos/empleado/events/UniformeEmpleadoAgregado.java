package co.com.cafeteria.procesos.empleado.events;

import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.sofka.domain.generic.DomainEvent;

public class UniformeEmpleadoAgregado extends DomainEvent {
    private final Uniforme uniforme;

    public UniformeEmpleadoAgregado(Uniforme uniforme) {
        super("co.com.cafeteria.procesos.UniformeEmpleadoAgregado");
        this.uniforme = uniforme;
    }

    public Uniforme Uniforme() {
        return uniforme;
    }
}
