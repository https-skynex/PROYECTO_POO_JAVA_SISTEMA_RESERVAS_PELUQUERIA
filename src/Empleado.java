import java.io.Serializable;

public abstract class Empleado implements Serializable {
    private String nombre;
    private String apellido;
    private String contraseña;
    private static int numerador = 99;
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



}



