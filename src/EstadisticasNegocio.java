import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class EstadisticasNegocio {
    private JPanel panel1;
    private JComboBox<String> añoBox;
    private JComboBox<String> mesBox;
    private JComboBox<String> diaBox;
    private JButton buscar;
    private JTable table1;
    private JButton salirButton;

    private CustomTableModel tableModel;

    public EstadisticasNegocio() {
        Object[][] initialData = {};  // Puedes ajustar según sea necesario
        tableModel = new CustomTableModel(initialData, new Object[]{"", "", ""});



        // Resto del código...

        // Ejemplo de lógica para cambiar la estructura de la tabla
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String año = (String) añoBox.getSelectedItem();
                String mes = (String) mesBox.getSelectedItem();
                String dia = (String) diaBox.getSelectedItem();

                // Verificar si año o mes están vacíos
                if ((año.isEmpty()) && ( mes.isEmpty()) && (!dia.isEmpty())) {
                    JOptionPane.showMessageDialog(panel1, "Rellenar el campo de año y mes ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if ((!año.isEmpty()) && (mes.isEmpty()) && (!dia.isEmpty())){
                    JOptionPane.showMessageDialog(panel1, "Rellenar el campo de mes ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if ((año.isEmpty())){
                    JOptionPane.showMessageDialog(panel1, "Rellenar el campo de año ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }



                if ((dia == null || dia.isEmpty()) && (mes == null || mes.isEmpty())) {

                    Object[][] data = new Object[13][3];
                    data [0][0] = "Mes";
                    data [0][1] = "Cantida de clientes";
                    data [0][2] = "Ganancias";
                    for (int i = 1; i <= 12; i++) {
                        // Asignar los valores a cada celda del arreglo
                        data[i][0] = obtenerMes(i) ;  // Suma 1 al índice para que represente correctamente el mes
                        data[i][1] = RegistroCitas.cantidadClientesMes(i, año);
                        data[i][2] = "$ "+RegistroCitas.cantidadGananciasMes(i, año);
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

                } else if ((dia == null || dia.isEmpty())&&(mes != null || !mes.isEmpty())) {

                    Object[][] data = new Object[31][3];
                    data [0][0] = "Dia";
                    data [0][1] = "Cantida de clientes";
                    data [0][2] = "Ganancias";
                    for (int i = 1; i <= 30; i++) {
                        // Asignar los valores a cada celda del arreglo
                        data[i][0] = i ;  // Suma 1 al índice para que represente correctamente el mes
                        data[i][1] = RegistroCitas.cantidadClientesDia(i, mes, año);
                        data[i][2] = RegistroCitas.cantidadGananciasDia(i, mes, año);
                    }
                    Object[] columnNames = {"Dia", "Cantidad de Clientes", "Ganancias"};

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


                } else if ((dia != null ||! dia.isEmpty())&&(mes != null || !mes.isEmpty())){
                    RegistroEmpleados.imprimirEmpleados();
                    System.out.println(RegistroEmpleados.cantidadEmpleados());

                    Object[][] data = new Object[RegistroEmpleados.cantidadEmpleados()+1][4];
                    data [0][0] = "Codigo de empleado";
                    data [0][1] = "Nombre";
                    data [0][2] = "Cantidad de clientes";
                    data [0][3] = "Ganancias";
                    for (int i = 1; i <= RegistroEmpleados.cantidadEmpleados(); i++) {
                        // Asignar los valores a cada celda del arreglo
                        data[i][0] = RegistroEmpleados.getCodigoEmpleado(i-1);
                        data[i][1] = RegistroEmpleados.getNombreEmpleado(i-1);
                        data[i][2] = RegistroCitas.cantidadClientesporEmpleado(i-1, dia ,mes, año);
                        data[i][3] = RegistroCitas.cantidadGananciasporEmpleado(i-1, dia ,mes, año);
                    }

                    Object[] columnNames = {"Codigo de empleado", "Nombre", "Cantidad de clientes ", "Ganancias"};

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

                }
            }
            private String obtenerMes(int i){
                if (i == 1){return "Enero";}
                else if (i == 2){return "Febrero";}
                else if (i == 3){return "Marzo";}
                else if (i == 4){return "Abril";}
                else if (i == 5){return "Mayo";}
                else if (i == 6){return "Junio";}
                else if (i == 7){return "Julio";}
                else if (i == 8){return "Agosto";}
                else if (i == 9){return "Septiembre";}
                else if (i == 10){return "Octubre";}
                else if (i == 11){return "Noviembre";}
                else if (i == 12){return "Diciembre";}
                else {return null;}

            }

        });

        ActionListener comboBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vaciar la tabla
                tableModel.setData(new Object[][]{});

                // Obtener las selecciones de día, mes y año
                String díaSeleccionado = (String) diaBox.getSelectedItem();
                String mesSeleccionado = (String) mesBox.getSelectedItem();
                String añoSeleccionado = (String) añoBox.getSelectedItem();

                // Realizar las operaciones según sea necesario
                // ...

                // Actualizar la tabla con los nuevos datos
                table1.setModel(tableModel);
            }
        };

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        // Agregar el ActionListener a los JComboBox (dia, mes, año)
        añoBox.addActionListener(comboBoxListener);
        mesBox.addActionListener(comboBoxListener);
        diaBox.addActionListener(comboBoxListener);
    }


    public void mostrarVentana() {
        JFrame frame = new JFrame("Stats");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(720, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("LoginAdmin");
                RegistroCitas citas = new RegistroCitas();
                EstadisticasNegocio stats = new EstadisticasNegocio();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(stats.panel1);
                frame.setSize(720, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
