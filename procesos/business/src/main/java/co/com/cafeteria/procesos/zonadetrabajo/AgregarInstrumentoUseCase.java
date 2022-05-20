package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.zonadetrabajo.commands.AgregarInstrumento;
import co.com.cafeteria.procesos.zonadetrabajo.entity.Instrumento;
import co.com.cafeteria.procesos.zonadetrabajo.events.InstrumentoAgregado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarInstrumentoUseCase extends UseCase<RequestCommand<AgregarInstrumento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarInstrumento> input) {
        var command = input.getCommand();
        var zonaDeTrabajo = ZonaDeTrabajo.from(command.zonaDeTrabajoId(),repository().getEventsBy(command.zonaDeTrabajoId().value()));
        zonaDeTrabajo.agregarInstrumento(command.zonaDeTrabajoId(),command.InstrumentoId(),command.Nombre(),command.Categoria());
        emit().onResponse(new ResponseEvents(zonaDeTrabajo.getUncommittedChanges()));

    }
}
