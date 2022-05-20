package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.values.*;
import co.com.cafeteria.procesos.pedido.commands.CrearPedido;
import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.EmpleadoAgregado;
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
class CrearPedidoUseCaseTest {
    @InjectMocks
    private CrearPedidoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearPedidoHappyPass(){

        PedidoId pedidoId = PedidoId.of("p1");
        Cliente cliente = new Cliente(new ClienteId("c1"), new Nombre("Juan"),new Documento("1029"));

        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        Local local = new Local(new LocalId("l1"), new Ubicacion("calle"));

        Producto producto = new Producto(new ProductoId("p1"),new Precio("10"),new Cantidad("2"));

        var command = new CrearPedido(pedidoId,cliente,fecha,local,producto);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PedidoCreado) events.get(0);
        Assertions.assertEquals("p1",event.aggregateRootId());
        Assertions.assertEquals("p1",event.getPedidoId().value());
        Assertions.assertEquals(cliente,event.getCliente());
        Assertions.assertEquals(fecha, event.getFecha());
        Assertions.assertEquals(local,event.getLocal());
        Assertions.assertEquals(producto,event.getProducto());
    }



}