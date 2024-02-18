import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String contraseña;
    private static int numerador = 100;
    private final String codigo;
    private String numeroTelefono;


    public Usuario(String nombre, String apellido, String contraseña, String numeroTelefono) {
        numerador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.numeroTelefono = numeroTelefono;
        this.codigo = "" + nombre.charAt(0)+apellido.charAt(0)+numerador;
    }

public int getContador(){ return numerador;}
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public void setNumeroTelefono(String numeroTelefono){
        this.numeroTelefono = numeroTelefono;
    }

    public static void setNumerador(int numerador) {
        Usuario.numerador = numerador;
    }

    public String toString(){
        return nombre + " " + codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(apellido, usuario.apellido) &&
                Objects.equals(contraseña, usuario.contraseña) &&
                Objects.equals(numeroTelefono, usuario.numeroTelefono) &&
                Objects.equals(codigo, usuario.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, contraseña, numeroTelefono, codigo);
    }

}

