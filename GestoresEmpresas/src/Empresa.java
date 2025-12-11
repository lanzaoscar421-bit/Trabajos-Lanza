import java.time.LocalDate;
import java.util.zip.CheckedOutputStream;

public class Empresa {

    private String nombre;
    private String cif;
    private LocalDate fundacion;
    private int maximoTrabajadores;
    private Trabajador [] trabajadoresRegistrados;
    private int contadorTrabajadores  = 0;
    private Persona [] personasRegistradas;
    private int contadorPersonas = 0;


    public Empresa(String nombre,String cif){
        this.nombre = nombre;
        this.cif = cif;
        this.fundacion = LocalDate.now();
        this.maximoTrabajadores = 0;
        this.trabajadoresRegistrados = new Trabajador[10];
        this.personasRegistradas = new Persona[10];
    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public int getMaximoTrabajadores() {
        return maximoTrabajadores;
    }

    public Trabajador[] getTrabajadoresRegistrados() {
        return trabajadoresRegistrados;
    }

    public Persona[] getPersonasRegistradas() {
        return personasRegistradas;
    }

    public int getContadorTrabajadores() {
        return contadorTrabajadores;
    }

    public int getContadorPersonas() {
        return contadorPersonas;
    }

    // Metodos
    public String infoEmpresa() {
        return  "===== INFORMACIÓN DE LA EMPRESA =====\n" +
                "CIF:                 " + this.cif + "\n" +
                "Nombre:              " + this.nombre + "\n" +
                "Fundacion:     " + this.fundacion + "\n" +
                "==================================";
    }


    public boolean registrarTrabajador(Trabajador t){
        boolean resultado = false;
        if(t != null){
            int index = -1;
            for (int i = 0; i < this.contadorTrabajadores; i++){
                if (this.trabajadoresRegistrados[i].getDni().equalsIgnoreCase(t.getDni())){
                    index = i;
                    break;
                }

            }
            if(index == -1){
                this.trabajadoresRegistrados[this.contadorTrabajadores] = t;
                this.contadorTrabajadores++;
                resultado = true;
            }
        }
        return resultado;

    }
    public boolean eliminarTrabajador(String dni){
        boolean resultado = false;
        int index = -1;

        for (int i = 0; i < this.contadorTrabajadores; i++){
            if (this.trabajadoresRegistrados[i] != null){
                if (this.trabajadoresRegistrados[i].getDni().equalsIgnoreCase(dni)){
                    index = i;
                    break;
                }
            }
        }

        if (index != -1){
            this.trabajadoresRegistrados[index] = this.trabajadoresRegistrados[contadorTrabajadores - 1];
            this.trabajadoresRegistrados[contadorTrabajadores - 1] = null;
            contadorTrabajadores--;
            resultado = true;
        }

        return resultado;
    }

    public String informacionTrabajadores(){
        String info = "No hay Clientes Registrados";
        if (this.contadorTrabajadores > 0){
            info = "";
            for (int i = 0; i < contadorTrabajadores; i++){
                info += this.trabajadoresRegistrados[i].toString() +"\n";
            }
        }
        return info;
    }
    public String numeroTrabajadores(){
        String info = "";
        if (this.contadorTrabajadores > 0){
            info = "";
            System.out.println(contadorTrabajadores);
        }
        return info;
    }


    public boolean registrarPersona(Persona p){
        boolean resultado = false;
        if(p != null){
            int index = -1;
            for (int i = 0; i < this.contadorPersonas; i++){
                if (this.personasRegistradas[i].getDni().equalsIgnoreCase(p.getDni())){
                    index = i;
                    break;
                }

            }
            if(index == -1){
                this.personasRegistradas[this.contadorPersonas] = p;
                this.contadorPersonas++;
                resultado = true;
            }
        }
        return resultado;

    }

    public boolean eliminarPersona(String dni){
        boolean resultado = false;
        int index = -1;

        for (int i = 0; i < this.contadorPersonas; i++){
            if (this.personasRegistradas[i] != null){
                if (this.personasRegistradas[i].getDni().equalsIgnoreCase(dni)){
                    index = i;
                    break;
                }
            }
        }

        if (index != -1){
            this.personasRegistradas[index] = this.personasRegistradas[contadorPersonas - 1];
            this.personasRegistradas[contadorPersonas - 1] = null;
            contadorPersonas--;
            resultado = true;
        }

        return resultado;
    }




}
