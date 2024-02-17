import java.util.*;

public class Cita {
    private Usuario usuario;
    private Empleado empleado;
    private Servicio servicio;
    private int dia;
    private int mes;
    private int hora;
    private int año = 2024;
    private boolean estado;


    public Cita(Usuario usuario, Empleado empleado, Servicio servicio,int hora, int dia, int mes) {
        this.usuario = usuario;
        this.empleado = empleado;
        this.servicio  = servicio;
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getDia() {return dia;}

    public int getMes() {return mes;}
    public int getHora() {
        return hora;
    }
    public Servicio getServicio(){
        return servicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return dia == cita.dia && mes == cita.mes  && hora == cita.hora &&
                Objects.equals(usuario, cita.usuario) &&
                Objects.equals(empleado, cita.empleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleado, dia, mes, hora);
    }

    public Empleado empleadosDisponibles (int hora1, int dia1, int mes1){
        if( hora == hora1 && dia == dia1 && mes == mes1 ){
            return null;
        }else{
            return empleado;
        }

    }

    @Override
    public String toString(){
        return  "Peluquero: " + empleado + "\nServicio: " + servicio + "\nHora: " + hora + "\nDia: " + dia + "\nMes: " + mes;

    }

}
