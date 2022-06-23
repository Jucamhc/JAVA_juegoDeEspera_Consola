package Juegos;
/**
 * @author Juan Camilo Hoyos Castaño
 */
import java.util.Scanner;

public class Stop {

	public String Pregunta(int personas, char letra) {

		// VARIABLES
		int puntajes[] = new int[personas];
		int var = 0;
		int primero = 0;
		int segundo = 0;
		Scanner frace = new Scanner(System.in);
		String pregunta[] = { "NOMBRE ", "ANIMAL", "COMIDA", "COLOR", "COSA", "PAIS/CIUDAD" };

		for (int i = 0; i < personas; i++) { // REPITE LA CANTIDAD DE PERSONAS
			int puntaje = 0;
			String respuesta = "";

			for (int j = 0; j < pregunta.length; j++) { // EJECUTA EL FORMULARIO

				// INDICA LA PERSONA QUE ESTA JUGANDO Y PREGUNTA
				System.out.println("\nJuega el jugador numero " + (i + 1));
				System.out.println((j + 1) + " Pregunta " + pregunta[j] + " Con la Letra " + letra);
				
				do { // PREGUNTA SI EL CARACTER ES CORRECTO A UNA LETRA
					
					if(var >= 1) {
						System.out.println("La Palabra tiene un caracter no valido");
					}
					respuesta = frace.nextLine();
					var++;
				} while (!ValidarLetras(respuesta.trim()));
				var = 0;
				char resp = respuesta.toUpperCase().charAt(0); // CONVIERTE LA LETRA EN MAYUSCULA

				if (letra == resp) { // VALIDA SI LA PRIMERA LETRA DEL TEXTO CORRESPONDE CON LA LETRA DE JUEGO
					puntaje = puntaje + 1;
					System.out.println(" Respuesta correcta \n");
				} else {
					System.out.println(" Respuesta incorrecta \n");
				}
				puntajes[i] = puntaje; // ALMACENA EL PUNTAJE DEL JUGADOR
			}
			// RESUMEN DE PUNTAJE DEL JUGADOR
			System.out.println("Jugador " + (i + 1) + ": preguntas correctas " + puntajes[i]);
		}
		
		// SELECCIONA LA CANTIDAD DE JUGADORES PARA EVALUAR QUIEN GANA
		if (puntajes.length == 1) { // SI ES UN SOLO JUGADOR
			primero = puntajes[0]; // PUNTAJE UNO
			return "El ganador es la persona 1 con un puntaje: " + primero + "\n\n";
		} else {
			primero = puntajes[0]; // PUNTAJE UNO
			segundo = puntajes[1]; // PUNTAJE DOS

			if (primero < segundo) {// SI SON DOS JUGADORES
				return "El ganador es la persona 2 con un puntaje: " + segundo + "\n\n";
			} else if (primero == segundo) {
				return "Ganan las dos personas ";
			} else {
				return "El ganador es la persona 1 con un puntaje: " + primero + "\n\\n";
			}
		}

	}

	public static boolean ValidarLetras(String datos) {
		return datos.matches("[a-zA-Z]*");
	}
}
