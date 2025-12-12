package ac.cr.cenfotec.bejarano.m.bl;

/**
 * Representa un producto almacenado dentro de la tienda,
 *
 * Extiende la clase {@link Producto}.
 *
 * @version 1.0
 */
public class ProductoTienda extends Producto{

    /**
     * Crea un producto de tienda.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio unitario.
     */
    public ProductoTienda(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }
}