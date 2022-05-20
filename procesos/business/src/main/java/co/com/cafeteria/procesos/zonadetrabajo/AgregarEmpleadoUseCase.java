package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.empleado.Empleado;
import co.com.cafeteria.procesos.zonadetrabajo.commands.AgregarEmpleado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEmpleadoUseCase extends UseCase<RequestCommand<AgregarEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEmpleado> input) {
        var command = input.getCommand();
        var empleado = new Empleado(command.empleadoId(),command.Contrato(),command.Nombre(), command.Rol(),command.Uniforme());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));


    }
}
