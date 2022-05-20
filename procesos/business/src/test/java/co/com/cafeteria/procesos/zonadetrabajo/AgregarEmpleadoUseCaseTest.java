package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.AgregarUniformeEmpleadoUseCase;
import co.com.cafeteria.procesos.empleado.entity.Contrato;
import co.com.cafeteria.procesos.empleado.entity.Rol;
import co.com.cafeteria.procesos.empleado.entity.Uniforme;
import co.com.cafeteria.procesos.empleado.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.commands.AgregarEmpleado;
import co.com.cafeteria.procesos.zonadetrabajo.events.EmpleadoAgregado;
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
class AgregarEmpleadoUseCaseTest {

    @InjectMocks
    private AgregarEmpleadoUseCase  useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarEmpleadoHappyPass(){
        EmpleadoId empleadoId = EmpleadoId.of("da");
        ContratoId contratoId = ContratoId.of("q");
        TipoDeContrato tipoDeContrato = new TipoDeContrato("horas","10");
        Contrato contrato = new Contrato(contratoId,tipoDeContrato);
        Nombre nombre = new Nombre("hola");
        RolId rolId = new RolId("dada");
        NombreRol nombreRol = new NombreRol("chef");
        Rol rol = new Rol(rolId,nombreRol);
        UniformeId uniformeId = UniformeId.of("valor");
        Descripcion descripcion = new Descripcion("des");
        Uniforme uniforme = new Uniforme(uniformeId,descripcion);

        var command = new AgregarEmpleado(empleadoId,contrato,nombre,rol,uniforme);



        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EmpleadoAgregado)events.get(0);
        Assertions.assertEquals("da",event.aggregateRootId());
        Assertions.assertEquals(contrato,event.Contrato());
        Assertions.assertEquals("hola",event.Nombre().value());
        Assertions.assertEquals(rol,event.Rol());
        Assertions.assertEquals(uniforme,event.Uniforme());

    }

}