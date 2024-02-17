import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Users extends JDialog {
    private JTextField textField1;
    private JPasswordField textField2;
    private JPanel login;
    private JButton iniciarSesiónButton;
    private JButton crearUsuarioButton;
    private Usuario usuarioLogueado;

    public Users(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(login);
        setMinimumSize(new Dimension(480, 480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);





        iniciarSesiónButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (textField1.getText().isEmpty() || textField2.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(Users.this, "Por favor, completa todos los campos antes de iniciar sesión.");
                } else {

                    usuarioLogueado = RegistroUsuarios.obtenerUsuario(textField1.getText(), new String(textField2.getPassword()));
                    if (usuarioLogueado != null) {
                        JOptionPane.showMessageDialog(Users.this, "¡Inicio de sesión exitoso!\nBienvenido");
                        abrirMenuUsuarios(usuarioLogueado);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(Users.this, "Usuario no encontrado o credenciales incorrectas. Verifica la información.");
                    }
                }
            }
        });
        crearUsuarioButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                crearNuevoUsuario();
            }
        });

        setVisible(true);
    }

    private void abrirMenuUsuarios(Usuario usuario) {
        JFrame frame = new JFrame();
        MenuUsuarios menuUsuarios = new MenuUsuarios(frame, usuario);
        frame.setContentPane(menuUsuarios.panel1);  // Accede directamente al campo panel1
        frame.setSize(360, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }


    private void verificarUsuario() {
        String codigoUsuario = textField1.getText();
        String contraseña = textField2.getText();
        if (RegistroUsuarios.verificarUsuario(codigoUsuario,contraseña)) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!\nBienvenido");
            return;
        }

        JOptionPane.showMessageDialog(this, "Usuario no encontrado o credenciales incorrectas. Verifica la información.");
    }

    private void crearNuevoUsuario() {

        JDialog crearUsuarioDialog = new JDialog(this, "Crear Nuevo Usuario", true);
        crearUsuarioDialog.setSize(300, 250);
        crearUsuarioDialog.setLayout(new GridLayout(6, 2));

        JTextField nombreField = new JTextField();
        JTextField apellidoField = new JTextField();
        JTextField contraseñaField = new JTextField();
        JTextField telefonoField = new JTextField();

        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String contraseña = contraseñaField.getText();
                String telefono = telefonoField.getText();

                // Verificar que todos los campos estén llenos
                if (!nombre.isEmpty() && !apellido.isEmpty() && !contraseña.isEmpty() && !telefono.isEmpty()) {
                    RegistroUsuarios.cargarContador();
                    Usuario nuevoUsuario = new Usuario(nombre, apellido, contraseña, telefono);
                    RegistroUsuarios.agregarUsuario(nuevoUsuario);
                    RegistroUsuarios.guardarUsuarios();
                    RegistroUsuarios.guardarContador(nuevoUsuario.getContador());
                    crearUsuarioDialog.dispose();
                    JOptionPane.showMessageDialog(Users.this, "Nuevo usuario creado exitosamente.\nCódigo de usuario: " + nuevoUsuario.getCodigo());
                } else {
                    // Mostrar mensaje si algún campo está vacío
                    JOptionPane.showMessageDialog(Users.this, "Todos los campos deben estar llenos.");
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUsuarioDialog.dispose();
            }
        });

        crearUsuarioDialog.add(new JLabel("Nombre:"));
        crearUsuarioDialog.add(nombreField);
        crearUsuarioDialog.add(new JLabel("Apellido:"));
        crearUsuarioDialog.add(apellidoField);
        crearUsuarioDialog.add(new JLabel("Contraseña:"));
        crearUsuarioDialog.add(contraseñaField);
        crearUsuarioDialog.add(new JLabel("Número de Teléfono:"));
        crearUsuarioDialog.add(telefonoField); // Agregado el campo para el número de teléfono
        crearUsuarioDialog.add(confirmarButton);
        crearUsuarioDialog.add(cancelarButton);

        crearUsuarioDialog.setLocationRelativeTo(this);
        crearUsuarioDialog.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Users(null);
            }
        });
    }
}