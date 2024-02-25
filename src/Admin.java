import javax.swing.*;
import java.awt.event.*;

public class Admin extends JDialog  {
    protected JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton iniciarSesiónButton;
    private JFrame parent;

    public Admin(JFrame parent) {
        super(parent);
        this.parent = parent;

        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();

            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });

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
                menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuFrame.setContentPane(menuAdmin.menuAdmin);
                menuFrame.setSize(350, 250);
                menuFrame.setLocationRelativeTo(null);
                menuFrame.setVisible(true);
                parent.dispose(); // Cierra la ventana de Admin


            } else {
                JOptionPane.showMessageDialog(panel1, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método de ejemplo para verificar las credenciales (ajústalo según tus necesidades)
    private boolean verificarCredenciales(String usuario, char[] contraseña) {
        // Lógica para verificar las credenciales
        // Devuelve true si las credenciales son correctas, false de lo contrario
        return usuario.equals("admin") && new String(contraseña).equals("massimo");
    }

    private void cerrarVentana() {
        dispose();
    }



    public static void mostrarAdmin() {
        JFrame mainFrame = new JFrame("Admin Frame");
        Admin admin = new Admin(mainFrame);
        mainFrame.setContentPane(admin.panel1);
        mainFrame.setSize(400, 560);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cambiado de EXIT_ON_CLOSE a DISPOSE_ON_CLOSE
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
