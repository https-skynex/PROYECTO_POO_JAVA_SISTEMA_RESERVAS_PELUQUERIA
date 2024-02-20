import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RegistroEmpleados {

    static ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

    static public int cantidadEmpleados(){
        return listaEmpleados.size();
    }

    static public String getCodigoEmpleado(int i){
        return listaEmpleados.get(i).getCodigo();
    }

    static public String getNombreEmpleado(int i){
        String nombre = listaEmpleados.get(i).getNombre();
        String apellido = listaEmpleados.get(i).getApellido();
        return nombre + " " + apellido;
    }

    static public Empleado obtenerUsuario(String codigoEmpleado, String contraseña) {
        for (Empleado peluquero : listaEmpleados) {
            if (peluquero.getCodigo().equals(codigoEmpleado) && peluquero.getContraseña().equals(contraseña)) {
                return peluquero;
            }
        }
        return null;
    }

    static public void nuevoPeluquero(Peluquero peluquero){
        listaEmpleados.add(peluquero);
    }

    static public ArrayList exportarPeluqueros(){
        return listaEmpleados;
    }

    static public void imprimirEmpleados(){
        for(Empleado empleado: listaEmpleados){
            System.out.println(empleado.getCodigo() + " " + empleado.getContraseña());
        }
    }

    static public void guardarEmpleados() {
        try {
            FileOutputStream fos = new FileOutputStream("empleados.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaEmpleados);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static public void cargarEmpleados() {
        try {
            FileInputStream fis = new FileInputStream("empleados.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaEmpleados= (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException f){
            System.out.println("Base de datos no encontrada, creando nueva base");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    static public void guardarContadorE(int numerador) {
        try {
            FileOutputStream fos = new FileOutputStream("contadorEmpleados.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(numerador);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static public void cargarContadorE() {
        try {
            FileInputStream fis = new FileInputStream("contadorEmpleados.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Empleado.setNumerador((int) ois.readObject());
            ois.close();
            fis.close();
        } catch (FileNotFoundException f){

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

}
