package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarEmpleado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarEmpleadoUseCase extends UseCase<RequestCommand<EliminarEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarEmpleado> input) {
        var command = input.getCommand();
        var zonaDeTrabajo = ZonaDeTrabajo.from(command.getZonaDeTrabajoId(),repository().getEventsBy(command.getZonaDeTrabajoId().value()));
        zonaDeTrabajo.eliminarEmpleado(command.getZonaDeTrabajoId(), command.EmpleadoId());
        emit().onResponse(new ResponseEvents(zonaDeTrabajo.getUncommittedChanges()));
    }
}
