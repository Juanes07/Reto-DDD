package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.commands.AgregarRolEmpleado;
import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.events.RolEmpleadoAgregado;
import co.com.cafeteria.procesos.empleado.values.*;
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
class AgregarRolEmpleadoUseCaseTest {

    @InjectMocks
    private AgregarRolEmpleadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;


    @Test
    void agregarRolEmpleadoHappyPass(){
        //arrange
        EmpleadoId empleadoId = EmpleadoId.of("t");
        ContratoId contratoId = ContratoId.of("l");
        TipoDeContrato tipoDeContrato = new TipoDeContrato("horas","10");
        Contrato contrato = new Contrato(contratoId,tipoDeContrato);
        Nombre nombre = new Nombre("hola");
        RolId rolId = RolId.of("l");
        NombreRol nombreRol = new NombreRol("chef");
        Rol rol = new Rol(rolId,nombreRol);
        var command = new AgregarRolEmpleado(empleadoId,contrato,nombre,rol);
        when(repository.getEventsBy("t")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.EmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (RolEmpleadoAgregado) events.get(0);
        Assertions.assertEquals("t",event.aggregateRootId());


    }

    private List<DomainEvent> history() {
        var conntratoId = new ContratoId("l");
        var tipoContrato = new TipoDeContrato("horas","10");
        var contrato = new Contrato(conntratoId,tipoContrato);
        var nombre = new Nombre("hola");
        var rol = new Rol(new RolId("l"),new NombreRol("chef"));
        var uniformeId = new UniformeId("da");
        var descripcion = new Descripcion("hola");
        var uniforme = new Uniforme(uniformeId,descripcion);
        var event = new EmpleadoAgregado(contrato,nombre,rol,uniforme);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }

}