package Juegos;

/**
 * @author Juan Camilo Hoyos Castaño
 */

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	public String fraceCecreta(int personas) {

		// VARIABLES
		String[] lista1 = { "ESTUFA", "PLANCHA", "MESA" };
		int aleatorio = (int) (Math.random() * 3);
		String palabra = lista1[aleatorio];
		Scanner leer = new Scanner(System.in);
		int intentos = palabra.length() + 3;
		int numeroLetras = palabra.length();
		char guionesPalabra[] = new char[numeroLetras];
		int primero = 0;
		int segundo = 0;
		int errores[] = new int[personas];

		// PRIMER FOR NOS INDICA LA CANTIDAD DE VECES QUE SE VA REPETIR EL JUEGO
		// CANTIDAD DE PERSONAS A JUGAR
		
		for (int p = 0; p < personas; p++) {
			System.out.println(palabra);
			int error = 0;

			// NOS CREA UN ARRAY CON LA CANTIDAD DE PALABRA CONVERTIDA EN LINEAS
			for (int j = 0; j < guionesPalabra.length; j++) {
				guionesPalabra[j] = '_';
			}

			// FOR, NOS DA LAS CANTIDADES DE VECES QUE PODEMOS INTENTAR ESCRIBIR LAS LETRAS
			for (int i = 0; i < intentos; i++) {
				System.out.println("Inctroduce una letra");
				String letra = leer.nextLine().toUpperCase();
				int con = 0;

				// FOR, NOS CONVIERTE LA POSICION DEL ARRAY EN LA LETRA CORRESPONDIENTE
				for (int j = 0; j < palabra.length(); j++) {	
					if (letra.charAt(0) == palabra.charAt(j)) {
						guionesPalabra[j] = letra.charAt(0);
						for (int t = 0; t < guionesPalabra.length; t++) {
							System.out.println(guionesPalabra[t]);
							con++;
						}
					}

				}
				// SI LA VARIABLE "CON" NO SE EJECUTA, ES POR QUE NO SE INSERTO NINGUNA LETRA
				// EN EL ARRAY Y LA LETRA INGRESADA FUE ERRADA
				if (con == 0) {
					System.out.println("Letra No Esta");
					error++;
				}
				// NOS VALIDA SI LA PALABRA ESTA COMPLETA PARA FINALIZAR EL JUEGO
				String compara = String.valueOf(guionesPalabra);
				if (compara.equals(palabra)) {
					break;
				}
				// NOS INDICA CUANTOS INTENTOS TENEMOS
				System.out.println("Intento Numero: " + (i + 1) + " de: " + intentos);

			}
			// NOS INDICA SI TERMINAMOS O SE NOS ACABARON LOS INTENTOS
			String chatAString = String.valueOf(guionesPalabra);
			if (chatAString.equals(palabra)) {
				System.out.println("Terminaste");
			} else {
				System.out.println("Intentos Terminados");
			}
			errores[p] = error;
			System.out.println("Jugador " + (p + 1) + ": Cantidad de errores " + errores[p]);// RESUMEN DE PUNTAJE
		}

		// SELECCIONA LA CANTIDAD DE JUGADORES PARA EVALUAR QUIEN GANA
		if (errores.length == 1) { // SI ES UN SOLO JUGADOR
			primero = errores[0]; // PUNTAJE UNO
			return "El Ganador es la persona 1 con errores: " + primero;
		} else {
			primero = errores[0]; // PUNTAJE UNO
			segundo = errores[1]; // PUNTAJE DOS

			if (primero > segundo) {// SI SON DOS JUGADORES
				return "El Ganador es la persona 2 Cantidad de errores: " + segundo + "\n\\n";
			} else if (primero == segundo) {// SI SON DOS LOS GANADORES
				return "Ganan las dos personas " + "\n\\n";
			} else { // SI GANO UNO SOLO
				return "El Ganador es la persona 1 Cantidad de errores: " + primero+ "\n\\n";
			}
		}
	}
}