package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.value.MateriaPrimaId;
import co.com.sofka.domain.generic.DomainEvent;

public class MateriaPrimaEliminada extends DomainEvent {
    private final MateriaPrimaId materiaPrimaId;

    public MateriaPrimaEliminada(MateriaPrimaId materiaPrimaId) {
        super("co.com.cafeteria.procesos.MateriaPrimaEliminada");
        this.materiaPrimaId = materiaPrimaId;
    }

    public MateriaPrimaId MateriaPrimaId() {
        return materiaPrimaId;
    }
}
