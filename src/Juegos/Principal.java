package Juegos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		int juego = 0;
		int personas = 0;
		//MENSAJES DE BIENVENIDA
		System.out.println("Bienvenido a su restaurante");
		System.out.println("Juego mientras esperas tu comida ");
		
		//METODO DO WHILE LOS UTILIZAMOS PARA QUE SE CUMPLA LO ESTABLECIDO 
		
		do { //SOLO SE PERMITE UNO O DOS USUARIO
			System.out.println("Cuantas personas van a jugar minímo una maximo dos");
			personas = leer.nextInt();
		} while (!(personas == 1 || personas ==2));

		do {
			//MENU DE LOGICA DEL PROGRAMA / GESTIONA LA ACCION DE LOS JUEGOS
			System.out.println("1. Quieres jugar stop");
			System.out.println("2. Quieres jugar ahorcado");
			System.out.println("3. Ya llego tu pedido");
			juego = leer.nextInt();
			
			switch (juego) { //METODO DO WITCH LOS UTILIZAMOS PARA SIMULAR MENUS 

			case 1://OPCIÓN UNO, JUEGO STOP
				Stop pregunta = new Stop();
				System.out.println("Con que letra quieres jugar");
				char letra = leer.next().toUpperCase().charAt(0);
				System.out.println("Inicio de juego stop \n" + "REGLAS\nEl Juego no permite Numeros \n"
						+ "Los espacios en blanco cuentan como caracteres\n"
						+ "NO importa si utilizas mayusculas y minusculas\n");
				System.out.println(pregunta.Pregunta(personas, letra));
				break;
			case 2:// OPCION DOS, JUEGO AHORCADO
				Ahorcado persona = new Ahorcado();
				System.out.println(persona.fraceCecreta(personas));
				break;
			case 3:// PERMITE SALIR
				break;
			}
			
		}while(juego!=3);
		
		//MENSAJE DE SALIDA AL USUARIO
		System.out.println("Que disfrutes tu comida, hasta pronto !!!!");
	
	}
}
