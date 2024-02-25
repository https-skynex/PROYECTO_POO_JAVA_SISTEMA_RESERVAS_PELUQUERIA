import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class CustomTableModel extends DefaultTableModel {
    private final Object[] columnNames;
    private Object[][] data;

   //Constructor de la tabla modelo
    public CustomTableModel(Object[][] initialData, Object[] columnNames) {
        super(initialData, columnNames);
        this.data = initialData;
        this.columnNames = columnNames;
    }

    // Método para establecer nuevos datos en la tabla
    public void setData(Object[][] newData) {
        // Limpiar datos existentes
        setRowCount(0);

        // Agregar nuevos datos
        for (Object[] row : newData) {
            addRow(row);
        }

        // Notificar que los datos de la tabla han cambiado
        fireTableDataChanged();
    }

    // Método para establecer nombres de columna personalizados
    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }
}
