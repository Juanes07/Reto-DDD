package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.commands.AgregarUniformeEmpleado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarUniformeEmpleadoUseCase extends UseCase<RequestCommand<AgregarUniformeEmpleado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarUniformeEmpleado> agregarUniformeEmpleadoRequestCommand) {
        var command = agregarUniformeEmpleadoRequestCommand.getCommand();
        var empleado = Empleado.from(
                command.EmpleadoId(),repository().getEventsBy(command.EmpleadoId().value())
        );
        empleado.agregarUniforme(command.uniforme());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
