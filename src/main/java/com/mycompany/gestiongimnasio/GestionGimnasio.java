package com.mycompany.gestiongimnasio;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionGimnasio {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Entrenador> entrenadores = new ArrayList<>();
    static ArrayList<ClaseEntrenamiento> clases = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        cargarClientesDesdeArchivo();
    cargarEntrenadoresDesdeArchivo();
    cargarClasesDesdeArchivo();
    
        int opcion;

        do {
            System.out.println("\n====== MENÚ GESTIÓN DE GIMNASIO ======");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar entrenador");
            System.out.println("4. Mostrar entrenadores");
            System.out.println("5. Registrar clase de entrenamiento");
            System.out.println("6. Mostrar clases");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> mostrarClientes();
                case 3 -> registrarEntrenador();
                case 4 -> mostrarEntrenadores();
                case 5 -> registrarClase();
                case 6 -> mostrarClases();
                case 7 -> {
                    guardarClientesEnArchivo();
                    guardarEntrenadoresEnArchivo();
                    guardarClasesEnArchivo();
                    System.out.println("¡Gracias por usar el sistema!");
                }
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }

    private static void registrarCliente() {
        System.out.print("ID del cliente: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt(); sc.nextLine();
        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble(); sc.nextLine();

        System.out.print("Tipo de membresía (Básica/Premium): ");
        String tipo = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();
        System.out.print("Duración en meses: ");
        int duracion = sc.nextInt(); sc.nextLine();

        Membresia membresia = new Membresia(tipo, precio, duracion);
        Cliente cliente = new Cliente(id, nombre, edad, peso, membresia);
        clientes.add(cliente);

        System.out.println("✅ Cliente registrado correctamente.");
    }

    private static void mostrarClientes() {
        System.out.println("----- LISTA DE CLIENTES -----");
        for (Cliente c : clientes) {
            System.out.println(c.mostrarInformacion());
            System.out.println("-----------------------------");
        }
    }

    private static void registrarEntrenador() {
        System.out.print("ID del entrenador: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        Entrenador e = new Entrenador(id, nombre, especialidad);
        entrenadores.add(e);
        System.out.println("✅ Entrenador registrado correctamente.");
    }

    private static void mostrarEntrenadores() {
        System.out.println("----- LISTA DE ENTRENADORES -----");
        for (Entrenador e : entrenadores) {
            System.out.println(e.mostrarInformacion());
            System.out.println("-----------------------------");
        }
    }

    private static void registrarClase() {
        System.out.print("Nombre de la clase: ");
        String nombreClase = sc.nextLine();
        System.out.print("Duración (min): ");
        int duracion = sc.nextInt(); sc.nextLine();

        System.out.print("ID del entrenador que dictará la clase: ");
        int idEntrenador = sc.nextInt(); sc.nextLine();

        Entrenador entrenadorEncontrado = null;
        for (Entrenador e : entrenadores) {
            if (e.getId() == idEntrenador) {
                entrenadorEncontrado = e;
                break;
            }
        }

        if (entrenadorEncontrado != null) {
            ClaseEntrenamiento clase = new ClaseEntrenamiento(nombreClase, duracion, entrenadorEncontrado);
            clases.add(clase);
            System.out.println("✅ Clase registrada correctamente.");
        } else {
            System.out.println("❌ Entrenador no encontrado.");
        }
    }

    private static void mostrarClases() {
        System.out.println("----- LISTA DE CLASES -----");
        for (ClaseEntrenamiento c : clases) {
            System.out.println(c.mostrarInformacion());
            System.out.println("-----------------------------");
        }
    }

    private static void guardarClientesEnArchivo() {
        try (java.io.PrintWriter writer = new java.io.PrintWriter("clientes.txt")) {
            for (Cliente c : clientes) {
                writer.println(c.toFileString());
            }
            System.out.println("📁 Clientes guardados en clientes.txt");
        } catch (Exception e) {
            System.out.println("❌ Error al guardar clientes: " + e.getMessage());
        }
    }

    private static void guardarEntrenadoresEnArchivo() {
        try (java.io.PrintWriter writer = new java.io.PrintWriter("entrenadores.txt")) {
            for (Entrenador e : entrenadores) {
                writer.println(e.toFileString());
            }
            System.out.println("📁 Entrenadores guardados en entrenadores.txt");
        } catch (Exception e) {
            System.out.println("❌ Error al guardar entrenadores: " + e.getMessage());
        }
    }

    private static void guardarClasesEnArchivo() {
        try (java.io.PrintWriter writer = new java.io.PrintWriter("clases.txt")) {
            for (ClaseEntrenamiento c : clases) {
                writer.println(c.toFileString());
            }
            System.out.println("📁 Clases guardadas en clases.txt");
        } catch (Exception e) {
            System.out.println("❌ Error al guardar clases: " + e.getMessage());
        }
    }
    
   private static void cargarClientesDesdeArchivo() {
    try (java.util.Scanner reader = new java.util.Scanner(new java.io.File("clientes.txt"))) {
        while (reader.hasNextLine()) {
            String[] datos = reader.nextLine().split(",");
            int id = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            int edad = Integer.parseInt(datos[2]);
            double peso = Double.parseDouble(datos[3]);
            String tipo = datos[4];
            double precio = Double.parseDouble(datos[5]);
            int duracion = Integer.parseInt(datos[6]);

            Membresia m = new Membresia(tipo, precio, duracion);
            Cliente c = new Cliente(id, nombre, edad, peso, m);
            clientes.add(c);
        }
        System.out.println("📥 Clientes cargados desde clientes.txt");
    } catch (Exception e) {
        System.out.println("⚠️ No se pudieron cargar clientes (posiblemente no existe el archivo).");
    }
}
   
   private static void cargarEntrenadoresDesdeArchivo() {
    try (java.util.Scanner reader = new java.util.Scanner(new java.io.File("entrenadores.txt"))) {
        while (reader.hasNextLine()) {
            String[] datos = reader.nextLine().split(",");
            int id = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            String especialidad = datos[2];

            Entrenador e = new Entrenador(id, nombre, especialidad);
            entrenadores.add(e);
        }
        System.out.println("📥 Entrenadores cargados desde entrenadores.txt");
    } catch (Exception e) {
        System.out.println("⚠️ No se pudieron cargar entrenadores.");
    }
}

 private static void cargarClasesDesdeArchivo() {
    try (java.util.Scanner reader = new java.util.Scanner(new java.io.File("clases.txt"))) {
        while (reader.hasNextLine()) {
            String[] datos = reader.nextLine().split(",");
            String nombreClase = datos[0];
            int duracion = Integer.parseInt(datos[1]);
            int idEntrenador = Integer.parseInt(datos[2]);
            String nombreEntrenador = datos[3];
            String especialidad = datos[4];

            Entrenador entrenador = new Entrenador(idEntrenador, nombreEntrenador, especialidad);
            ClaseEntrenamiento clase = new ClaseEntrenamiento(nombreClase, duracion, entrenador);
            clases.add(clase);
        }
        System.out.println("📥 Clases cargadas desde clases.txt");
    } catch (Exception e) {
        System.out.println("⚠️ No se pudieron cargar clases.");
    }
}

    
}
