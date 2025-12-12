package ac.cr.cenfotec.bejarano.m.bl;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una factura generada por una compra.
 *
 * Contiene la información del cliente, la lista de líneas
 * de factura y el total acumulado. Maneja la adición de productos
 * y genera una representación textual.
 *
 * @version 1.0
 */

public class Factura {

    private Cliente cliente;
    private List<LineaFactura> lineas;
    private double total;

    /**
     * Crea una factura asociada a un cliente.
     *
     * @param cliente Cliente que realiza la compra.
     */

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.lineas = new ArrayList<>();
    }

    /**
     * Agrega una línea de factura basada en un producto y cantidad.
     *
     * @param p         Producto comprado.
     * @param cantidad  Cantidad adquirida.
     */
    public void agregarLinea(Producto p, int cantidad) {
        LineaFactura lf = new LineaFactura(p, cantidad);
        lineas.add(lf);
        total += lf.getSubtotal();
    }

    /** @return Representación textual completa de la factura. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n=== FACTURA ===\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n\n");
        sb.append("Detalle:\n");

        for (LineaFactura lf : lineas) {
            sb.append("  ").append(lf).append("\n");
        }

        sb.append("\nTotal: ").append(total).append("\n");

        return sb.toString();
    }
}


