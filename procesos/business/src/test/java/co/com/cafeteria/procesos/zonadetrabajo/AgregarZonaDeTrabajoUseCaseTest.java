package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.pedido.values.Ubicacion;
import co.com.cafeteria.procesos.zonadetrabajo.commands.AgregarZonaDeTrabajo;
import co.com.cafeteria.procesos.zonadetrabajo.entity.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoAgregada;
import co.com.cafeteria.procesos.zonadetrabajo.value.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import generic.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class AgregarZonaDeTrabajoUseCaseTest {

    @InjectMocks
    private AgregarZonaDeTrabajoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarZonaDeTrabajoHappyPass() {
        EmpleadoId empleadoId = EmpleadoId.of("e1");
        PedidoId pedidoId = PedidoId.of("p1");
        Instrumento instrumento = new Instrumento(
                new InstrumentoId("i1"),
                new Nombre("cuchara"),
                new Categoria("cocina1"));
        MateriaPrima materiaPrima = new MateriaPrima(
                new MateriaPrimaId("m1"),
                new Nombre("tomate"),
                new FechaDeProduccion(LocalDateTime.now(), LocalDate.now()),
                new FechaDeCaducidad(LocalDate.now())
        );
        ZonaDeTrabajoId zonaDeTrabajoId = ZonaDeTrabajoId.of("t1");
        Lavado lavado = new Lavado(new LavadoId("l1"),new Ubicacion("cocina1"));
        var command = new AgregarZonaDeTrabajo(empleadoId, pedidoId, instrumento, materiaPrima, zonaDeTrabajoId, lavado);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (ZonaDeTrabajoAgregada) events.get(0);
        Assertions.assertEquals("t1", event.aggregateRootId());
        Assertions.assertEquals("e1", event.EmpleadoId().value());
        Assertions.assertEquals("p1", event.PedidoId().value());
        Assertions.assertEquals(instrumento, event.Instrumento());
        Assertions.assertEquals(materiaPrima,event.getMateriaPrima());
        Assertions.assertEquals("t1",event.getZonaDeTrabajoId().value());
        Assertions.assertEquals(lavado,event.getLavado());

    }


}