import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPeluqueros {
    private JButton cerrarSesionButton;
    private JButton cambiarContraseñaButton;
    protected JPanel panel1;
    private JButton visualizarCitasButtom;
    private JFrame frame;
    private Empleado empleado;

    public MenuPeluqueros(JFrame frame, Empleado empleado) {
        this.frame = frame;
        this.empleado = empleado;
        frame.setTitle("Menú de peluquero");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setSize(360, 360); // Tamaño de la ventana
        frame.setLocationRelativeTo(null);

        cambiarContraseñaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarContraseñaActionPerformed(e);
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginPeluquero loginPeluquero = new LoginPeluquero(null);

            }

        });
        visualizarCitasButtom.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ControlCitas control = new ControlCitas();
                control.mostrarVentanaCitas(empleado);
            }

        });

        frame.setVisible(true);
    }

    private void cambiarContraseñaActionPerformed(ActionEvent e) {
        if (empleado != null) {
            String newPassword = JOptionPane.showInputDialog(frame, "Ingrese la nueva contraseña:");

            // Verifica si se ingresó una nueva contraseña
            if (newPassword != null) {
                empleado.setContraseña(newPassword);

                // Muestra un mensaje de éxito en una nueva ventana
                JOptionPane.showMessageDialog(frame, "Contraseña cambiada correctamente");
                RegistroEmpleados.guardarEmpleados();
                System.out.println(empleado.getCodigo() + " " + empleado.getContraseña());
                // Cierra la ventana actual después de cambiar la contraseña
            } else {

            }
        } else {
            JOptionPane.showMessageDialog(frame, "No se ha proporcionado un usuario válido.");
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("Menú de Usuarios");
                MenuPeluqueros menuPeluqueros = new MenuPeluqueros(frame,null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(menuPeluqueros.panel1);
                frame.setSize(360, 240);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}
