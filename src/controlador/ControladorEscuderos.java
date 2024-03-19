package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.*;
import vista.Visor;

public class ControladorEscuderos {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void run() {
	
		GestorBBDD gestorBBDD = new GestorBBDD();
		int opcion;
		
		do {
			
			Menu.menuEscuderos();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.VER_ESCUDEROS:
				
				ArrayList<Escudero> escuderos =gestorBBDD.getEscuderos();
				Visor.visualizarEscuderos(escuderos);
				break;
				
			case Menu.INSERTAR_ESCUDEROS:
				
				Escudero escudero = Formulario.introducirDatosEscudero();
				ArrayList<Caballero> caballeros = gestorBBDD.getCaballeros();
				Visor.visualizarCaballeros(caballeros);
				
				int idCaballero = Formulario.introducirIdCaballero();
				gestorBBDD.insertarEscuderos(escudero, idCaballero);
				break;
			
			case Menu.ELIMINAR_ESCUDEROS:
				
				escuderos =gestorBBDD.getEscuderos();
				Visor.visualizarEscuderos(escuderos);
				
				int idEscudero = Formulario.introducirIdEscudero();
				gestorBBDD.eliminarEscudero(idEscudero);
				break;
			
			case Menu.MODIFICAR_ESCUDEROS:
				
				escuderos =gestorBBDD.getEscuderos();
				Visor.visualizarEscuderos(escuderos);
				
				idEscudero = Formulario.introducirIdEscudero();
				escudero = gestorBBDD.getEscudero(idEscudero);
				gestorBBDD.modificarEscuderos(escudero, idEscudero);
				break;
			
			case Menu.SALIR:
				
				System.out.println("Saliendo del menu de escuderos...");
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
		}while(opcion != Menu.SALIR);
	}
}
