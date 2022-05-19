package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeCaducidad;
import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeProduccion;
import co.com.sofka.domain.generic.Command;
import generic.Nombre;

public class AgregarMateriaPrima extends Command {
    private final Nombre nombre;
    private final FechaDeCaducidad fechaDeCaducidad;
    private final FechaDeProduccion fechaDeProduccion;

    public AgregarMateriaPrima(Nombre nombre, FechaDeCaducidad fechaDeCaducidad, FechaDeProduccion fechaDeProduccion) {
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
}
