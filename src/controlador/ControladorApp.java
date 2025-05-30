package controlador;

import java.util.Scanner;

import modelo.Menu;
import window.PantallaPrincipal;

public class ControladorApp {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void run() {
		
		int opcion;
		
		do {
			
			Menu.menuPrincipal();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			
			case Menu.SALIR: 
				
				System.out.println("Saliendo del programa");
				break;
			
			case Menu.CABALLEROS:
				
				ControladorCaballeros.run();
				break;
				
			case Menu.ARMAS:
				
				ControladorArmas.run();
				break;
			
			case Menu.ESCUDOS:
				
				ControladorEscudos.run();
				break;
			
			case Menu.LUCHAS:
				
				ControladorLuchas.run();
				break;
				
			case Menu.CABALLOS:
				
				ControladorCaballos.run();
				break;
			
			case Menu.ESCUDEROS:
				
				ControladorEscuderos.run();
				break;
				
			case Menu.JUEGO:
				
				PantallaPrincipal.main(null);
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
		}while(opcion != Menu.SALIR);
		
	}
	
}
