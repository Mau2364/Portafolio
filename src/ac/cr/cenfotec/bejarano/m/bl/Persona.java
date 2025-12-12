package ac.cr.cenfotec.bejarano.m.bl;

import java.util.Objects;

public abstract class Persona {
    protected String nombre;
    protected String correo;
    protected String telefono;

    public Persona(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona p = (Persona) o;
        return nombre.equals(p.nombre) &&
                correo.equals(p.correo) &&
                telefono.equals(p.telefono);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, correo, telefono);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
