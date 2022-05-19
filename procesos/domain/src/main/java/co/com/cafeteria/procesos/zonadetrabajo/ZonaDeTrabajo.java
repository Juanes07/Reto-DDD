package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.MateriaPrima;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class ZonaDeTrabajo extends AggregateEvent<ZonaDeTrabajoId> {
    protected EmpleadoId empleadoId;
    protected Instrumento instrumento;
    protected PedidoId pedidoId;
    protected List<MateriaPrima> materiaPrima;




}
