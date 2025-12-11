import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionESports {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcion = "";
        Equipo nuevoEquipo;
        Jugador nuevoJugador;

        nuevoEquipo = crearEquipo(sc);


        do {


            System.out.println("Escoga la opcion que desee");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Mostrar todos los jugadores");
            System.out.println("3. Buscar Jugador por DNI");
            System.out.println("8. Salir");


            opcion = sc.nextLine();
            switch (opcion){

                case "1":
                    crearJugador(sc, nuevoEquipo);
                    break;
                case "2":
                    nuevoJugador.getDni();

                    break;
                case "3":
                    String dniBusqueda;
                    System.out.println("Inserte el DNI del jugador");
                    dniBusqueda = sc.nextLine();

                    break;






                default:
                    System.out.println("Porfavor inserte un numero de los marcados anteriormente");
            }



        }while (!opcion.equals("8"));


    }//Metodos

    private static Equipo crearEquipo(Scanner sc) {
        Equipo nuevoEquipo;
        String nombreEsport;
        String cif;
        System.out.println("Pon el nombre de tu nuevo Equipo");
        nombreEsport = sc.nextLine();
        do {
            System.out.println("Ahora ponga el Cif de tu Equipo ya que es considerado empresa");
            System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)");
            cif = sc.nextLine().toUpperCase();
        } while (!PatronCIF(cif));
        nuevoEquipo = new Equipo(cif,nombreEsport);
        return nuevoEquipo;
    }

    private static void crearJugador(Scanner sc, Equipo nuevoEquipo) {
        Jugador nuevoJugador;
        String nombre;
        int edad;
        String dni;
        String numeroSS;
        int nivelCompetitivo;
        System.out.println("Inserte su nombre");
        nombre = sc.nextLine();
        do {
            System.out.println("Inserte su Edad");
            System.out.println("Tiene que ser mayor de Edad");
            edad = sc.nextInt();
        }while (edad <18);
        do {
            System.out.println("Inserte el DNI del Jugador");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dni = sc.nextLine().toUpperCase();
        } while (!PatronDNI(dni));
        System.out.println("Ahora inserte el Juego que jugara el profesional acontinuacion te pondre los disponibles");
        for (Juego j : Juego.values()) {
            System.out.println("- " + j);
        }

        Juego juego = null;

        while (juego == null){
            System.out.println("Escribe bien el nombre del genero");
            String entrada = sc.nextLine().toUpperCase();
            //Comprobacion para Si el genero que puso el usuario Exsiste

            for (Juego j : juego.values()){
                if (j.name().equalsIgnoreCase(entrada)){//equalsIgnoreCase para que el usuario ponga mayusculas o minusculas
                    juego = j;//Romper ciclo whilw
                    break;
                }
            }
            if (juego == null){
                System.out.println("El genero que pusiste es invalido");
            }
        }
        do {
            System.out.println("Inserte el numero de la S del Jugador");
            System.out.println("Dicho numero consta de 12 digitos");
            System.out.println("Ejemplo: 281234567890\n");
            numeroSS = sc.nextLine().toUpperCase();
        } while (!PatronNumeroSS(numeroSS));
        do {
            System.out.println("Inserte el nivel del Jugador");
            System.out.println("va de una escala del 1-10");
            nivelCompetitivo = sc.nextInt();
        }while (nivelCompetitivo>10 && nivelCompetitivo<0);
        nuevoJugador = new Jugador(nombre,edad,dni,juego,numeroSS,nivelCompetitivo);
        boolean resultado = nuevoEquipo.registrarJugador(nuevoJugador);
        if (resultado){
            System.out.println("Se añadio al equipo correctamente");
        }else{
            System.out.println("No se pudo añadir");
        }
    }


    static boolean PatronCIF(String CIF) {
        String patron = "^[A-HJUV][0-9]{7}[A-Z0-9]$";
        return Pattern.matches(patron, CIF);
    }
    static boolean PatronDNI(String DNI) {
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron, DNI);
    }

    static boolean PatronNumeroSS(String numeroSS) {
        String patron = "[0-9]{12}";
        return Pattern.matches(patron, numeroSS);
    }


}
