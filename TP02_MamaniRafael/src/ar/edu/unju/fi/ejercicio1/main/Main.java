package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        do {
            try {
                System.out.println("Menú de opciones:");
                System.out.println("1 – Crear Producto");
                System.out.println("2 – Mostrar productos");
                System.out.println("3 – Modificar producto");
                System.out.println("4 – Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        crearProducto();
                        break;
                    case 2:
                        mostrarProductos();
                        break;
                    case 3:
                        modificarProducto();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.next(); // Limpiar buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Opción no válida. " + e.getMessage());
            }
        } while (opcion != 4);
    }
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	private static void modificarProducto() {
		System.out.print("Ingrese el código del producto a modificar: ");
	    String codigo = scanner.nextLine();
	    Producto productoEncontrado = null;
	    for (Producto producto : listaProductos) {
	        if (producto.getCodigo().equals(codigo)) {
	            productoEncontrado = producto;
	            break;
	        }
	    }

	    if (productoEncontrado != null) {
	        System.out.print("Ingrese la nueva descripción: ");
	        productoEncontrado.setDesc(scanner.nextLine());
	        System.out.print("Ingrese el nuevo precio unitario: ");
	        productoEncontrado.setPrecioUni(scanner.nextDouble());
	        scanner.nextLine(); 
	        
	        System.out.println("---- Origen de fabricación ------");
	        for (OrigenFabricacion origen : OrigenFabricacion.values()) {
	            System.out.println((origen.ordinal() + 1) + " - " + origen);
	        }
	        System.out.print("Elija el nuevo origen de fabricación: ");
	        int nuevaOpcionOrigen = scanner.nextInt();
	        OrigenFabricacion nuevoOrigen = OrigenFabricacion.values()[nuevaOpcionOrigen - 1];
	        productoEncontrado.setOrigenFabricacion(nuevoOrigen);

	        System.out.println("------ Categoría ------");
	        for (Categoria cat : Categoria.values()) {
	            System.out.println((cat.ordinal() + 1) + " - " + cat);
	        }
	        System.out.print("Elija la nueva categoría: ");
	        int nuevaOpcionC = scanner.nextInt();
	        Categoria nuevaC = Categoria.values()[nuevaOpcionC - 1];
	        productoEncontrado.setCategoria(nuevaC);

	        scanner.nextLine();

	        System.out.println("Producto modificado exitosamente!");
	    } else {
	        System.out.println("Producto no encontrado.");
	    }
	}

	private static void mostrarProductos() {
		// TODO Auto-generated method stub
	    if (listaProductos.isEmpty()) {
	        System.out.println("No hay productos para mostrar.");
	    } else {
	        for (Producto producto : listaProductos) {
	            System.out.println(producto);
	        }
	    }
	}

	private static void crearProducto() {
		// TODO Auto-generated method stub
		System.out.print("Ingrese el código del producto: ");
	    String codigo = scanner.nextLine();
	    System.out.print("Ingrese la descripción del producto: ");
	    String descripcion = scanner.nextLine();
	    System.out.print("Ingrese el precio unitario del producto: ");
	    double precioUnitario = scanner.nextDouble();
	    scanner.nextLine(); 
	    System.out.println("---- Origen de fabricación ------");
	    for (OrigenFabricacion origen : OrigenFabricacion.values()) {
	        System.out.println((origen.ordinal() + 1) + " - " + origen);
	    }
	    System.out.print("Elija una opción: ");
	    int opcionO = scanner.nextInt();
	    OrigenFabricacion origenFabricacion = OrigenFabricacion.values()[opcionO - 1];
	    System.out.println("------ Categoría ------");
	    for (Categoria categoria : Categoria.values()) {
	        System.out.println((categoria.ordinal() + 1) + " - " + categoria);
	    }
	    System.out.print("Elija una opción: ");
	    int opcionC = scanner.nextInt();
	    Categoria categoria = Categoria.values()[opcionC - 1];

	    scanner.nextLine();
	    Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
	    listaProductos.add(nuevoProducto);
	    System.out.println("Producto creado exitosamente!");
	}
}
