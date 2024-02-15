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
    static RegistroUsuarios lista = new RegistroUsuarios();
    public Users(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(login);
        setMinimumSize(new Dimension(480, 480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        RegistroEmpleados.agregarPeluqueros();




        iniciarSesiónButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lista.cargarUsuarios();
                if (textField1.getText().isEmpty() || textField2.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(Users.this, "Por favor, completa todos los campos antes de iniciar sesión.");
                } else {
                    lista.cargarUsuarios();
                    usuarioLogueado = lista.obtenerUsuario(textField1.getText(), new String(textField2.getPassword()));
                    if (usuarioLogueado != null) {
                        JOptionPane.showMessageDialog(Users.this, "¡Inicio de sesión exitoso!\nBienvenido");
                        abrirMenuUsuarios(usuarioLogueado);
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
        if (lista.verificarUsuario(codigoUsuario,contraseña)) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!\nBienvenido");
            return;
        }

        JOptionPane.showMessageDialog(this, "Usuario no encontrado o credenciales incorrectas. Verifica la información.");
    }

    private void crearNuevoUsuario() {

        JDialog crearUsuarioDialog = new JDialog(this, "Crear Nuevo Usuario", true);
        crearUsuarioDialog.setSize(300, 200);
        crearUsuarioDialog.setLayout(new GridLayout(5, 2));

        JTextField nombreField = new JTextField();
        JTextField apellidoField = new JTextField();
        JTextField contraseñaField = new JTextField(); // Añadido el campo de contraseña

        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.cargarContador();
                Usuario nuevoUsuario = new Usuario(nombreField.getText(), apellidoField.getText(), contraseñaField.getText());
                lista.agregarUsuario(nuevoUsuario);
                lista.guardarUsuarios();
                lista.guardarContador(nuevoUsuario.getContador());
                crearUsuarioDialog.dispose();
                JOptionPane.showMessageDialog(Users.this, "Nuevo usuario creado exitosamente.\nCódigo de usuario: " + nuevoUsuario.getCodigo());

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