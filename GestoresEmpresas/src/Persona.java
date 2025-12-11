import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private String direccion;

    public Persona(String nombre, String dni, LocalDate fechaNacimiento, String direccion){
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }
    @Override
    public String toString() {
        return "=== Persona ===\n" +
                "DNI: " + dni + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "Dirección: " + direccion + "\n" +
                "Nombre: " + nombre + "\n";
    }
}

