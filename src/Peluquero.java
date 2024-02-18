public class Peluquero extends Empleado{
    public Peluquero(String nombre, String apellido, String contraseña) {
        super(nombre, apellido, contraseña);
    }
    @Override
    public String getEspecialidad(){
        return "Peluquero";
    }

    @Override
    public String toString (){
        return super.getCodigo()+" "+super.getNombre() + " " +super.getApellido();
    }

    public int getContador(){ return Empleado.getNumerador();}


}




