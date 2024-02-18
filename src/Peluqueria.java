import javax.swing.*;
import java.util.*;

public class Peluqueria {
    public static void main (String[] args){
        //RegistroUsuarios.cargarUsuarios();
        RegistroEmpleados.cargarEmpleados();
        //RegistroUsuarios.imprimirUsuarios();
        RegistroEmpleados.imprimirEmpleados();
        //RegistroEmpleados.agregarPeluqueros();
        //Users users = new Users(null);
        Admin.mostrarAdmin();

    }
}
