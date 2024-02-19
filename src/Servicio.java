import java.io.Serializable;
import java.util.Objects;

public class Servicio implements Serializable {
    private String nombre;
    private double precio;

    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(nombre, servicio.nombre) && Double.compare(servicio.precio, precio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

}
