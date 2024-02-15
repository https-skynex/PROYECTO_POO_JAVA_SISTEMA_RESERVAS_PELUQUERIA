import java.io.*;
import java.util.*;
public class RegistroUsuarios {
    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public void agregarUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
    }


    public boolean verificarUsuario(String codigoUsuario, String contraseña){
        for(Usuario usuario: listaUsuarios) {
            if (usuario.getCodigo().equals(codigoUsuario) && usuario.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
        }

    public Usuario obtenerUsuario(String codigoUsuario, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCodigo().equals(codigoUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }


    public void guardarUsuarios() {
        try {
            FileOutputStream fos = new FileOutputStream("usuarios.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaUsuarios);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void cargarUsuarios() {
        try {
            FileInputStream fis = new FileInputStream("usuarios.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaUsuarios = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    public void guardarContador(int numerador) {
        try {
            FileOutputStream fos = new FileOutputStream("contador.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(numerador);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void cargarContador() {
        try {
            FileInputStream fis = new FileInputStream("contador.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Usuario.setNumerador((int) ois.readObject());
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }
}



