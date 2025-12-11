public class Magos {
    private String nombre;
    private String dni;
    private String numeroMago;
    private static int contadorMago = 0;
    private Tipo tipo;



    public Magos(String nombre, String dni, Tipo tipo) {
        this.nombre = nombre;
        this.dni = dni;
        this.numeroMago = String.format("S-%03d", contadorMago);
        contadorMago++;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNumeroMago() {
        return numeroMago;
    }

    public int getContadorMago() {
        return contadorMago;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String infoMago(){
        String info = "";
        info += "----- INFORMACIÓN DEl Mago -----\n";
        info += "Nombre: " + this.nombre + "\n";
        info += "Numero Mago: " + this.numeroMago + "\n";
        info += "Naturaleza " + this.tipo + "\n";
        info += "Dni " + this.dni + "\n";
        info += "---------------------------------------\n";
        return info;
    }

}
