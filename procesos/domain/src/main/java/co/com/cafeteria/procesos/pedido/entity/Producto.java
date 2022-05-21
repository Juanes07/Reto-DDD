package co.com.cafeteria.procesos.pedido.entity;

import co.com.cafeteria.procesos.pedido.values.Cantidad;
import co.com.cafeteria.procesos.pedido.values.Precio;
import co.com.cafeteria.procesos.pedido.values.ProductoId;
import co.com.sofka.domain.generic.Entity;

/**
 * Entidad Producto
 *
 * @author Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class Producto extends Entity<ProductoId> {
    protected Precio precio;
    protected Cantidad cantidad;

    public Producto(ProductoId id, Precio precio, Cantidad cantidad) {
        super(id);
        this.precio = precio;
        this.cantidad = cantidad;
    }

}
