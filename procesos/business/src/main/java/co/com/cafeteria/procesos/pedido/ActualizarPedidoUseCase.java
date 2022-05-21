package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.events.PedidoActualizado;
import co.com.cafeteria.procesos.pedido.events.PedidoFinalizado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarPedidoUseCase extends UseCase<TriggeredEvent<PedidoFinalizado>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<PedidoFinalizado> input) {
        var event = input.getDomainEvent();
        var pedido = Pedido.from(event.getPedidoId(),repository().getEventsBy(event.getPedidoId().value()));
        pedido.actualizarPedido(event.getPedidoId());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
