import java.util.*;

public class Peluqueria {
    static Scanner scan = new Scanner(System.in);
    static int opcion;
    public static void main (String[] args){
        RegistroUsuarios.cargarUsuarios();
        RegistroUsuarios.cargarContador();
        RegistroEmpleados.cargarEmpleados();
        RegistroEmpleados.cargarContadorE();
        RegistroCitas.cargarCitas();

        do {
            System.out.println("Bienvenido al test del funcionamiento de los programas \nDe la peluqueria Massimo");
            System.out.println("Menu\n1. Imprimir usuarios\n2. Imprimir empleados \n3. Mostrar Citas registradas " +
                    "\n4. Mostrar interfaz usuario \n5. Mostrar interfaz peluquero \n6. Mostrar interfaz Administrador " +
                    "\n7. Salir ");
            System.out.printf("Ingrese una opcion: ");
            opcion = scan.nextInt();
            System.out.println("");
            switch (opcion){

                case 1:
                    RegistroUsuarios.imprimirUsuarios();
                    System.out.println("");
                    break;
                case 2:
                    RegistroEmpleados.imprimirEmpleados();
                    System.out.println("");
                    break;
                case 3:
                    RegistroCitas.mostrarCitas();
                    System.out.println("");
                    break;
                case 4:
                    Users users = new Users(null);
                    break;
                case 5:
                    LoginPeluquero loginPeluquero = new LoginPeluquero(null);
                    break;
                case 6:
                    Admin.mostrarAdmin();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");

            }

        }while(opcion != 7 );
        System.out.println("Cerrando simulacion del programa");
    }
}
