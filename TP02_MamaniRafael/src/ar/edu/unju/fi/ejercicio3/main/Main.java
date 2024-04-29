package ar.edu.unju.fi.ejercicio3.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Provincia[] provincias = Provincia.values();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
        do {
            try {
                System.out.println("Menú de opciones:");
                System.out.println("1 – Mostrar provincias");
                System.out.println("2 – Modificar superficie y catidad de poblacion de una provincia");
                System.out.println("3 – Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        mostrarProvincias();
                        break;
                    case 2:
                        modificarProvincia();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Opción no válida. " + e.getMessage());
            }
        } while (opcion != 3);
	}
	private static void modificarProvincia() {
		System.out.println("---- Provincias ------");
        for (Provincia provincia : provincias) {
            System.out.println((provincia.ordinal() + 1) + " - " + provincia);
        }
        System.out.print("Elija la provincia: ");
        int opcionP = scanner.nextInt()-1;
        System.out.print("Elija el nueva superficie: ");
        provincias[opcionP].setSuperficie(scanner.nextDouble());
        System.out.print("Elija el nueva cantidad de poblacion: ");
        provincias[opcionP].setCantidadPoblacion(scanner.nextInt());
	}
	private static void mostrarProvincias() {
	     System.out.println("Información de las provincias:");
	     for (Provincia provincia : provincias) {
	         System.out.println("Provincia: " + provincia);
	         System.out.println("Población: " + provincia.getCantidadPoblacion());
	         System.out.println("Superficie: " + provincia.getSuperficie());
	         System.out.println("Densidad poblacional: " + provincia.calcularDensidadPoblacional());
	         System.out.println();
	     }
	}

}

