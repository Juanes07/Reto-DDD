package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.zonadetrabajo.commands.AgregarInstrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Categoria;
import co.com.cafeteria.procesos.zonadetrabajo.entity.InstrumentoId;
import co.com.cafeteria.procesos.zonadetrabajo.events.InstrumentoAgregado;
import co.com.cafeteria.procesos.zonadetrabajo.value.ZonaDeTrabajoId;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarInstrumentoUseCaseTest {

    @InjectMocks
    private AgregarInstrumentoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarInstrumentoHappyPass() {
        ZonaDeTrabajoId zonaDeTrabajoId = ZonaDeTrabajoId.of("da");
        InstrumentoId instrumentoId = InstrumentoId.of("de");
        Nombre nombre = new Nombre("cuchara");
        Categoria categoria = new Categoria("cocina");

        var command = new AgregarInstrumento(zonaDeTrabajoId, instrumentoId, nombre, categoria);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InstrumentoAgregado) events.get(0);
        Assertions.assertEquals("da",event.aggregateRootId());
        Assertions.assertEquals("da",event.getZonaDeTrabajoId().value());
        Assertions.assertEquals("de",event.getInstrumentoId().value());
        Assertions.assertEquals("cuchara",event.Nombre().value());
        Assertions.assertEquals("cocina",event.Categoria().value());
    }

}