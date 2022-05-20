package co.com.cafeteria.procesos.empleado.events;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.values.ContratoId;
import co.com.cafeteria.procesos.empleado.values.TipoDeContrato;
import generic.Nombre;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.sofka.domain.generic.DomainEvent;

public class ContratoAgregado extends DomainEvent {
    private final Contrato contrato;
    private final Nombre nombre;
    private final Rol rol;
    private final Uniforme uniforme;


    public ContratoAgregado(Contrato contrato, Nombre nombre, Rol rol, Uniforme uniforme) {
        super("co.com.cafeteria.procesos.ContratoAgregado");
        this.contrato = contrato;
        this.nombre = nombre;
        this.rol = rol;
        this.uniforme = uniforme;
    }



    public Contrato contrato() {
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
