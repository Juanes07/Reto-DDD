package co.com.cafeteria.procesos.pedido.entity;

import co.com.cafeteria.procesos.pedido.values.ClienteId;
import co.com.cafeteria.procesos.pedido.values.Documento;
import co.com.sofka.domain.generic.Entity;
import generic.Nombre;

public class Cliente extends Entity<ClienteId> {
    protected Nombre nombre;
    protected Documento documento;

    public Cliente(ClienteId id, Nombre nombre, Documento documento) {
        super(id);
        this.nombre = nombre;
    }

    public void crearCliente(String nombre, String documento){
        this.nombre = new Nombre(nombre);
        this.documento = new Documento(documento);
    }
}
