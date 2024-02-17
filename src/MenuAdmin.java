import javax.swing.*;

public class MenuAdmin {
    private JPanel panel1;
    private JButton cerrarSesiónButton;
    private JButton visualizarEstadisticasDelNegocioButton;
    private JButton agregarEmpleadosButton;

    public MenuAdmin(JFrame frame) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("LoginAdmin");
                MenuAdmin mAdmin = new MenuAdmin(frame);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(mAdmin.panel1);
                frame.setSize(350, 250);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
