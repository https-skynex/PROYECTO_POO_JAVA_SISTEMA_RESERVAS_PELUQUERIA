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
        System.out.println(RegistroEmpleados.cantidadEmpleados());

        //System.out.println(RegistroEmpleados.getNombreEmpleado(0));
        //System.out.println(RegistroEmpleados.cantidadEmpleados());
        //RegistroEmpleados.agregarPeluqueros();
        //RegistroCitas.mostrarCitas();
        //Admin.mostrarAdmin();
      //Users users = new Users(null);
      Admin.mostrarAdmin();
      //LoginPeluquero loginPeluquero = new LoginPeluquero(null);
        RegistroCitas.mostrarCitas();

    }
}
