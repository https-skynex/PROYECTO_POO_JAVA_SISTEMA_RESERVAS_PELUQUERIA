import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlCitas {
    private JPanel panel1;
    private JComboBox añoBox;
    private JComboBox mesBox;
    private JComboBox diaBox;
    private JButton buscarButton;
    private JComboBox comboBox1;
    private JButton asistioButton;
    private JButton noAsistioButton;
    private JTable table1;
    private Frame frame;
    private CustomTableModel tableModel;
    private Empleado empleado;
    private ArrayList<Cita> registroCitasPorEmpleado;


    public ControlCitas() {

        Object[][] initialData = {};

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String año = (String) añoBox.getSelectedItem();
                String mes = (String) mesBox.getSelectedItem();
                String dia = (String) diaBox.getSelectedItem();

                // Verificar si año o mes están vacíos
                if ( año.isEmpty()  || mes.isEmpty() || dia.isEmpty()) {JOptionPane.showMessageDialog(panel1, "Llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);    return;}

                    RegistroEmpleados.imprimirEmpleados();
                    System.out.println(RegistroCitas.cantidadCitasPorEmpleado(dia, mes, año, empleado));
                    registroCitasPorEmpleado = new ArrayList<Cita>();
                    registroCitasPorEmpleado = RegistroCitas.citasPorEmpleados(dia, mes, año, empleado);
                    Object[][] data = new Object[registroCitasPorEmpleado.size()+1][6];
                    data [0][0] = "Codigo Cliente";
                    data [0][1] = "Nombre";
                    data [0][2] = "horario";
                    data [0][3] = "Servicio";
                    data [0][4] = "Precio";
                    data [0][5] = "Confirmacion";
                    int i = 0;
                    for (Cita cita : registroCitasPorEmpleado) {
                        i++;
                        // Asignar los valores a cada celda del arreglo
                        data[i][0] = cita.getUsuario().getCodigo();
                        data[i][1] = cita.getUsuario().getNombre();
                        data[i][2] = cita.getHora();
                        data[i][3] = cita.getServicio().getNombre();
                        data[i][4] = cita.getServicio().getPrecio();
                        data[i][5] = cita.getEstado();
                    }
                    Object[] columnNames = {"Codigo de cliente", "Nombre", "horario ", "Servicio",
                    "Precio", "Confirmacion"};

                    // Crear una nueva instancia de CustomTableModel con datos y nombres de columna
                    tableModel = new CustomTableModel(data, columnNames);

                    // Establecer el modelo de la tabla
                    table1.setModel(tableModel);

                    // Notificar que los datos de la tabla han cambiado
                    tableModel.setData(data);

                    // Imprimir los valores de la matriz data
                    /*for (int i = 0; i < data.length; i++) {
                        for (int j = 0; j < data[i].length; j++) {
                            System.out.print(data[i][j] + " ");
                        }
                        System.out.println();  // Salto de línea después de cada fila
                    }*/
            }
        });
    }
    public void mostrarVentanaCitas(Empleado empleado) {
        this.empleado = empleado;
        JFrame frame = new JFrame("Stats");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(720, 720);
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
