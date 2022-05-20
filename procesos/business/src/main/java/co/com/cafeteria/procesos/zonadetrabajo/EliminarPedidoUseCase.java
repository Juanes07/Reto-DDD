package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.pedido.Pedido;
import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarPedido;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarPedidoUseCase extends UseCase<RequestCommand<EliminarPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarPedido> input) {
        var command = input.getCommand();
        var pedido = Pedido.from(command.PedidoId(), repository().getEventsBy(command.PedidoId().value()));
        pedido.eliminarPedido(command.PedidoId());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
