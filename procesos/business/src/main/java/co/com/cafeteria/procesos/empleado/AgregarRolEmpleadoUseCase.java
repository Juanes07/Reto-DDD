package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.commands.AgregarRolEmpleado;
import co.com.cafeteria.procesos.empleado.commands.AgregarUniformeEmpleado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarRolEmpleadoUseCase extends UseCase<RequestCommand<AgregarRolEmpleado>, ResponseEvents> {



    @Override
    public void executeUseCase(RequestCommand<AgregarRolEmpleado> input) {
        var command = input.getCommand();
        var empleado = Empleado.from(
                command.EmpleadoId(),repository().getEventsBy(command.EmpleadoId().value())
        );
        empleado.agregarRol(command.Rol());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
