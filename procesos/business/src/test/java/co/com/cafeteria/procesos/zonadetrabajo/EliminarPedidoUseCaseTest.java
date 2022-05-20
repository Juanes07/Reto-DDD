package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.Pedido;
import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.commands.AgregarZonaDeTrabajo;
import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarEmpleado;
import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarPedido;
import co.com.cafeteria.procesos.zonadetrabajo.events.PedidoEliminado;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
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
class EliminarPedidoUseCaseTest {
    @InjectMocks
    private EliminarPedidoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void EliminarPedidoHappyPass(){
        PedidoId pedidoId = PedidoId.of("e1");
        var command = new EliminarPedido(pedidoId);

        when(repository.getEventsBy("e1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.PedidoId().value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PedidoEliminado) events.get(0);
        Assertions.assertEquals("e1",event.aggregateRootId());
        Assertions.assertEquals("e1",event.PedidoId().value());
    }

    private List<DomainEvent> history() {
        PedidoId pedidoId = PedidoId.of("p1");
        Local local = new Local(
                new LocalId("l1"),
                new Ubicacion("calle"));
        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        Cliente cliente = new Cliente(
                new ClienteId("c1"),
                new Nombre("Juan"),
                new Documento("1029")
        );
        Producto producto = new Producto(
                new ProductoId("p1"),
                new Precio("100"),
                new Cantidad("10")
        );

        var event = new PedidoCreado(pedidoId,cliente,fecha,local,producto);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }

}