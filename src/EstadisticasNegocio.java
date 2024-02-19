import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class EstadisticasNegocio {
    private JPanel panel1;
    private JComboBox<String> añoBox;
    private JComboBox<String> mesBox;
    private JComboBox<String> diaBox;
    private JButton button1;
    private JTable table1;

    private CustomTableModel tableModel;

    public EstadisticasNegocio(JFrame frame,RegistroCitas registroCitas ) {
        Object[][] initialData = {};  // Puedes ajustar según sea necesario


        // Resto del código...

        // Ejemplo de lógica para cambiar la estructura de la tabla
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String año = (String) añoBox.getSelectedItem();
                String mes = (String) mesBox.getSelectedItem();
                String dia = (String) diaBox.getSelectedItem();



                // Verificar si año o mes están vacíos
                if ((año == null || año.isEmpty()) && (mes == null || mes.isEmpty())) {
                    JOptionPane.showMessageDialog(panel1, "Rellenar los campos de año y mes", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if ((año == null || año.isEmpty())){
                    JOptionPane.showMessageDialog(panel1, "Rellenar el campo de año ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }


                if ((dia == null || dia.isEmpty()) && (mes == null || mes.isEmpty())) {

                    Object[][] data = new Object[13][3];
                    data [0][0] = "Mes";
                    data [0][1] = "Cantida de clientes";
                    data [0][2] = "Ganancias";
                    for (int i = 1; i <= 12; i++) {
                        // Asignar los valores a cada celda del arreglo
                        data[i][0] = i ;  // Suma 1 al índice para que represente correctamente el mes
                        data[i][1] = RegistroCitas.cantidadClientesMes(i, año);
                        data[i][2] = RegistroCitas.cantidadGananciasMes(i, año);
                    }
                    Object[] columnNames = {"Mes", "Cantidad de Clientes", "Ganancias"};

                    // Crear una nueva instancia de CustomTableModel con datos y nombres de columna
                    tableModel = new CustomTableModel(data, columnNames);

                    // Establecer el modelo de la tabla
                    table1.setModel(tableModel);

                    // Notificar que los datos de la tabla han cambiado
                    tableModel.setData(data);

                    // Imprimir los valores de la matriz data
                    for (int i = 0; i < data.length; i++) {
                        for (int j = 0; j < data[i].length; j++) {
                            System.out.print(data[i][j] + " ");
                        }
                        System.out.println();  // Salto de línea después de cada fila
                    }

                } else if ((dia == null || dia.isEmpty())) {

                } else {

                }
            }

            private ArrayList<Cita> obtenerCitasFiltradas(RegistroCitas registroCitas, String año, String mes, String dia) {
                if (dia == null || dia.isEmpty()) {

                } else if ((dia == null || dia.isEmpty() )&& (mes.isEmpty()|| mes == null)) {

                } else {

                }
                return null;
            }

            private Object[][] procesarCitas(ArrayList<Cita> citas) {
                // Implementa lógica para procesar las citas y obtener datos para la tabla
                // Puedes usar un bucle y otras estructuras de datos según lo necesario
                // Devuelve una matriz bidimensional con los datos procesados
                return new Object[0][];
            }
        });
    }


    public void mostrarVentana() {
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
                JFrame frame = new JFrame("LoginAdmin");
                RegistroCitas citas = new RegistroCitas();
                EstadisticasNegocio stats = new EstadisticasNegocio(frame, citas);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(stats.panel1);
                frame.setSize(720, 720);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
