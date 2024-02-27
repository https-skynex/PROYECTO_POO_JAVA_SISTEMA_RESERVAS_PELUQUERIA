import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPeluquero extends JDialog {
    private JTextField peluqueroField1;
    private JPasswordField passwordField1;
    private JButton iniciarSesiónButton;
    private JPanel loginPeluquero;
    private Empleado empleadoLogeado;

    public LoginPeluquero(JFrame parent) {
        super(parent);
        setTitle("Login Peluquero");
        setContentPane(loginPeluquero);
        setMinimumSize(new Dimension(360, 225));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (peluqueroField1.getText().isEmpty() || passwordField1.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(LoginPeluquero.this, "Por favor, completa todos los campos antes de iniciar sesión.");
                } else {
                    empleadoLogeado = RegistroEmpleados.obtenerUsuario(peluqueroField1.getText(), new String(passwordField1.getPassword()));
                    if (empleadoLogeado != null) {
                        JOptionPane.showMessageDialog(LoginPeluquero.this, "¡Inicio de sesión exitoso!\nBienvenido");
                        abrirMenuPeluqueros(empleadoLogeado);

                        dispose();

                        dispose();
                    } else {
                            JOptionPane.showMessageDialog(LoginPeluquero.this, "Usuario no encontrado o credenciales incorrectas. Verifica la información.");
                    }
                }
            }
        });
        setVisible(true);
    }
    private void abrirMenuPeluqueros(Empleado empleadoLogeado) {
        JFrame frame = new JFrame();
        MenuPeluqueros menuPeluqueros = new MenuPeluqueros(frame, empleadoLogeado);
        frame.setContentPane(menuPeluqueros.panel1);  // Accede directamente al campo panel1
        frame.setSize(360, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginPeluquero loginPeluquero = new LoginPeluquero(null);
                loginPeluquero.setVisible(true);
            }
        });
    }
}
