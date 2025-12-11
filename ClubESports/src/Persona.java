public class Persona {

    private String nombre;
    private String dni;
    private int edad;

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\n');
        sb.append(", dni='").append(dni).append('\n');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
}
