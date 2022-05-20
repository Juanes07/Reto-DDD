package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarInstrumento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarInstrumentoUseCase extends UseCase<RequestCommand<EliminarInstrumento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarInstrumento> input) {
        var command = input.getCommand();
        var zonaDeTrabajo = ZonaDeTrabajo.from(command.getZonaDeTrabajoId(), repository().getEventsBy(command.getZonaDeTrabajoId().value()));
        zonaDeTrabajo.eliminarInstrumento(command.getZonaDeTrabajoId(),command.InstrumentoId());
        emit().onResponse(new ResponseEvents(zonaDeTrabajo.getUncommittedChanges()));

    }
}
