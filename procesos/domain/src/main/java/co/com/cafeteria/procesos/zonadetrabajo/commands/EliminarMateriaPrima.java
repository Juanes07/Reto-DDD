package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.value.MateriaPrimaId;
import co.com.sofka.domain.generic.Command;

public class EliminarMateriaPrima extends Command {

    private  final MateriaPrimaId materiaPrimaId;

    public EliminarMateriaPrima(MateriaPrimaId materiaPrimaId) {
        this.materiaPrimaId = materiaPrimaId;
    }

    public MateriaPrimaId MateriaPrimaId() {
        return materiaPrimaId;
    }
}
