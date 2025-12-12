package ac.cr.cenfotec.bejarano.m.ui;
import ac.cr.cenfotec.bejarano.m.bl.*;

import java.util.List;


/**
 * Controlador principal del sistema.
 * Se encarga de coordinar la comunicación entre la capa UI
 * y la capa de datos {@link Data}.
 *
 * Esta clase NO almacena datos directamente; delega las operaciones
 * CRUD a la clase Data, aplicando el patrón MVC.
 *
 * @author Mauricio Bejarano
 * @version 2.0
 */

public class Controller {
    private Data data = new Data();

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param nombre   Nombre del cliente.
     * @param correo   Correo electrónico del cliente.
     * @param telefono Número telefónico del cliente.
     */
    public void registrarCliente(String nombre, String correo, String telefono) {
        data.agregarCliente(new Cliente(nombre, correo, telefono));
    }

    /**
     * Registra un nuevo producto en el sistema.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     */

    public void registrarProducto(String nombre, double precio) {
        data.agregarProducto(new ProductoTienda(nombre, precio));
    }

    /**
     * Registra un nuevo producto en el sistema.
     */

    public Factura registrarCompra(Cliente cliente, Producto producto, int cantidad, boolean crearNuevaFactura) {

        Factura factura;

        if (crearNuevaFactura) {
            factura = new Factura(cliente);
            data.agregarFactura(factura);
        } else {
            // Agarra la última factura agregada (alternativa)
            factura = data.getFacturas().get(data.getFacturas().size() - 1);
        }

        factura.agregarLinea(producto, cantidad);
        return factura;
    }

    // GETTERS DE DATOS
    public java.util.List<Cliente> getClientes() {
        return data.getClientes();
    }

    public java.util.List<Producto> getProductos() {
        return data.getProductos();
    }

    public java.util.List<Factura> getFacturas() {
        return data.getFacturas();
    }
}

