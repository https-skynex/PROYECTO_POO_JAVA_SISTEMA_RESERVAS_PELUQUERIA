import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.*;

public class ControlCitas {
    private JPanel panel1;
    private JComboBox<String> añoBox;
    private JComboBox<String> mesBox;
    private JComboBox<String> diaBox;
    private JButton buscarButton;
    private JComboBox<Cita> clientes;
    private JButton asistioButton;
    private JButton noAsistioButton;
    private JTable table1;
    private JButton salirButton;
    private Frame frame;
    private CustomTableModel tableModel;
    private Empleado empleado;
    private ArrayList<Cita> registroCitasPorEmpleado;

    public ControlCitas() {
        Object[][] initialData = {};

        // Inicializar el ArrayList
        registroCitasPorEmpleado = new ArrayList<>();

        // Acción del botón "Buscar"
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String año = (String) añoBox.getSelectedItem();
                String mes = (String) mesBox.getSelectedItem();
                String dia = (String) diaBox.getSelectedItem();

                // Verificar si año o mes están vacíos
                if (año.isEmpty() || mes.isEmpty() || dia.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener las citas por empleado y fecha

                registroCitasPorEmpleado = RegistroCitas.citasPorEmpleados(dia, mes, año, empleado);
                Collections.sort(registroCitasPorEmpleado);
                // Actualizar la JComboBox de clientes
                actualizarClientes();

                // Crear y establecer el modelo de la tabla
                actualizarTabla();
            }
        });

        asistioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la cita seleccionada en la JComboBox
                Cita citaSeleccionada = (Cita) clientes.getSelectedItem();

                // Verificar si se ha seleccionado una cita
                if (citaSeleccionada != null) {
                    // Actualizar el estado de la cita
                    citaSeleccionada.setEstado("asistio");
                    RegistroCitas.guardarCitas();
                    // Actualizar la tabla
                    actualizarTabla();
                }
            }
        });

        noAsistioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la cita seleccionada en la JComboBox
                Cita citaSeleccionada = (Cita) clientes.getSelectedItem();

                // Verificar si se ha seleccionado una cita
                if (citaSeleccionada != null) {
                    // Actualizar el estado de la cita
                    citaSeleccionada.setEstado("no asistio");
                    RegistroCitas.guardarCitas();
                    // Actualizar la tabla
                    actualizarTabla();
                }
            }
        });


        // Acción de cambio en JComboBox (dia, mes, año)
        ActionListener comboBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroCitasPorEmpleado.clear();
                clientes.removeAllItems();
                actualizarTabla();
            }
        };
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispatchEvent(new  WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        // Agregar el ActionListener a los JComboBox (dia, mes, año)
        añoBox.addActionListener(comboBoxListener);
        mesBox.addActionListener(comboBoxListener);
        diaBox.addActionListener(comboBoxListener);
    }

    private void actualizarClientes() {
        // Limpiar la JComboBox de clientes
        clientes.removeAllItems();
        int i = 0;
        // Llenar la JComboBox con los nombres de los clientes
        for (Cita cita : registroCitasPorEmpleado) {
            i++;
            clientes.addItem(cita);
        }
    }

    private void actualizarTabla() {
        // Crear los datos y nombres de columna para la tabla
        Object[][] data = new Object[registroCitasPorEmpleado.size() + 1][8];
        data[0] = new Object[]{"","Codigo Cliente", "Nombres", "Telefono", "horario", "Servicio", "Precio", "Confirmacion"};

        int i = 0;
        for (Cita cita : registroCitasPorEmpleado) {
            i++;
            // Asignar los valores a cada celda del arreglo
            data[i] = new Object[]{
                    i,
                    cita.getUsuario().getCodigo(),
                    cita.getUsuario().getNombre() + " " +cita.getUsuario().getApellido(),
                    cita.getUsuario().getNumeroTelefono(),
                    cita.getHora(),
                    cita.getServicio().getNombre(),
                    "$ " + cita.getServicio().getPrecio(),
                    cita.getEstado()
            };
        }

        Object[] columnNames = {"n","Codigo de cliente", "Nombre", "Telefono", "horario", "Servicio", "Precio", "Confirmacion"};

        // Crear una nueva instancia de CustomTableModel con datos y nombres de columna
        tableModel = new CustomTableModel(data, columnNames);

        // Establecer el modelo de la tabla
        table1.setModel(tableModel);

        // Notificar que los datos de la tabla han cambiado
        tableModel.setData(data);
    }

    public void mostrarVentanaCitas(Empleado empleado) {
        this.empleado = empleado;
        JFrame frame = new JFrame("Citas Peluqueros");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Citas Peluqueros");
                ControlCitas control = new ControlCitas();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(control.panel1);
                frame.setSize(720, 720);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
