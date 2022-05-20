package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.values.*;
import co.com.cafeteria.procesos.pedido.values.PedidoId;
import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarInstrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Categoria;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.cafeteria.procesos.zonadetrabajo.events.EmpleadoAgregado;
import co.com.cafeteria.procesos.zonadetrabajo.events.InstrumentoEliminado;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoAgregada;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import generic.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EliminarInstrumentoUseCaseTest {

    @InjectMocks
    private EliminarInstrumentoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void EliminarInstrumentoHappyPass(){
        ZonaDeTrabajoId zonaDeTrabajoId = ZonaDeTrabajoId.of("c1");
        InstrumentoId instrumentoId = InstrumentoId.of("cuchara1");
        var command = new EliminarInstrumento(zonaDeTrabajoId,instrumentoId);

        when(repository.getEventsBy("c1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getZonaDeTrabajoId().value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InstrumentoEliminado) events.get(0);
        Assertions.assertEquals("c1",event.aggregateRootId());
        Assertions.assertEquals("cuchara1",event.InstrumentoId().value());
        Assertions.assertEquals("c1",event.getZonaDeTrabajoId().value());


    }

    private List<DomainEvent> history() {
        EmpleadoId empleadoId = EmpleadoId.of("e1");
        PedidoId pedidoId = PedidoId.of("p1");
        InstrumentoId instrumentoId = InstrumentoId.of("c1");
        Nombre nombre = new Nombre("cuchara");
        Categoria categoria = new Categoria("cocina");
        Instrumento instrumento = new Instrumento(instrumentoId,nombre,categoria);
        var event = new ZonaDeTrabajoAgregada(empleadoId,pedidoId,instrumento);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }

}