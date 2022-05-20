package co.com.cafeteria.procesos.empleado;

import co.com.cafeteria.procesos.empleado.commands.AgregarContrato;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarContratoUseCase extends UseCase<RequestCommand<AgregarContrato>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarContrato> input) {
        var command =  input.getCommand();
        var empleado = Empleado.from(command.EmpleadoId(), repository().getEventsBy(command.EmpleadoId().value()));
        empleado.agregarContrato(command.ContratoId(), command.TipoDeContrato());
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));

    }
}
