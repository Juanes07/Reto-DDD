package co.com.cafeteria.procesos.pedido.commands;

import co.com.cafeteria.procesos.pedido.entity.Cliente;
import co.com.cafeteria.procesos.pedido.entity.Local;
import co.com.cafeteria.procesos.pedido.entity.Producto;
import co.com.cafeteria.procesos.pedido.values.*;
import co.com.sofka.domain.generic.Command;

/**
 * Comando CrearPedido
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class CrearPedido extends Command {
    /**
     * caracteristicas
     */
    private final PedidoId pedidoId;
    private final Cliente cliente;
    private final Fecha fecha;
    private final Local local;
    private final Producto producto;

    /**
     * constructor Crear pedido
     *
     * @param pedidoId tipo PedidoId
     * @param cliente  tipo Cliente
     * @param fecha    tipo Fecha
     * @param local    tipo Local
     * @param producto tipo Producto
     */

    public CrearPedido(PedidoId pedidoId, Cliente cliente, Fecha fecha, Local local, Producto producto) {
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.fecha = fecha;
        this.local = local;
        this.producto = producto;
    }

    /**
     * getters
     */

    public PedidoId PedidoId() {
        return pedidoId;
    }

    public Cliente Cliente() {
        return cliente;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Local Local() {
        return local;
    }

    public Producto Producto() {
        return producto;
    }

}
