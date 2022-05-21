package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.values.EmpleadoId;
import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarZonaDeTrabajo;
import co.com.cafeteria.procesos.zonadetrabajo.entity.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoActualizada;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoAgregada;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoEliminada;
import co.com.cafeteria.procesos.zonadetrabajo.value.*;
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
class ActualizarZonaDeTrabajoUseCaseTest {
    @InjectMocks
    private ActualizarZonaDeTrabajoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarInstrumentoZonaDeTrabajoHappyPass(){
        ZonaDeTrabajoId zonaDeTrabajoId = ZonaDeTrabajoId.of("z1");
        var event = new ZonaDeTrabajoEliminada(zonaDeTrabajoId);

        when(repository.getEventsBy("z1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var zonaDeTrabajoActualizada = (ZonaDeTrabajoActualizada)events.get(0);
        Assertions.assertEquals("z1",zonaDeTrabajoActualizada.getZonaDeTrabajoId().value());

    }

    private List<DomainEvent> history() {
        var empleadoId = EmpleadoId.of("e1");
        var pedidoId = PedidoId.of("p1");
        Instrumento instrumento = new Instrumento(
                new InstrumentoId("In1"),
                new Nombre("cuchara"),
                new Categoria("cocina")
        );
        MateriaPrima materiaPrima = new MateriaPrima(
                new MateriaPrimaId("m1"),
                new Nombre("tomate"),
                new FechaDeProduccion(LocalDateTime.now(),LocalDate.now()),
                new FechaDeCaducidad(LocalDate.now())
        );
        ZonaDeTrabajoId zonaDeTrabajoId = ZonaDeTrabajoId.of("z1");
        Lavado lavado = new Lavado(
                new LavadoId("L1"),
                new Ubicacion("cocina1")
        );
        var event = new ZonaDeTrabajoAgregada(empleadoId,pedidoId,instrumento,materiaPrima,zonaDeTrabajoId,lavado);
        return List.of(event);
    }

}