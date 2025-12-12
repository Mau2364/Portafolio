package ac.cr.cenfotec.bejarano.m.bl;

/**
 * Representa una línea dentro de una factura.
 *
 * Contiene un producto y la cantidad comprada.
 * Calcula su propio subtotal.
 *
 * @version 1.0
 */

public class LineaFactura {
    private Producto producto;
    private int cantidad;
    private double subtotal;
    /**
     * Crea una nueva línea de factura.
     *
     * @param producto Producto comprado.
     * @param cantidad Cantidad adquirida.
     */

    public LineaFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecio() * cantidad;
    }

    /** @return Subtotal de esta línea. */
    public double getSubtotal() { return subtotal; }

    /** @return Representación textual. */
    @Override
    public String toString() {
        return producto.getNombre() +
                " (₡" + producto.getPrecio() + " c/u) x " +
                cantidad +
                " → ₡" + subtotal;
    }
}
