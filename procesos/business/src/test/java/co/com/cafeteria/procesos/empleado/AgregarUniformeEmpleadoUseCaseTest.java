package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.commands.AgregarUniformeEmpleado;
import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.events.UniformeEmpleadoAgregado;
import co.com.cafeteria.procesos.empleado.values.*;
import co.com.cafeteria.procesos.pedido.values.Fecha;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarUniformeEmpleadoUseCaseTest {

    @InjectMocks
    private  AgregarUniformeEmpleadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUniformeEmpleadoHappyPass(){
        //arrange
        EmpleadoId empleadoId = EmpleadoId.of("t");
        UniformeId uniformeId = new UniformeId("da");
        Descripcion descripcion = new Descripcion("des");
        Uniforme uniforme = new Uniforme(uniformeId,descripcion);
        var command = new AgregarUniformeEmpleado(empleadoId,uniforme);
        when(repository.getEventsBy("t")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.EmpleadoId().value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (UniformeEmpleadoAgregado) events.get(0);
        Assertions.assertEquals("t",event.aggregateRootId());
        Assertions.assertEquals(uniforme,event.Uniforme());
        Assertions.assertEquals("t",event.EmpleadoId().value());
    }

    private List<DomainEvent> history() {
        var conntratoId = new ContratoId("t");
        var tipoContrato = new TipoDeContrato("horas","10");
        var contrato = new Contrato(conntratoId,tipoContrato);
        var nombre = new Nombre("da");
        var rol = new Rol(new RolId("la"),new NombreRol("chef"));
        var uniformeId = new UniformeId("da");
        var descripcion = new Descripcion("hola");
        var uniforme = new Uniforme(uniformeId,descripcion);
        var event = new EmpleadoAgregado(contrato,nombre,rol,uniforme);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }


}