import javax.swing.*;
import java.util.*;

public class Peluqueria {
    public static void main (String[] args){
        RegistroUsuarios.cargarUsuarios();
        RegistroUsuarios.cargarContador();
        RegistroEmpleados.cargarEmpleados();
        RegistroEmpleados.cargarContadorE();
        RegistroCitas.cargarCitas();
        RegistroUsuarios.imprimirUsuarios();
        RegistroEmpleados.imprimirEmpleados();

        //RegistroEmpleados.agregarPeluqueros();
        RegistroCitas.mostrarCitas();
        //Users users = new Users(null);
        Admin.mostrarAdmin();
        //RegistroCitas.mostrarCitas();





    }
}
