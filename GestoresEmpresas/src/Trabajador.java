import java.time.LocalDate;

public class Trabajador extends Persona {

    private String numeroSS;

    Trabajador(String nombre, String dni, LocalDate fechaNacimiento,String direccion,String numeroSS){
        super(nombre, dni, fechaNacimiento, direccion);
        this.numeroSS = numeroSS;

    }

    public String getNumeroSS() {
        return numeroSS;
    }

    //Metodos

    @Override
    public String toString() {
        return "=== Trabjadores ===\n" +
                super.toString() + "\n" +
                "Número SS: " + numeroSS;
    }


}
