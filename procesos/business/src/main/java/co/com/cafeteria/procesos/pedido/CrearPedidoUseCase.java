package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.commands.CrearPedido;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Set;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedido>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPedido> input) {
        var command = input.getCommand();
        var pedido = new Pedido(command.PedidoId(),command.Local(),command.Fecha(),command.Cliente(), command.Producto());
        pedido.crearPedido(command.PedidoId(),command.Cliente(),command.Fecha(),command.Local(),  command.Producto());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
