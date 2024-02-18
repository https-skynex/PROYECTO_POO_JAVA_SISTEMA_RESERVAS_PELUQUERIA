import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Admin extends JDialog  {
    protected JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton iniciarSesiónButton;

    public Admin(JFrame parent) {
        super(parent);


        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        // Añade un KeyListener para manejar el evento cuando se presiona Enter en los campos de texto
        KeyListener enterKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarSesion();
                }
            }
        };

        textField1.addKeyListener(enterKeyListener);
        passwordField1.addKeyListener(enterKeyListener);
    }

    private void iniciarSesion() {
        String usuario = textField1.getText();
        char[] contraseña = passwordField1.getPassword();

        // Verifica si los campos están llenos
        if (usuario.isEmpty() || contraseña.length == 0) {
            JOptionPane.showMessageDialog(panel1, "Por favor, llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Verifica las credenciales (puedes ajustar esta lógica según tus necesidades)
            if (verificarCredenciales(usuario, contraseña)) {
                // Credenciales correctas, abre la interfaz MenuAdmin
                JFrame menuFrame = new JFrame("MenuAdmin");
                MenuAdmin menuAdmin = new MenuAdmin(menuFrame);
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setContentPane(menuAdmin.menuAdmin);
                menuFrame.setSize(350, 250);
                menuFrame.setLocationRelativeTo(null);
                menuFrame.setVisible(true);

                // Cierra la ventana de login
                ((JFrame) SwingUtilities.getWindowAncestor(panel1)).dispose();
            } else {
                JOptionPane.showMessageDialog(panel1, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método de ejemplo para verificar las credenciales (ajústalo según tus necesidades)
    private boolean verificarCredenciales(String usuario, char[] contraseña) {
        // Lógica para verificar las credenciales
        // Devuelve true si las credenciales son correctas, false de lo contrario
        return usuario.equals("admin") && new String(contraseña).equals("massiso");
    }



    public static void mostrarAdmin() {
        JFrame mainFrame = new JFrame("Admin Frame");
        Admin admin = new Admin(mainFrame);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(admin.panel1);
        mainFrame.setSize(400, 560);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrarAdmin();  // Puedes ejecutar Admin como una aplicación independiente
            }
        });
    }
}
