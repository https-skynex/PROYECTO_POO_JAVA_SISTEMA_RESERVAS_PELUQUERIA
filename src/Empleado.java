import java.io.Serializable;
import java.util.Objects;

public abstract class Empleado implements Serializable {
    private String nombre;
    private String apellido;
    private String contraseña;
    private static int numerador = 100;
    private final String codigo;
    public Empleado(String nombre, String apellido, String contraseña){
        numerador++;
        this.nombre = nombre;
        this. apellido = apellido;
        this.contraseña = contraseña;
        this.codigo = ""+getEspecialidad().charAt(0)+numerador;
    }

    public Empleado() {
        codigo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEspecialidad(){ return  null; }

    public static int getNumerador() {
        return numerador;
    }

    public static void setNumerador(int numerador) {
        Empleado.numerador = numerador;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(codigo, empleado.codigo);  // Asegúrate de comparar todos los atributos relevantes
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);  // Asegúrate de incluir todos los atributos relevantes
    }
}






