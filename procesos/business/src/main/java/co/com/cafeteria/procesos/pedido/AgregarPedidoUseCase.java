package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.commands.AgregarPedido;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.Precio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.List;
import java.util.Set;

public class AgregarPedidoUseCase extends UseCase<RequestCommand<AgregarPedido>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarPedido> input) {
        var command = input.getCommand();
        var pedido = new Pedido(command.PedidoId(),command.Local(),command.Fecha(),command.Cliente(), (Set<Producto>) command.Producto());
        pedido.asignarPrecio(command.Producto().identity(), command.getPrecio(),command.getCantidad());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
