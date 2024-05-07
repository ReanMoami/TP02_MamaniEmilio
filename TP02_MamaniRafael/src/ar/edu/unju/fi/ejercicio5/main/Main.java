package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Categoria;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.OrigenDeFabricacion;



public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = precargarProductos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        mostrarProductos(listaProductos);
                        break;
                    case 2:
                        realizarCompra(listaProductos);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Productos disponibles:");
        for (Producto producto : productos) {
            System.out.println(producto.getCodigo() + " - " + producto.getDescripcion() + " - Precio: $" + producto.getPrecioUnitario());
        }
    }

    @SuppressWarnings("resource")
	public static void realizarCompra(ArrayList<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        double totalCompra = 0;

        System.out.println("Seleccione los productos que desea comprar (Ingrese 0 para terminar):");
        int codigoProducto;
        do {
            System.out.print("Ingrese el código del producto: ");
            codigoProducto = scanner.nextInt();
            if (codigoProducto != 0) {
                Producto producto = encontrarProducto(productos, codigoProducto);
                if (producto != null) {
                    productosSeleccionados.add(producto);
                    totalCompra += producto.getPrecioUnitario();
                } else {
                    System.out.println("El código del producto no es válido.");
                }
            }
        } while (codigoProducto != 0);

        if (productosSeleccionados.isEmpty()) {
            System.out.println("No se han seleccionado productos para la compra.");
        }

        System.out.println("Total de la compra: $" + totalCompra);
        System.out.println("Opciones de pago:");
        System.out.println("1 - Pago efectivo");
        System.out.println("2 - Pago con tarjeta");
        System.out.print("Ingrese una opción de pago: ");
        int opcionPago = scanner.nextInt();

        switch (opcionPago) {
            case 1:
                PagoEfectivo pagoEfectivo = new PagoEfectivo(totalCompra, LocalDate.now());
                pagoEfectivo.realizarPago(totalCompra);
                System.out.println("------------------------------");
                pagoEfectivo.imprimirRecibo();
                System.out.println("------------------------------");
                break;
            case 2:
                System.out.println("Ingrese su tarjeta de crédito: ");
                String tarjeta = scanner.next();
                PagoTarjeta pagoTarjeta = new PagoTarjeta(tarjeta, LocalDate.now(), totalCompra);
                pagoTarjeta.realizarPago(totalCompra);
                System.out.println("------------------------------");
                pagoTarjeta.imprimirRecibo();
                System.out.println("------------------------------");
                break;
            default:
                System.out.println("Opción de pago no válida. ");
                break;
        }
    }

    private static Producto encontrarProducto(ArrayList<Producto> productos, int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }
    private static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(7, "Monitor", 153200.0, OrigenDeFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto(8, "CPU", 323200.0, OrigenDeFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto(1, "Teléfono", 1500.0, OrigenDeFabricacion.CHINA, Categoria.TELEFONIA, true));
        productos.add(new Producto(2, "Laptop", 1300.0, OrigenDeFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto(3, "Licuadora", 2250.0, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(15, "Heladera", 502100.0, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(5, "Batidora", 121000.0, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(6, "Lavarropas", 423500.0, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(9, "Taclado", 53200.0, OrigenDeFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto(10, "Taladro", 7200.0, OrigenDeFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
        productos.add(new Producto(4, "Cocina", 80500.0, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(11, "Motosierra", 21200.0, OrigenDeFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
        productos.add(new Producto(12, "Telefono fijo", 25032.0, OrigenDeFabricacion.URUGUAY, Categoria.TELEFONIA, true));
        productos.add(new Producto(13, "Router", 50320.0, OrigenDeFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto(14, "Tablet", 17800.0, OrigenDeFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
        return productos;
    }
}
