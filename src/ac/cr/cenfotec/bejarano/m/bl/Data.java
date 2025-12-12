package ac.cr.cenfotec.bejarano.m.bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de almacenar temporalmente todos los datos del sistema.
 * Implementa el patrón Singleton para asegurar que toda la aplicación
 * acceda a la misma instancia de datos.
 *
 * Contiene las colecciones principales:
 * - Clientes
 * - Productos
 * - Facturas
 *
 * Esta clase actúa como una "base de datos en memoria".
 *
 * @version 2.0
 */
public class Data {

    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Factura> facturas;

    /**
     * Constructor privado para evitar múltiples instancias.
     * Inicializa todas las listas necesarias.
     */
    public Data() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    /**
     * Retorna la instancia única de la clase.
     * Si no existe, la crea.
     *
     * @return Instancia única de Data.
     */
    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    /**
     * Retorna la lista de clientes almacenados.
     *
     * @return Lista de clientes.
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    /**
     * Retorna la lista de productos almacenados.
     *
     * @return Lista de productos.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    // FACTURAS
    public void agregarFactura(Factura f) {
        facturas.add(f);
    }

    /**
     * Retorna la lista de facturas almacenadas.
     *
     * @return Lista de facturas.
     */
    public List<Factura> getFacturas() {
        return facturas;
    }
}
