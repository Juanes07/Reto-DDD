package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

public class EmpleadoAgregado extends DomainEvent {
    private final Contrato contrato;
    private final Nombre nombre;
    private final Rol rol;
    private final Uniforme uniforme;

    public EmpleadoAgregado(Contrato contrato, Nombre nombre, Rol rol, Uniforme uniforme) {
        super("co.com.cafeteria.procesos.EmpleadoAgregado");
        this.contrato = contrato;
        this.nombre = nombre;
        this.rol = rol;
        this.uniforme = uniforme;
    }

    public Contrato Contrato() {
        return contrato;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Rol Rol() {
        return rol;
    }

    public Uniforme Uniforme() {
        return uniforme;
    }
}
