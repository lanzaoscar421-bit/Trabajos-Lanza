public class Equipo {
    private String nombre;
    private String cif;
    private int contandorJugadores = 0;
    private Jugador [] jugadoresRegistrados;

    public Equipo (String nombre,String cif){
        this.nombre = nombre;
        this.cif = cif;
        this.jugadoresRegistrados = new Jugador[10];

    }

    public String getNombre() {
        return nombre;
    }

    public Jugador[] getJugadoresRegistrados() {
        return jugadoresRegistrados;
    }

    public int getContandorMiembros() {
        return contandorJugadores;
    }
    //Metodos

    public boolean registrarJugador(Jugador J){
        boolean resultado = false;
        if(J != null){
            int index = -1;
            for (int i = 0; i < this.contandorJugadores; i++){
                if (this.jugadoresRegistrados[i].getDni().equalsIgnoreCase(J.getDni())){
                    index = i;
                    break;
                }

            }
            if(index == -1){
                this.jugadoresRegistrados[this.contandorJugadores] = J;
                this.contandorJugadores++;
                resultado = true;
            }
        }
        return resultado;

    }
    public boolean eliminarJugador(String dni){
        boolean resultado = false;
        int index = -1;

        for (int i = 0; i < this.contandorJugadores; i++){
            if (this.jugadoresRegistrados[i] != null){
                if (this.jugadoresRegistrados[i].getDni().equalsIgnoreCase(dni)){
                    index = i;
                    break;
                }
            }
        }

        if (index != -1){
            this.jugadoresRegistrados[index] = this.jugadoresRegistrados[contandorJugadores - 1];
            this.jugadoresRegistrados[contandorJugadores - 1] = null;
            contandorJugadores--;
            resultado = true;
        }

        return resultado;
    }
    public Persona buscaPersona (String dni){
        for (int i = 0; i < contandorJugadores; i++){
            if (jugadoresRegistrados[i].getDni().equalsIgnoreCase(dni)) {
                return jugadoresRegistrados[i];
            }
        }
        return null;

    }



}
