import java.util.*;

public class RegistroCitas {
    static private ArrayList<Cita> listaCitas = new ArrayList<>();

    public static void agregarCita(Cita cita) {
        if (!listaCitas.contains(cita)) {
            listaCitas.add(cita);
        } else {
            System.out.println("Ya hay una cita registrada para ese peluquero, día y hora.");
        }
    }

    static public boolean choqueCitas (String hora1, String dia1, String mes1, Usuario usuario) {
        int hora = Integer.parseInt(hora1);
        int dia = Integer.parseInt(dia1);
        int mes = Integer.parseInt(mes1);
        boolean choque = false;
        for (Cita cita : listaCitas) {
            if (hora == cita.getHora() && dia == cita.getDia() && mes == cita.getMes() && usuario == cita.getUsuario()) {
                choque = true;
            }

        }
        return choque;
    }

    static public ArrayList<Empleado> peluquerosDisponibles(String hora1, String dia1, String mes1){
        int hora = Integer.parseInt(hora1);
        int dia = Integer.parseInt(dia1);
        int mes = Integer.parseInt(mes1);
        ArrayList<Empleado> empleados = new ArrayList<>(RegistroEmpleados.exportarPeluqueros());
        ArrayList<Empleado> empleadosOcupados = new ArrayList<>();

        for (Cita cita :listaCitas){
            if(hora ==cita.getHora() && dia ==cita.getDia() && mes ==cita.getMes()){
                empleadosOcupados.add(cita.getEmpleado());

            }

        }
        empleados.removeAll(empleadosOcupados);
        return empleados;
    }

    static public void mostrarCitas(){
        for(Cita cita : listaCitas){
            System.out.println(cita.toString());
        }
    }






}



