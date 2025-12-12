package ac.cr.cenfotec.bejarano.m.bl;

import java.util.Objects;
/**
 * Modelo que representa un producto genérico.
 *
 * Contiene información esencial como el nombre y el precio base.
 * Es utilizado por {@link ProductoTienda} y {@link LineaFactura}.
 *
 * @version 2.0
 */
public abstract class Producto {
    private String nombre;
    protected double precio;

    /**
     * Crea un producto.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio unitario.
     */

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract double calcularPrecio();

    /** @return Nombre del producto. */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /** @return Precio del producto. */
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /** @return Representación textual del producto. */
    @Override
    public String toString() {
        return "Producto{" +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return nombre.equals(p.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}

