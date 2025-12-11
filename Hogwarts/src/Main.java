import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String academiaNombre;
        String cif;
        String opcion = "";
        Academia nuevaAcademia;
        Magos nuevoMago;


        nuevaAcademia = academia(sc);

        do {


            System.out.println("Escoga la opcion que desee");
            System.out.println("1. Crear Mago");
            System.out.println("2. Mostrar todos los Magos");
            System.out.println("3. Buscar Jugador por DNI");
            System.out.println("4  Eliminar Mago");
            System.out.println("5  Informacion de la academia");
            System.out.println("8. Salir.");


            opcion = sc.nextLine();
            switch (opcion){

                case "1":
                    magoCrear(sc, nuevaAcademia);
                    break;
                case "2":
                    System.out.println(nuevaAcademia.mostrarMagos());

                    break;
                case "3":
                    String dniBuscar;
                    System.out.println("Inserte el dni para buscar la info del mago");
                    dniBuscar = sc.nextLine();
                    Magos encontrado = nuevaAcademia.buscarMagos(dniBuscar);
                    if (encontrado != null) {
                        System.out.println(encontrado.infoMago()); // Muestra la información completa del mago
                    } else {
                        System.out.println("No se ha encontrado ningún mago con ese DNI.");
                    }
                    break;

                case "4":
                    String dniBorrar;
                    System.out.println("Inserte el dni del mago que quiere borrar");
                    dniBorrar = sc.nextLine();
                    boolean resultado10 = nuevaAcademia.eliminarMago(dniBorrar);
                    if (resultado10){
                        System.out.println("Se borro con exsito");
                    }else {
                        System.out.println("Hubo un problema ");
                    }

                    break;
                case "5":
                    System.out.println(nuevaAcademia.informacionAcademia());
                    break;

                default:
                    System.out.println("Porfavor inserte un numero de los marcados anteriormente");
            }



        }while (!opcion.equals("8"));


    }

    private static void magoCrear(Scanner sc, Academia nuevaAcademia) {
        Magos nuevoMago;
        String nombre;
        String dni;
        Tipo naturaleza;
        System.out.println("Inserte el nombre del Mago");
        nombre = sc.nextLine();
        do {
            System.out.println("Inserte el DNI del Mago");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dni = sc.nextLine().toUpperCase();
        } while (!PatronDNI(dni));

        System.out.println("Ahora inserte el tipo de mago");
        for (Tipo g : Tipo.values()) {
            System.out.println("- " + g);
        }

        Tipo tipo = null;

        while (tipo == null){
            System.out.println("Escribe bien el nombre del genero");
            String entrada = sc.nextLine().toUpperCase();
            //Comprobacion para Si el genero que puso el usuario Exsiste

            for (Tipo g : Tipo.values()){
                if (g.name().equalsIgnoreCase(entrada)){//equalsIgnoreCase para que el usuario ponga mayusculas o minusculas
                    tipo = g;//Romper ciclo whilw
                    break;
                }
            }
            if (tipo == null){
                System.out.println("El genero que pusiste es invalido");
            }
        }
        nuevoMago = new Magos(nombre,dni,tipo);
        boolean resultado = nuevaAcademia.registrarMago(nuevoMago);
        if (resultado){
            System.out.println("Se inserto bien el mago");
        }else {
            System.out.println("hubo un problema");
        }
    }

    private static Academia academia(Scanner sc) {
        String cif;
        String academiaNombre;
        Academia nuevaAcademia;
        System.out.println("Inserte el nombre de la Academia");
        academiaNombre = sc.nextLine();
        do {
            System.out.println("Despues inserte el CIF de la empresa:");
            System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)\" \n");
            cif = sc.nextLine().toUpperCase();
        } while (!PatronCIF(cif));
        nuevaAcademia = new Academia(academiaNombre,cif);
        nuevaAcademia.informacionAcademia();
        return nuevaAcademia;
    }

    static boolean PatronCIF(String CIF) {
        String patron = "^[A-HJUV][0-9]{7}[A-Z0-9]$";
        return Pattern.matches(patron, CIF);
    }
    static boolean PatronDNI(String DNI) {
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron, DNI);
    }

}