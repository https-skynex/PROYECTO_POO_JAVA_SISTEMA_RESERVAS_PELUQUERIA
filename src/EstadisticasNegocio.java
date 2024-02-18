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

    public EstadisticasNegocio(JFrame frame) {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    private ArrayList<String> obtenerPeluqueros() {
        // Devuelve un ArrayList de peluqueros (dummy data)
        return new ArrayList<>(Arrays.asList("Peluquero1", "Peluquero2", "Peluquero3"));
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
                EstadisticasNegocio stats = new EstadisticasNegocio(frame);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(stats.panel1);
                frame.setSize(350, 250);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
