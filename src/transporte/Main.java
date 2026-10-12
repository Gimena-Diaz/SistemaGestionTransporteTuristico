package transporte;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTransporte gestor = new GestorTransporte();

        cargarDatosDePrueba(gestor);

        int opcion;
        do {
            mostrarMenu();
            String opcionTexto = pedirNumeroValido(sc, "Elija una opcion: ");
            if (quiereVolver(opcionTexto)) {
                opcion = 8;
            } else {
                opcion = Integer.parseInt(opcionTexto);
            }

            switch (opcion) {
                case 1:
                    agregarVehiculo(sc, gestor);
                    break;
                case 2:
                    gestor.mostrarTodos();
                    break;
                case 3:
                    gestor.realizarServicios();
                    break;
                case 4:
                    buscarVehiculo(sc, gestor);
                    break;
                case 5:
                    String limiteTexto = pedirNumeroValido(sc, "Mostrar vehiculos con capacidad mayor a: ");
                    if (quiereVolver(limiteTexto)) {
                        System.out.println("Regresando al menu....");
                    } else {
                        gestor.filtrarPorCapacidad(Integer.parseInt(limiteTexto));
                    }
                    break;
                case 6:
                    gestor.mostrarPorAnioDescendente();
                    break;
                case 7:
                    gestor.mostrarPorCapacidadDescendente();
                    break;
                case 8:
                    System.out.println("Gracias por usar nuestro sistema. Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida. Elija un numero del 1 al 8.");
            }
        } while (opcion != 8);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("===== SISTEMA DE GESTION DE TRANSPORTE TURISTICO =====");
        System.out.println("1. Agregar vehiculo");
        System.out.println("2. Mostrar todos los vehiculos");
        System.out.println("3. Realizar servicios turisticos");
        System.out.println("4. Buscar vehiculo por patente");
        System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor");
        System.out.println("6. Mostrar vehiculos ordenados por anio (descendente)");
        System.out.println("7. Mostrar vehiculos ordenados por capacidad (descendente)");
        System.out.println("8. Salir del sistema");
    }

    public static String ingresarDato(Scanner sc, String mensaje) {
        System.out.print("( |X| volver atras) " + mensaje);
        return sc.nextLine();
    }

    public static boolean quiereVolver(String texto) {
        return texto.toUpperCase().equals("X");
    }

    public static String pedirNumeroValido(Scanner sc, String mensaje) {
        String entrada = ingresarDato(sc, mensaje);
        boolean valido = false;
        while (!valido) {
            if (quiereVolver(entrada)) {
                valido = true;
            } else {
                try {
                    Integer.parseInt(entrada);
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un numero entero. Intente nuevamente.");
                    entrada = ingresarDato(sc, mensaje);
                }
            }
        }
        return entrada;
    }

    public static String pedirNumeroPositivo(Scanner sc, String mensaje) {
        String entrada = pedirNumeroValido(sc, mensaje);
        while (!quiereVolver(entrada) && Integer.parseInt(entrada) <= 0) {
            System.out.println("Error: el valor debe ser mayor a cero.");
            entrada = pedirNumeroValido(sc, mensaje);
        }
        return entrada;
    }

    public static String pedirNumeroEntre(Scanner sc, String mensaje, int minimo, int maximo) {
        String entrada = pedirNumeroValido(sc, mensaje);
        while (!quiereVolver(entrada)
                && (Integer.parseInt(entrada) < minimo || Integer.parseInt(entrada) > maximo)) {
            System.out.println("Error: el valor debe estar entre " + minimo + " y " + maximo + ".");
            entrada = pedirNumeroValido(sc, mensaje);
        }
        return entrada;
    }

    public static String condicionSoN(Scanner sc, String mensaje) {
        String respuesta = ingresarDato(sc, mensaje).toUpperCase();
        while (!respuesta.equals("S") && !respuesta.equals("N") && !quiereVolver(respuesta)) {
            System.out.println("Error: debe responder S o N.");
            respuesta = ingresarDato(sc, mensaje).toUpperCase();
        }
        return respuesta;
    }

    public static String ingresarChapaPatenteValida(Scanner sc, GestorTransporte gestor) {
        String patente = "";
        boolean valida = false;
        while (!valida) {
            patente = ingresarDato(sc, "Patente: ").toUpperCase();
            if (quiereVolver(patente)) {
                valida = true;
            } else if (patente.isBlank()) {
                System.out.println("Error: la patente no puede estar vacia.");
            } else if (patente.length() < 6 || patente.length() > 7) {
                System.out.println("Error: la patente debe tener 6 o 7 caracteres.");
            } else if (!soloLetrasYNumeros(patente)) {
                System.out.println("Error: la patente solo puede tener letras y numeros.");
            } else if (gestor.existePatente(patente)) {
                System.out.println("Error: ya existe un vehiculo con la patente " + patente + ".");
            } else {
                valida = true;
            }
        }
        return patente;
    }

    public static boolean soloLetrasYNumeros(String texto) {
        boolean valido = true;
        for (int i = 0; i < texto.length(); i++) {
            int codigo = texto.charAt(i);
            boolean esLetra = codigo >= 65 && codigo <= 90;
            boolean esNumero = codigo >= 48 && codigo <= 57;
            if (!esLetra && !esNumero) {
                valido = false;
            }
        }
        return valido;
    }

    public static String leerMotor(Scanner sc) {
        String mensaje = "Tipo de motor (NAFTA / DIESEL / ELECTRICO): ";
        String motor = ingresarDato(sc, mensaje).toUpperCase();
        while (!motor.equals("NAFTA") && !motor.equals("DIESEL") && !motor.equals("ELECTRICO")
                && !quiereVolver(motor)) {
            System.out.println("Error: el tipo de motor debe ser NAFTA, DIESEL o ELECTRICO.");
            motor = ingresarDato(sc, mensaje).toUpperCase();
        }
        return motor;
    }

    public static void agregarVehiculo(Scanner sc, GestorTransporte gestor) {
        System.out.println("Tipo de vehiculo: 1. Colectivo turistico  2. Van ejecutiva  3. Lancha turistica");

        int tipo = 0;
        String patente = "";
        String marca = "";
        int capacidad = 0;
        int anio = 0;
        int pisos = 0;
        boolean aire = false;
        String motor = "";

        String tipoTexto = pedirNumeroEntre(sc, "Elija el tipo: ", 1, 3);
        boolean cancelado = quiereVolver(tipoTexto);

        if (!cancelado) {
            tipo = Integer.parseInt(tipoTexto);
            patente = ingresarChapaPatenteValida(sc, gestor);
            cancelado = quiereVolver(patente);
        }
        if (!cancelado) {
            marca = ingresarDato(sc, "Marca: ");
            cancelado = quiereVolver(marca);
        }
        if (!cancelado) {
            String capacidadTexto = pedirNumeroPositivo(sc, "Capacidad de pasajeros: ");
            cancelado = quiereVolver(capacidadTexto);
            if (!cancelado) {
                capacidad = Integer.parseInt(capacidadTexto);
            }
        }
        if (!cancelado) {
            int anioActual = LocalDate.now().getYear();
            String anioTexto = pedirNumeroEntre(sc, "Anio de fabricacion: ", 1990, anioActual);
            cancelado = quiereVolver(anioTexto);
            if (!cancelado) {
                anio = Integer.parseInt(anioTexto);
            }
        }
        if (!cancelado) {
            if (tipo == 1) {
                String pisosTexto = pedirNumeroEntre(sc, "Cantidad de pisos (1 o 2): ", 1, 2);
                cancelado = quiereVolver(pisosTexto);
                if (!cancelado) {
                    pisos = Integer.parseInt(pisosTexto);
                }
            } else if (tipo == 2) {
                String respuesta = condicionSoN(sc, "Tiene aire acondicionado? (S/N): ");
                cancelado = quiereVolver(respuesta);
                aire = respuesta.equals("S");
            } else {
                motor = leerMotor(sc);
                cancelado = quiereVolver(motor);
            }
        }
        if (!cancelado) {
            System.out.println("Datos ingresados: | Patente: " + patente + " | Marca: " + marca
                    + " | Capacidad: " + capacidad + " | Anio: " + anio);
            String confirma = condicionSoN(sc, "Confirma el alta? (S/N): ");
            cancelado = !confirma.equals("S");
        }

        if (cancelado) {
            System.out.println("Regresando al menu....");
        } else {
            try {
                Vehiculo nuevo;
                if (tipo == 1) {
                    nuevo = new ColectivoTuristico(patente, marca, capacidad, anio, pisos);
                } else if (tipo == 2) {
                    nuevo = new VanEjecutiva(patente, marca, capacidad, anio, aire);
                } else {
                    nuevo = new LanchaTuristica(patente, marca, capacidad, anio, motor);
                }
                gestor.agregarVehiculo(nuevo);
                System.out.println("Vehiculo agregado correctamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (PatenteDuplicadaException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void buscarVehiculo(Scanner sc, GestorTransporte gestor) {
        String buscarDeNuevo = "S";
        while (buscarDeNuevo.equals("S")) {
            String patente = ingresarDato(sc, "Ingrese la patente a buscar: ").toUpperCase();
            if (quiereVolver(patente)) {
                buscarDeNuevo = "N";
                System.out.println("Regresando al menu....");
            } else {
                gestor.buscarPorPatente(patente);
                buscarDeNuevo = condicionSoN(sc, "Desea buscar otra patente? (S/N): ");
            }
        }
    }

    public static void cargarDatosDePrueba(GestorTransporte gestor) {
        try {
            gestor.agregarVehiculo(new ColectivoTuristico("AB456CD", "Scania", 50, 2022, 1));
            gestor.agregarVehiculo(new VanEjecutiva("AD321GH", "Toyota", 12, 2019, false));
            gestor.agregarVehiculo(new LanchaTuristica("LAN002", "Mercury", 10, 2022, "ELECTRICO"));
        } catch (PatenteDuplicadaException e) {
            System.out.println("Error al cargar datos de prueba: " + e.getMessage());
        }
    }
}