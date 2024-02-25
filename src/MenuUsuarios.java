import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUsuarios {
    JPanel panel1;
    private JButton reservarCita;
    private JButton cambiarContraseña;
    private JButton cerrarSesionButton;
    private Usuario usuario;
    private JFrame frame;
    public MenuUsuarios(JFrame frame, Usuario user) {
        this.frame = frame;
        this.usuario = user;
        frame.setTitle("Menú de Usuarios");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setSize(360, 360); // Tamaño de la ventana
        frame.setLocationRelativeTo(null);

        reservarCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroCitas registroCitas = new RegistroCitas();
                AgendarCita agendarCita = new AgendarCita(registroCitas);
                agendarCita.mostrarVentana(usuario);
            }
        });
        cambiarContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarContraseñaActionPerformed(e);

            }
        });

        cerrarSesionButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Users usuario = new Users(null);
            }

        });
    }

    private void cambiarContraseñaActionPerformed(ActionEvent e) {
        if (usuario != null) {
            String newPassword = JOptionPane.showInputDialog(frame, "Ingrese la nueva contraseña:");

            // Verifica si se ingresó una nueva contraseña
            if (newPassword != null) {
                usuario.setContraseña(newPassword);
                RegistroUsuarios.guardarUsuarios();
                // Muestra un mensaje de éxito en una nueva ventana
                JOptionPane.showMessageDialog(frame, "Contraseña cambiada correctamente");

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
                MenuUsuarios menuUsuarios = new MenuUsuarios(frame,null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(menuUsuarios.panel1);
                frame.setSize(360, 360);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }


}