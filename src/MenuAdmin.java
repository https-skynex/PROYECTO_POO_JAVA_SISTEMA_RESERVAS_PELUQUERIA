import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JDialog {
    public JPanel menuAdmin;
    private JButton cerrarSesiónButton;
    private JButton visualizarEstadisticasDelNegocioButton;
    private JButton agregarEmpleadosButton;
    private JDialog agregarEmpleadoDialog;
    private JFrame frame;

    public MenuAdmin(JFrame frame) {

        this.frame = frame;
        frame.setTitle("Menú de Usuarios");

        frame.setContentPane(menuAdmin);
        frame.setSize(350, 250); // Tamaño de la ventana
        frame.setLocationRelativeTo(null);
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cerrarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
        agregarEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });

        setVisible(true);
    }
    private void cerrarSesion() {
        // Cerrar la ventana actual
        frame.dispose();

        // Abrir la ventana de login de admin
        JFrame loginFrame = new JFrame("LoginAdmin");
        Admin admin = new Admin(loginFrame);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setContentPane(admin.panel1);
        loginFrame.setSize(400, 560);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private void agregarEmpleado() {
        agregarEmpleadoDialog = new JDialog(this, "Agregar Empleado", true);
        agregarEmpleadoDialog.setSize(300, 200);
        agregarEmpleadoDialog.setLayout(new GridLayout(4, 2));

        JTextField nombreField = new JTextField();
        JTextField apellidoField = new JTextField();
        JTextField contraseñaField = new JTextField();

        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String contraseña = contraseñaField.getText();

                // Verificar que todos los campos estén llenos
                if (!nombre.isEmpty() && !apellido.isEmpty() && !contraseña.isEmpty()) {
                    Peluquero peluquero = new Peluquero(nombre, apellido, contraseña);
                    RegistroEmpleados.nuevoPeluquero(peluquero);
                    RegistroEmpleados.guardarContadorE(peluquero.getContador());
                    RegistroEmpleados.guardarEmpleados();
                    JOptionPane.showMessageDialog(MenuAdmin.this, "Nuevo empleado creado exitosamente.\n " + "Codigo de acceso: " + peluquero.getCodigo());
                    agregarEmpleadoDialog.dispose();
                } else {
                    // Mostrar mensaje si algún campo está vacío
                    JOptionPane.showMessageDialog(MenuAdmin.this, "Todos los campos deben estar llenos.");
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEmpleadoDialog.dispose();
            }
        });

        agregarEmpleadoDialog.add(createCenteredLabel("Nombre:"));
        agregarEmpleadoDialog.add(nombreField);
        agregarEmpleadoDialog.add(createCenteredLabel("Apellido:"));
        agregarEmpleadoDialog.add(apellidoField);
        agregarEmpleadoDialog.add(createCenteredLabel("Contraseña:"));
        agregarEmpleadoDialog.add(contraseñaField);
        agregarEmpleadoDialog.add(confirmarButton);
        agregarEmpleadoDialog.add(cancelarButton);

        agregarEmpleadoDialog.setLocationRelativeTo(frame);
        agregarEmpleadoDialog.setVisible(true);
    }

    private JLabel createCenteredLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("LoginAdmin");
                MenuAdmin mAdmin = new MenuAdmin(frame);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(mAdmin.menuAdmin);
                frame.setSize(350, 250);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
