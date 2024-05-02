package ar.edu.unju.fi.ejercicio4.main;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.model.Jugador;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Alta de jugador");//
            System.out.println("2 – Mostrar los datos del jugadores");
            System.out.println("3 – Modificar los datos de un jugador");
            System.out.println("4 – Eliminar un jugador");
            System.out.println("5 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	try {
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el apellido del jugador: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese la fecha de nacimiento (formato dd/mm/yyyy): ");
                        String fechaNacimientoStr = scanner.nextLine();
                        String[] partesFecha = fechaNacimientoStr.split("/");
                        int dia = Integer.parseInt(partesFecha[0]);
                        int mes = Integer.parseInt(partesFecha[1]) - 1; // Restamos 1 porque los meses en Calendar van de 0 a 11
                        int año = Integer.parseInt(partesFecha[2]);
                        Calendar fechaNacimiento = Calendar.getInstance();
                        fechaNacimiento.set(año, mes, dia);
                        System.out.print("Ingrese la nacionalidad: ");
                        String nacionalidad = scanner.nextLine();
                        System.out.print("Ingrese la estatura (en metros): ");
                        double estatura = scanner.nextDouble();
                        System.out.print("Ingrese el peso (en kilogramos): ");
                        double peso = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        System.out.print("Ingrese la posición (delantero, medio, defensa, arquero): ");
                        System.out.println("---- Posicion ------");
            	        for (Posicion posiciones : Posicion.values()) {
            	            System.out.println((posiciones.ordinal() + 1) + " - " + posiciones);
            	        }
            	        System.out.print("Elija la Posicion: ");
            	        int opcionPosicion = scanner.nextInt();
            	        Posicion posicion = Posicion.values()[opcionPosicion - 1];
                        Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
                        listaJugadores.add(nuevoJugador);
                        System.out.println("Jugador agregado exitosamente.");
                    } catch (DateTimeParseException e) {
                        System.out.println("Error: La fecha de nacimiento no tiene el formato correcto.");
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Se esperaba un número.");
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error al agregar el jugador.");
                    }
                    break;
                case 2:
                	if (listaJugadores.isEmpty()) {
            	        System.out.println("No hay productos para mostrar.");
            	    } else {
            	        for (Jugador jugadores : listaJugadores) {
            	            System.out.println(jugadores);
            	        }
            	    }
                    break;
                case 3:
                    try {
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        System.out.print("Ingrese el nombre del jugador a modificar: ");
                        String nombreModificar = scanner.nextLine();
                        System.out.print("Ingrese el apellido del jugador a modificar: ");
                        String apellidoModificar = scanner.nextLine();

                        Jugador jugadorAModificar = null;
                        for (Jugador jugador : listaJugadores) {
                            if (jugador.getNombre().equalsIgnoreCase(nombreModificar) && jugador.getApellido().equalsIgnoreCase(apellidoModificar)) {
                                jugadorAModificar = jugador;
                                break;
                            }
                        }

                        if (jugadorAModificar != null) {	
                            System.out.println("---- Posicion ------");
                	        for (Posicion posiciones : Posicion.values()) {
                	            System.out.println((posiciones.ordinal() + 1) + " - " + posiciones);
                	        }
                	        System.out.print("Elija la nueva Posicion: ");
                	        int nuevaPosicion = scanner.nextInt();
                	        Posicion posicion = Posicion.values()[nuevaPosicion - 1];
                	        jugadorAModificar.setPosicion(posicion);
                            System.out.println("Los datos del jugador han sido actualizados.");
                        } else {
                            System.out.println("Jugador no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error al modificar los datos del jugador.");
                    }
                break;
                case 4:
                    try {
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        System.out.print("Ingrese el nombre del jugador a eliminar: ");
                        String nombreEliminar = scanner.nextLine();
                        System.out.print("Ingrese el apellido del jugador a eliminar: ");
                        String apellidoEliminar = scanner.nextLine();

                        Iterator<Jugador> iterator = listaJugadores.iterator();
                        boolean eliminado = false;
                        while (iterator.hasNext()) {
                            Jugador jugador = iterator.next();
                            if (jugador.getNombre().equalsIgnoreCase(nombreEliminar) && jugador.getApellido().equalsIgnoreCase(apellidoEliminar)) {
                                iterator.remove();
                                eliminado = true;
                                System.out.println("El jugador ha sido eliminado exitosamente.");
                                break;
                            }
                        }

                        if (!eliminado) {
                            System.out.println("Jugador no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error al eliminar el jugador.");
                    }
                break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
	}

}
