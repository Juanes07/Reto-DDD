package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.events.PedidoActualizado;
import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.cafeteria.procesos.pedido.events.PedidoFinalizado;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarPedidoUseCaseTest {
    @InjectMocks
    private ActualizarPedidoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void PedidoFinalizadoHappyPass(){
        PedidoId pedidoId = PedidoId.of("p1");
        var event = new PedidoFinalizado(pedidoId);

        when(repository.getEventsBy("p1")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var pedidoFinalizado = (PedidoActualizado)events.get(0);
        Assertions.assertEquals("p1",pedidoFinalizado.aggregateRootId());
        Assertions.assertEquals("p1",pedidoFinalizado.getPedidoId().value());
    }

    private List<DomainEvent> history() {
        var pedidoId = PedidoId.of("p1");
        var cliente = new Cliente(
                new ClienteId("c1"),
                new Nombre("Juan"),
                new Documento("1029")
        );
        var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var local = new Local(new LocalId("l1"),new Ubicacion("calle"));
        var producto = new Producto(new ProductoId("p1"),
                new Precio("100"),
                new Cantidad("10"));
        var event = new PedidoCreado(pedidoId,cliente,fecha,local,producto);
        return List.of(event);
    }


}