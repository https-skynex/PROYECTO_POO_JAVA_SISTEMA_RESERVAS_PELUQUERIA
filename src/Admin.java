import javax.swing.*;

public class Admin {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton iniciarSesiónButton;

    public Admin(JFrame frame) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("LoginAdmin");
                Admin admin = new Admin(frame);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(admin.panel1);
                frame.setSize(400, 560);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}


