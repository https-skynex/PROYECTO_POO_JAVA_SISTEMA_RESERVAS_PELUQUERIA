import java.io.Serializable;
import java.util.*;
import java.io.Serializable;

public class Cita implements Serializable, Comparable<Cita> {
    private Usuario usuario;
    private Empleado empleado;
    private Servicio servicio;
    private int dia;
    private int mes;
    private int hora;
    private int año = 2024;
    private String estado = "";


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

    public int getAño() {
        return año;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return dia == cita.dia && mes == cita.mes && hora == cita.hora &&
                Objects.equals(usuario, cita.usuario) &&
                Objects.equals(empleado, cita.empleado) &&
                Objects.equals(servicio, cita.servicio);
    }


    @Override
    public int hashCode() {
        return Objects.hash(empleado, dia, mes, hora);
    }



    public String impresionCita(){
        return   "Peluquero: " + empleado + "\nServicio: " + servicio + "\nHora: " + hora + "\nDia: " + dia + "\nMes: " + mes;

    }

    public String toString(){
        return "CodigoCliente: " + usuario.getCodigo()  + ", Horario: " + hora + ", Servicio: " + servicio.getNombre();
    }

    @Override
    public int compareTo(Cita cita) {
        return hora - cita.hora;
    }
    }


