import java.io.*;
import java.util.*;

public class RegistroCitas {
    static private ArrayList<Cita> listaCitas = new ArrayList<>();

    static public ArrayList obtenerRegistroCitas(){
        return listaCitas;
    }
    static public void agregarCita(Cita cita) {
        if (!listaCitas.contains(cita)) {
            listaCitas.add(cita);
        } else {
            System.out.println("Ya hay una cita registrada para ese peluquero, día y hora.");
        }
    }

    static public boolean choqueCitas (String hora1, String dia1, String mes1, Usuario usuario) {
        System.out.println( hora1 + dia1 + mes1 + usuario);
        int hora = Integer.parseInt(hora1);
        int dia = Integer.parseInt(dia1);
        int mes = Integer.parseInt(mes1);
        boolean choque = false;
        RegistroCitas.mostrarCitas();
        for (Cita cita : listaCitas) {
            System.out.println(cita.getHora() + " " + cita.getDia()  + " " + cita.getMes() + " " + cita.getUsuario() );
            if (hora == cita.getHora() && dia == cita.getDia() && mes == cita.getMes() && usuario.equals(cita.getUsuario())) {
                System.out.println("Si entro a choque : " + cita.getUsuario());
                choque = true;
                break;
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
        /*for (Empleado e: empleados){
            System.out.println(e.toString());
        }*/

        for (Cita cita :listaCitas){
           // System.out.println(cita.getHora() + " " + cita.getDia()  + " " + cita.getMes());
            if(hora == cita.getHora() && dia == cita.getDia() && mes == cita.getMes()){
               // System.out.println("Si entra " + cita.getEmpleado());
                empleadosOcupados.add(cita.getEmpleado());

            }

        }
        empleados.removeAll(empleadosOcupados);
        /*for (Empleado e: empleados){
            System.out.println(e.toString());
        }*/
        return empleados;
    }

    static public void mostrarCitas(){
        for(Cita cita : listaCitas){
            System.out.println(cita.toString());
        }
    }

    static public int cantidadClientesMes(int mes, String año){
        int suma =0;
        int añoC = Integer.parseInt(año);
        for(Cita cita : listaCitas){
            if(mes == cita.getMes() && añoC == cita.getAño()){
                suma++;
            }
        }
        return suma;
    }

    static public double cantidadGananciasMes(int mes, String año){
        double suma =0;
        int añoC = Integer.parseInt(año);
        for(Cita cita : listaCitas){
            if(mes == cita.getMes() && añoC == cita.getAño()){
                suma = suma + cita.getServicio().getPrecio();
            }
        }
        return suma;
    }



    static public void guardarCitas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("citas.txt"))) {
            oos.writeObject(listaCitas);
            System.out.println("Citas guardadas correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void cargarCitas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("citas.txt"))) {
            listaCitas = (ArrayList<Cita>) ois.readObject();
            System.out.println("Citas cargadas correctamente. Total de citas: " + listaCitas.size());
        } catch (FileNotFoundException f) {
            System.out.println("Base de datos no encontrada, creando nueva base");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}



