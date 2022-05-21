package co.com.cafeteria.procesos.pedido;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.events.PedidoCreado;
import co.com.cafeteria.procesos.pedido.events.PedidoActualizado;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.cafeteria.procesos.zonadetrabajo.events.PedidoEliminado;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;


/**
 * Agregado Pedido
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */


public class Pedido extends AggregateEvent<PedidoId> {
    /**
     * caracteristicas
     */
    protected Local local;
    protected Fecha fecha;
    protected Cliente cliente;
    protected Producto producto;

    /**
     * constructror Pedido
     *
     * @param id       tipo PedidoId
     * @param local    tipo Local
     * @param fecha    tipo Fecha
     * @param cliente  tipo Cliente
     * @param producto tipo Producto
     */

    public Pedido(PedidoId id, Local local, Fecha fecha, Cliente cliente, Producto producto) {
        super(id);
        appendChange(new PedidoCreado(id, cliente, fecha, local, producto)).apply();
        subscribe(new PedidoEventChange(this));
    }

    /**
     * constructor Pedido
     *
     * @param pedidoId tipo PedidoId
     */

    public Pedido(PedidoId pedidoId) {
        super(pedidoId);
        subscribe(new PedidoEventChange(this));
    }


    /**
     * @param pedidoId tipo PedidoId
     * @param events   Lista de Eventos de Dominio
     * @return pedido
     */
    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events) {
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    /**
     * comportamiento para crear un pedido
     *
     * @param pedidoId tipo PedidoId
     * @param local    tipo Local
     * @param fecha    tipo Fecha
     * @param cliente  tipo Cliente
     * @param producto tipo Producto
     */

    public void crearPedido(PedidoId pedidoId, Cliente cliente, Fecha fecha, Local local, Producto producto) {
        appendChange(new PedidoCreado(pedidoId, cliente, fecha, local, producto)).apply();
    }

    /**
     * comportamiento para eliminar un pedido
     *
     * @param pedidoId tipo PedidoId
     */
    public void eliminarPedido(PedidoId pedidoId) {
        appendChange(new PedidoEliminado(pedidoId)).apply();
    }

    /**
     * comportamiento para Actualizar un pedido
     *
     * @param pedidoId tipo pedidoId
     */

    public void actualizarPedido(PedidoId pedidoId) {
        appendChange(new PedidoActualizado(pedidoId)).apply();
    }

}
