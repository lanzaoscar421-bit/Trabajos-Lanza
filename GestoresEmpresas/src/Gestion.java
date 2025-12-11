import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Gestion {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Empresa nuevaEmpresa;

        String opcion = "";
        String cif;
        String nombre;
        String nombreTrabajador;
        String dni;
        LocalDate fechaNacimiento;
        String direccion;
        Trabajador nuevoTrabajador;
        Persona nuevaPersona;
        String numeroSS;
        String dniBorar;


        nuevaEmpresa = empresa(sc);

        do {
            sc = new Scanner(System.in);

            imprimirMenuOpciones();

            opcion = sc.nextLine();


            switch (opcion) {
                case "1":
                    crearPersona(nuevaEmpresa);
                    break;
                case "2":
                    resgistrarTrabajador(nuevaEmpresa);
                    break;
                case "3":
                    System.out.println(nuevaEmpresa.infoEmpresa());
                    break;
                case "4":
                    numeroTrabajadores(nuevaEmpresa);
                    break;
                case "5":
                    infoEmpresa(nuevaEmpresa);

                    break;
                case "6":
                    borrarTrabajadores(sc, nuevaEmpresa);
                    break;
                case "7":
                    personaBorrar(sc, nuevaEmpresa);
                    break;
                case "8":
                    System.out.println("Adios.");
                    break;
            }
        } while (!opcion.equals("8"));

    }

    ////////////Metodos//////////////////
    private static void borrarTrabajadores(Scanner sc, Empresa nuevaEmpresa) {
        System.out.println("Para borrar trabajador de la empresa inserte el dni del trabajador");
        String dniBorrar = sc.nextLine();
        boolean resultado5 = nuevaEmpresa.eliminarTrabajador(dniBorrar);
        if (resultado5) {
            System.out.println("Se borró de forma correcta");
        } else {
            System.out.println("Hubo un problema, no se borró correctamente");
        }
    }

    private static void personaBorrar(Scanner sc, Empresa nuevaEmpresa) {
        String dnipBorrar;
        System.out.println("Para borrar a una persona Inserte su dni");
        dnipBorrar = sc.nextLine();
        boolean resultado10 = nuevaEmpresa.eliminarPersona(dnipBorrar);
        if (resultado10) {
            System.out.println("Se borro de forma correct");
        } else {
            System.out.println("Hubo un problema a la hora de borrar");
        }
    }

    private static void infoEmpresa(Empresa nuevaEmpresa) {
        System.out.println(nuevaEmpresa.informacionTrabajadores());
    }

    private static void numeroTrabajadores(Empresa nuevaEmpresa) {
        System.out.println("En la empresa hay:");
        nuevaEmpresa.numeroTrabajadores();
        System.out.println("Trabajadores");
    }

    private static void crearPersona(Empresa nuevaEmpresa) {
        Persona nuevaPersona;
        Scanner sc;
        sc = new Scanner(System.in);
        String nombreP;
        String dniP;
        LocalDate fechaNacimientoP;
        String direccionP;
        System.out.println("Inserte el nombre de la persona");
        nombreP = sc.nextLine();
        do {
            System.out.println("Inserte el DNI de la persona");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dniP = sc.nextLine().toUpperCase().toUpperCase();
        } while (!PatronDNI(dniP));
        System.out.println("Inserte la fecha de Nacimiento de la persona");
        System.out.println("Ejemplo de formato: 2007-12-06");
        fechaNacimientoP = LocalDate.parse(sc.nextLine());
        System.out.println("Inserte su Direccion");
        direccionP = sc.nextLine();
        nuevaPersona = new Persona(nombreP, dniP, fechaNacimientoP, direccionP);
        System.out.println(nuevaPersona.toString());
        boolean resultado2 = nuevaEmpresa.registrarPersona(nuevaPersona);
        if (resultado2) {

        } else {
            System.out.println("No se pudo registrar bien a la persona ");
        }
    }

    private static Empresa empresa(Scanner sc) {
        Empresa nuevaEmpresa;
        String cif;
        String nombre;
        System.out.println("Primero inserte el nombre de la empresa");
        nombre = sc.nextLine();
        do {
            System.out.println("Despues inserte el CIF de la empresa:");
            System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)\" \n");
            cif = sc.nextLine().toUpperCase();
        } while (!PatronCIF(cif));

        nuevaEmpresa = new Empresa(nombre, cif);
        return nuevaEmpresa;
    }
    //Metodos

    private static void resgistrarTrabajador(Empresa nuevaEmpresa) {
        String nombreTrabajador;
        String direccion;
        LocalDate fechaNacimiento;
        String dni;
        Trabajador nuevoTrabajador;
        Scanner sc;
        String numeroSS;
        sc = new Scanner(System.in);
        System.out.println("Inserte su nombre");
        nombreTrabajador = sc.nextLine();
        do {
            System.out.println("Inserte SU DNI");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dni = sc.nextLine().toUpperCase().toUpperCase();
        } while (!PatronDNI(dni));
        System.out.println("Inserte su fecha nacimiento");
        System.out.println("Ejemplo de formato: 2007-12-06");
        fechaNacimiento = LocalDate.parse(sc.nextLine());
        System.out.println("Inserte su direccion");
        direccion = sc.nextLine();

        do {
            System.out.println("Inserte su numero de la SS");
            System.out.println("Dicho numero consta de 12 digitos");
            System.out.println("Ejemplo: 281234567890\n");
            numeroSS = sc.nextLine().toUpperCase();
        } while (!PatronNumeroSS(numeroSS));
        nuevoTrabajador = new Trabajador(nombreTrabajador, dni, fechaNacimiento, direccion, numeroSS);
        System.out.println(nuevoTrabajador.toString());
        boolean resultado = nuevaEmpresa.registrarTrabajador(nuevoTrabajador);
        if (resultado) {
            System.out.println("Trabajador añadido Exsitosamente");
        } else {
            System.out.println("No se pudo añadir al Trabajador, revisa que no coincidan los Dni's");
        }
    }

    private static void imprimirMenuOpciones() {
        System.out.println("Escoga la opcion que desee");
        System.out.println("1. Crear Persona");
        System.out.println("2. Registrar trabajador en la empresa");
        System.out.println("3. Mostrar información general de la empresa");
        System.out.println("4. Mostrar el número de trabajadores actuales");
        System.out.println("5. Mostrar información de todos los trabajadores");
        System.out.println("6. Eliminar trabajador de la empresa");
        System.out.println("7. Eliminar persona del programa.");
        System.out.println("8. Salir");
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