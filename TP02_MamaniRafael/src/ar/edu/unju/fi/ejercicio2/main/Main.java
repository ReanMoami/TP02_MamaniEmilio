package ar.edu.unju.fi.ejercicio2.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
    private static ArrayList<Efemeride> listaEfemerides = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int opcion = 0;
        do {
            try {
                System.out.println("Menú de opciones:");
                System.out.println("1 – Crear efemeride");
                System.out.println("2 – Mostrar efemeride");
                System.out.println("3 – Eliminar efemeride");
                System.out.println("4 – Modificar efemeride");
                System.out.println("5 – Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        crearEfemerides();
                        break;
                    case 2:
                        mostrarEfemerides();
                        break;
                    case 3:
                        eliminarEfemeride();
                        break;
                    case 4:
                        modificarEfemerides();
                        break;
                    case 5:
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
        } while (opcion != 5);
	}

	private static void crearEfemerides() {
		System.out.print("Ingrese la codigo: ");
        String codigo = scanner.nextLine();
        for (Mes meses : Mes.values()) {
            System.out.println((meses.ordinal() + 1) + " - " + meses);
        }
        System.out.print("Elija el nuevo mes: ");
        int opcionM = scanner.nextInt();
        Mes mes = Mes.values()[opcionM - 1];
        
        System.out.print("Ingrese el dia: ");
        Byte dia =scanner.nextByte();
        scanner.nextLine();
        System.out.print("Ingrese la detalles: ");
        String detalle = scanner.nextLine();
        
        Efemeride nuevoEfemeride = new Efemeride(codigo, mes, dia, detalle);
        listaEfemerides.add(nuevoEfemeride);
        System.out.println("Producto creado exitosamente!");
     }

	private static void mostrarEfemerides() {
		if (listaEfemerides.isEmpty()) {
	        System.out.println("No hay productos para mostrar.");
	    } else {
	        for (Efemeride efemerides : listaEfemerides) {
	            System.out.println(efemerides);
	        }
	    }
	}
	
	private static void eliminarEfemeride() {
        System.out.print("Ingrese el código de la efeméride a eliminar: ");
        String codigo = scanner.nextLine();
	    Efemeride efemerideAEliminar = null;
	    for (Efemeride efemeride : listaEfemerides) {
	        if (efemeride.getCodigo().equals(codigo)) {
	        	efemerideAEliminar = efemeride;
	            break;
	        }
	    }
        if (efemerideAEliminar != null) {
            listaEfemerides.remove(efemerideAEliminar);
            System.out.println("Efeméride eliminada con éxito.");
        } else {
            System.out.println("No se encontró una efeméride con ese código.");
        }
    }
	
	private static void modificarEfemerides() {
		System.out.print("Ingrese el código del efemerides a modificar: ");
		String codigo = scanner.nextLine();
	    Efemeride efemerideEncontrado = null;
	    for (Efemeride efemeride : listaEfemerides) {
	        if (efemeride.getCodigo().equals(codigo)) {
	            efemerideEncontrado = efemeride;
	            break;
	        }
	    }

	    if (efemerideEncontrado != null) {
	        System.out.print("Ingrese la nuevo codigo: ");
	        efemerideEncontrado.setCodigo(scanner.nextLine()); 
	        
	        System.out.println("---- Origen de fabricación ------");
	        for (Mes meses : Mes.values()) {
	            System.out.println((meses.ordinal() + 1) + " - " + meses);
	        }
	        System.out.print("Elija el nuevo mes: ");
	        int nuevaMeses = scanner.nextInt();
	        Mes nuevoMeses = Mes.values()[nuevaMeses - 1];
	        efemerideEncontrado.setMes(nuevoMeses);
	        
	        System.out.print("Ingrese el nuevo dia: ");
	        efemerideEncontrado.setDia(scanner.nextByte());
	        scanner.nextLine();
	        System.out.print("Ingrese la nuevo detalles: ");
	        efemerideEncontrado.setDetalle(scanner.nextLine());

	        System.out.println("Producto modificado exitosamente!");
	    } else {
	        System.out.println("Producto no encontrado.");
	    }
	}

}
