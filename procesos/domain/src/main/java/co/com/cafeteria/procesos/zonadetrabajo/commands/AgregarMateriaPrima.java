package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeCaducidad;
import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeProduccion;
import co.com.cafeteria.procesos.zonadetrabajo.value.MateriaPrimaId;
import co.com.sofka.domain.generic.Command;
import generic.Nombre;

public class AgregarMateriaPrima extends Command {
    private final MateriaPrimaId materiaPrimaId;
    private final Nombre nombre;
    private final FechaDeCaducidad fechaDeCaducidad;
    private final FechaDeProduccion fechaDeProduccion;

    public AgregarMateriaPrima(MateriaPrimaId materiaPrimaId, Nombre nombre, FechaDeCaducidad fechaDeCaducidad, FechaDeProduccion fechaDeProduccion) {
        this.materiaPrimaId = materiaPrimaId;
        this.nombre = nombre;
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.fechaDeProduccion = fechaDeProduccion;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public FechaDeCaducidad FechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public FechaDeProduccion FechaDeProduccion() {
        return fechaDeProduccion;
    }

    public MateriaPrimaId MateriaPrimaId() {
        return materiaPrimaId;
    }
}
