import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Academia {


    private String nombre;
    private String cif;
    private String fechaAlta;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int contadorMagos;
    private Magos [] magosRegistrados;

    public Academia(String nombre, String cif){

        this.nombre= nombre;
        this.cif = cif;
        this.fechaAlta = LocalDateTime.now().format(dtf);
        this.magosRegistrados = new  Magos[10];


    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public int getContadorMagos() {
        return contadorMagos;
    }

    public Magos[] getMagosRegistrados() {
        return magosRegistrados;
    }
    //Metodos
    public String informacionAcademia() {
        String info = "";
        info += "===== INFORMACIÓN DE LA ACADEMIA =====\n";
        info += "Nombre: " + this.nombre + "\n";
        info += "CIF: " + this.cif + "\n";
        info += "Fecha de alta: " + this.fechaAlta + "\n";
        info += "Número de magos registrados: " + this.contadorMagos + "\n";
        info += "--------------------------------------\n";
        return info;
    }

    public boolean registrarMago(Magos m){
        boolean resultado = false;
        if(m != null){
            int index = -1;
            for (int i = 0; i < this.contadorMagos; i++){
                if (this.magosRegistrados[i].getDni().equalsIgnoreCase(m.getDni())){
                    index = i;
                    break;
                }

            }
            if(index == -1){
                this.magosRegistrados[this.contadorMagos] = m;
                this.contadorMagos++;
                resultado = true;
            }
        }
        return resultado;

    }
    public boolean eliminarMago(String dni){
        boolean resultado = false;
        int index = -1;

        for (int i = 0; i < this.contadorMagos; i++){
            if (this.magosRegistrados[i] != null){
                if (this.magosRegistrados[i].getDni().equalsIgnoreCase(dni)){
                    index = i;
                    break;
                }
            }
        }

        if (index != -1){
            this.magosRegistrados[index] = this.magosRegistrados[contadorMagos - 1];
            this.magosRegistrados[contadorMagos - 1] = null;
            contadorMagos--;
            resultado = true;
        }

        return resultado;
    }
    public Magos buscarMagos (String dni){
        for (int i = 0; i < contadorMagos; i++){
            if (magosRegistrados[i].getDni().equalsIgnoreCase(dni)) {
                return magosRegistrados[i];
            }
        }
        return null;

    }
    public String mostrarMagos(){
        String infoClientes = "No hay Clientes registrados";
        if (this.contadorMagos > 0){
            infoClientes = "";
            for (int i = 0; i < this.contadorMagos; i++){
                infoClientes += this.magosRegistrados[i].infoMago();//
            }
        }
        return infoClientes;
    }

}
