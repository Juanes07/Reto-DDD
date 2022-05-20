package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.zonadetrabajo.commands.AgregarZonaDeTrabajo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarZonaDeTrabajoUseCase extends UseCase<RequestCommand<AgregarZonaDeTrabajo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarZonaDeTrabajo> input) {
        var command = input.getCommand();
        var zonaDeTrabajo = new ZonaDeTrabajo(command.getZonaDeTrabajoId(),command.EmpleadoId(),command.Instrumento(),command.PedidoId(),command.MateriaPrima(), command.getZonaDeTrabajoId(), command.getLavado());
        emit().onResponse(new ResponseEvents(zonaDeTrabajo.getUncommittedChanges()));

    }
}
