package co.com.cafeteria.procesos.zonadetrabajo.entity;

import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeCaducidad;
import co.com.cafeteria.procesos.zonadetrabajo.value.FechaDeProduccion;
import co.com.cafeteria.procesos.zonadetrabajo.value.MateriaPrimaId;
import co.com.sofka.domain.generic.Entity;
import generic.Nombre;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MateriaPrima extends Entity<MateriaPrimaId> {
    protected Nombre nombre;
    protected FechaDeProduccion fechaDeProduccion;
    protected FechaDeCaducidad fechaDeCaducidad;

    public MateriaPrima(MateriaPrimaId id, Nombre nombre, FechaDeProduccion fechaDeProduccion, FechaDeCaducidad fechaDeCaducidad) {
        super(id);
        this.nombre = nombre;
        this.fechaDeProduccion = fechaDeProduccion;
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public void asignarFechaDeProduccion(LocalDateTime horaProduccion, LocalDate diaProduccion){
        this.fechaDeProduccion = new FechaDeProduccion(horaProduccion, diaProduccion);

    }

    public void asignarFechaCaducidad(LocalDate diaCaducidad){
        this.fechaDeCaducidad = new FechaDeCaducidad(diaCaducidad);
    }
}
