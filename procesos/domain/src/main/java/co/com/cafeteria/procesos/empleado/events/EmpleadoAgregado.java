package co.com.cafeteria.procesos.empleado.events;

import generic.Nombre;
import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.sofka.domain.generic.DomainEvent;

public class EmpleadoAgregado extends DomainEvent {
    private final Nombre nombre;
    private final Contrato contrato;
    private final Rol rol;
    private final Uniforme uniforme;

    public EmpleadoAgregado(Nombre nombre, Contrato contrato, Rol rol, Uniforme uniforme) {
        super("co.com.cafeteria.procesos.EmpleadoAgregado");
        this.nombre = nombre;
        this.contrato = contrato;
        this.rol = rol;
        this.uniforme = uniforme;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public Rol getRol() {
        return rol;
    }

    public Uniforme getUniforme() {
        return uniforme;
    }
}
