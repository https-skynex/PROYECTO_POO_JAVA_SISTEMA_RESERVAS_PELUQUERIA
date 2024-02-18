import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;


public class AgendarCita {
    private JPanel panel1;
    private JComboBox<Servicio> servicios;
    private JComboBox<Empleado> selectPeluquero;
    private JButton buscarButton;
    private JButton guardarCitaButton;
    private JComboBox horaBox;
    private JComboBox diaBox;
    private JComboBox mesBox;
    private RegistroCitas registroCitas; // Asume que tienes una instancia de RegistroCitas
    private Usuario usuario;
    private Cita cita;
    private Servicio servicio;
    private ArrayList<Empleado> peluqueros;
    private ArrayList<Servicio> serviciosDisponibles ;
    private ArrayList peluquerosDisponibles;


    public AgendarCita(RegistroCitas registroCitas) {
        this.registroCitas = registroCitas;
        //RegistroCitas.mostrarCitas();

        peluqueros = RegistroEmpleados.exportarPeluqueros();
        peluquerosDisponibles = new ArrayList<>();
        serviciosDisponibles = new ArrayList<>();

        inicializarServicios(serviciosDisponibles);
        agregarServicios();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hora = (String) horaBox.getSelectedItem();
                String dia = (String) diaBox.getSelectedItem();
                String mes = (String) mesBox.getSelectedItem();

                    peluquerosDisponibles = RegistroCitas.peluquerosDisponibles(hora, dia, mes);

                    if (peluquerosDisponibles.size() == 0) {
                        JOptionPane.showMessageDialog(panel1, "No hay peluqueros disponibles", "Aviso", JOptionPane.WARNING_MESSAGE);

                        // Limpiar los JComboBox cuando no hay peluqueros disponibles
                        horaBox.setSelectedItem(null);
                        diaBox.setSelectedItem(null);
                        mesBox.setSelectedItem(null);
                        selectPeluquero.removeAllItems();
                    } else {
                        // Actualizar la JComboBox selectPeluquero con los peluqueros disponibles
                        selectPeluquero.removeAllItems();
                        for (Object peluquero : peluquerosDisponibles) {
                            selectPeluquero.addItem((Empleado) peluquero);
                        }
                    }

            }
        });

        guardarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores seleccionados y/o ingresados
                String hora = (String) horaBox.getSelectedItem();
                String dia = (String) diaBox.getSelectedItem();
                String mes = (String) mesBox.getSelectedItem();
                Empleado empleadoSelect = (Empleado) selectPeluquero.getSelectedItem();
                Servicio servicioT = (Servicio) servicios.getSelectedItem();

                // Validar que todos los campos estén llenos
                if (hora == null || dia == null || mes == null || empleadoSelect == null || servicioT == null || usuario ==null) {
                    JOptionPane.showMessageDialog(panel1, "Llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if(RegistroCitas.choqueCitas(hora, dia, mes, usuario)) {
                        JOptionPane.showMessageDialog(panel1, "Ya tiene una cita registrada en ese horario", "Aviso", JOptionPane.WARNING_MESSAGE);
                        horaBox.setSelectedItem(null);
                        diaBox.setSelectedItem(null);
                        mesBox.setSelectedItem(null);
                        selectPeluquero.removeAllItems();
                    }else {
                        // Todos los campos están llenos, agregar la cita
                        Cita nuevaCita = new Cita(usuario, empleadoSelect, servicioT, Integer.parseInt(hora), Integer.parseInt(dia), Integer.parseInt(mes));
                        RegistroCitas.agregarCita(nuevaCita);
                        RegistroCitas.guardarCitas();
                        String mensaje = String.format("Cita guardada correctamente:\n%s", nuevaCita.toString());
                        JOptionPane.showMessageDialog(panel1, mensaje, "Cita Guardada", JOptionPane.INFORMATION_MESSAGE);


                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                }
            }
        });

        // Otro código de inicialización si es necesario
    }




    private void limpiarInterfaz() {
        // Lógica para limpiar la interfaz después de guardar la cita
    }
    public void mostrarVentana(Usuario usuario) {
        this.usuario = usuario;
        servicios = new JComboBox<>(serviciosDisponibles.toArray(new Servicio[0]));
        JFrame frame = new JFrame("Agendar Cita");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana actual
        frame.setSize(720, 720); // Establece el tamaño deseado
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void agregarServicios(){
        for(Servicio servicio: serviciosDisponibles){
            servicios.addItem(servicio);
        }
    }
    static void inicializarServicios(ArrayList<Servicio> serviciosDisponibles) {

        serviciosDisponibles.add(new Servicio("Corte de pelo", 20.0));
        serviciosDisponibles.add(new Servicio("Tinte de cabello", 40.0));
        serviciosDisponibles.add(new Servicio("Tratamiento", 30.0));
        serviciosDisponibles.add(new Servicio("Rizado", 25.0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Agendar Cita");
                RegistroCitas registroCitas = new RegistroCitas();
                frame.setContentPane(new AgendarCita(registroCitas).panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

