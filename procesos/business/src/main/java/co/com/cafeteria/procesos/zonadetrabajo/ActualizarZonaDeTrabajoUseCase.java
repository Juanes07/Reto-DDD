package co.com.cafeteria.procesos.zonadetrabajo;

import co.com.cafeteria.procesos.zonadetrabajo.commands.EliminarZonaDeTrabajo;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoActualizada;
import co.com.cafeteria.procesos.zonadetrabajo.events.ZonaDeTrabajoEliminada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarZonaDeTrabajoUseCase extends UseCase<TriggeredEvent<ZonaDeTrabajoEliminada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ZonaDeTrabajoEliminada> input) {
        var event = input.getDomainEvent();
        var zonaDeTrabajo =  ZonaDeTrabajo.from(event.ZonaDeTrabajoId(),
                repository().getEventsBy(event.ZonaDeTrabajoId().value()));
        zonaDeTrabajo.actualizarZonaDeTrabajo(event.ZonaDeTrabajoId());

        emit().onResponse(new ResponseEvents(zonaDeTrabajo.getUncommittedChanges()));

    }
}
