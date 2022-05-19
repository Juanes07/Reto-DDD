package co.com.cafeteria.procesos.zonadetrabajo.events;

import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeCaducidad;
import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeProduccion;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;

public class MateriaPrimaAgregada extends DomainEvent {
    private final Nombre nombre;
    private final FechaDeCaducidad fechaDeCaducidad;
    private final FechaDeProduccion fechaDeProduccion;

    public MateriaPrimaAgregada(Nombre nombre, FechaDeCaducidad fechaDeCaducidad, FechaDeProduccion fechaDeProduccion) {
        super("co.com.cafeteria.procesos.MateriaPrimaAgregada");
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
