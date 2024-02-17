import javax.swing.*;
import java.util.*;

public class Peluqueria {
    public static void main (String[] args){
        RegistroUsuarios.cargarUsuarios();

        RegistroUsuarios.imprimirUsuarios();
        RegistroEmpleados.agregarPeluqueros();
        Users users = new Users(null);

    }
}
