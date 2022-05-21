package co.com.cafeteria.procesos.empleado.events;

import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * Evento De Dominio UniformeEmpleadoAgregado
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class UniformeEmpleadoAgregado extends DomainEvent {
    private final Uniforme uniforme;
    private final EmpleadoId empleadoId;

    public UniformeEmpleadoAgregado(Uniforme uniforme, EmpleadoId empleadoId) {
        super("co.com.cafeteria.procesos.UniformeEmpleadoAgregado");
        this.uniforme = uniforme;
        this.empleadoId = empleadoId;
    }

    public Uniforme Uniforme() {
        return uniforme;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }
}
