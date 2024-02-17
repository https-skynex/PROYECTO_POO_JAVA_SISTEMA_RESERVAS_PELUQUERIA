import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String contraseña;
    private static int numerador = 100;
    private final String codigo;
    private String numeroTelefono;


    public Usuario(String nombre, String apellido, String contraseña) {
        numerador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.codigo = "" + nombre.charAt(0)+apellido.charAt(0)+numerador;
    }

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
    public static int getNumerador() {
        return numerador;
    }

    public static void setNumerador(int numerador) {
        Usuario.numerador = numerador;
    }
}

