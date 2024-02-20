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

                        System.out.println(empleadoLogeado.toString());
                        dispose();
                    } else {
                            JOptionPane.showMessageDialog(LoginPeluquero.this, "Usuario no encontrado o credenciales incorrectas. Verifica la información.");
                    }
                }
            }
        });
        setVisible(true);
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
