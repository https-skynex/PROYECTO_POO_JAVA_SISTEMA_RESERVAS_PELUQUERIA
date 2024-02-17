import javax.swing.*;

public class EstadisticasNegocio {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton button1;
    private JTable stats;

    public EstadisticasNegocio(JFrame frame) {
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
