import java.lang.reflect.Array;
import java.util.ArrayList;

public class RegistroEmpleados {

    static ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
    static public void agregarPeluqueros(){
        Empleado peluquero1 = new Peluquero("Carlos", "Lopez","peluquero1");
        Empleado peluquero2 = new Peluquero("Mirlos", "Lopez","peluquero2");
        listaEmpleados.add(peluquero1);
        listaEmpleados.add(peluquero2);
    }

    static public ArrayList exportarPeluqueros(){
        return listaEmpleados;
    }

}
