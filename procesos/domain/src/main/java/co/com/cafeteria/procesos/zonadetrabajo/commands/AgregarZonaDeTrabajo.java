package co.com.cafeteria.procesos.zonadetrabajo.commands;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.MateriaPrima;
import co.com.sofka.domain.generic.Command;

import java.util.List;


public class AgregarZonaDeTrabajo extends Command {

    private final EmpleadoId empleadoId;
    private final PedidoId pedidoId;
    private final Instrumento instrumento;
    private final List<MateriaPrima> materiaPrima;

    public AgregarZonaDeTrabajo(EmpleadoId empleadoId, PedidoId pedidoId, Instrumento instrumento, List<MateriaPrima> materiaPrima) {
        this.empleadoId = empleadoId;
        this.pedidoId = pedidoId;
        this.instrumento = instrumento;
        this.materiaPrima = materiaPrima;
    }

    public EmpleadoId EmpleadoId() {
        return empleadoId;
    }

    public PedidoId PedidoId() {
        return pedidoId;
    }

    public Instrumento Instrumento() {
        return instrumento;
    }

    public List<MateriaPrima> MateriaPrima() {
        return materiaPrima;
    }
}
