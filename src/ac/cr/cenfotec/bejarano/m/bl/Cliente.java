package ac.cr.cenfotec.bejarano.m.bl;

/**
 * Representa un cliente dentro del sistema.
 *
 * La clase almacena la información básica requerida para
 * identificar y contactar al cliente, incluyendo:
 * <ul>
 *     <li>Nombre</li>
 *     <li>Correo electrónico</li>
 *     <li>Teléfono</li>
 * </ul>
 *
 * Esta clase forma parte del modelo en la arquitectura MVC.
 * Regularmente es utilizada por las clases {@link Factura} y
 * {@link Controller} para asociar compras a un cliente específico.
 *
 * @version 2.0
 */
public class Cliente extends Persona {

    /**
     * Constructor que permite crear un nuevo cliente.
     *
     * @param nombre   Nombre completo del cliente.
     * @param correo   Correo electrónico del cliente.
     * @param telefono Número telefónico del cliente.
     */

    public Cliente(String nombre, String correo, String telefono) {
        super(nombre, correo, telefono);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getId() {
        return telefono;
    }
    public void setId(String id) {
        this.telefono = telefono;
    }

    /**
     * Retorna una representación en texto del cliente.
     *
     * @return Cadena descriptiva del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", id='" + telefono + '\'' +
                '}';
    }
}
