import java.util.*;

public class LogicaTablas {
    public static void main(String[]args){
        Usuario usuario = new Usuario("Kevin", "Perez", "hola", "099");
        Peluquero peluquero = new Peluquero("Carlos", "Lopez", "peluquero1");
        Servicio servicio = new Servicio("Corte de pelo", 20.5);
        Cita cita1 = new Cita(usuario, peluquero, servicio, 9, 1,1);
        Cita cita2 = new Cita(usuario, peluquero, servicio, 10, 1,1);
        Cita cita3 = new Cita(usuario, peluquero, servicio, 11, 1,1);
        RegistroCitas registroCitas = new RegistroCitas();
        String dia = null, mes =null, año = null;

        registroCitas.agregarCita(cita1);
        registroCitas.agregarCita(cita2);
        registroCitas.agregarCita(cita3);


        Object[][] data = new Object[12][3];
        año ="2024";
        if ((dia == null || dia.isEmpty()) && (mes == null || mes.isEmpty())) {

            for (int i = 0; i < 12; i++) {
                // Asignar los valores a cada celda del arreglo
                data[i][0] = i + 1;  // Suma 1 al índice para que represente correctamente el mes

            }


            // Imprimir los valores de la matriz data
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();  // Salto de línea después de cada fila
            }
        }
        else if ((dia == null || dia.isEmpty())) {


        } else {
            // Configuración predeterminada


        }

    }
}
