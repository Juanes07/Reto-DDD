package co.com.cafeteria.procesos.pedido.entity;

import co.com.cafeteria.procesos.pedido.values.Cantidad;
import co.com.cafeteria.procesos.pedido.values.Precio;
import co.com.cafeteria.procesos.pedido.values.ProductoId;
import co.com.sofka.domain.generic.Entity;

public class Producto extends Entity<ProductoId> {
    protected Precio precio;
    protected Cantidad cantidad;

    public Producto(ProductoId id, Precio precio, Cantidad cantidad) {
        super(id);
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void asignarPrecio(String precio){
        this.precio = new Precio(precio);
    }

    public void asignarCantidad(String cantidad){
        this.cantidad = new Cantidad(cantidad);
    }

}
