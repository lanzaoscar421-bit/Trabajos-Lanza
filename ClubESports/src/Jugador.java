public class Jugador extends Persona {
    private Juego juego;
    private String numeroSS;
    private int nivelCompetitivo;

     public Jugador(String nombre,int edad,String dni,Juego juego,String numeroSS, int nivelCompetitivo){
        super(nombre,edad,dni);
        this.juego = juego;
        this.numeroSS = numeroSS;
        this.nivelCompetitivo = nivelCompetitivo;
    }

    public Juego getJuego() {
        return juego;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public int getNivelCompetitivo() {
        return nivelCompetitivo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jugador{");
        sb.append("juego=").append(juego);
        sb.append(", numeroSS='").append(numeroSS).append('\'');
        sb.append(", nivelCompetitivo=").append(nivelCompetitivo);
        sb.append('}');
        return sb.toString();
    }
}
