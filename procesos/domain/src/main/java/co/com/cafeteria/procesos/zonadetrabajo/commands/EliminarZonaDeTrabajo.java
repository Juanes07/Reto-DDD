package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.Command;

public class EliminarZonaDeTrabajo extends Command {

    private final ZonaDeTrabajoId zonaDeTrabajoId;

    public EliminarZonaDeTrabajo(ZonaDeTrabajoId zonaDeTrabajoId) {
        this.zonaDeTrabajoId = zonaDeTrabajoId;
    }

    public ZonaDeTrabajoId ZonaDeTrabajoId() {
        return zonaDeTrabajoId;
    }
}
