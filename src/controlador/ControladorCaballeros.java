package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Caballero;
import modelo.Formulario;
import modelo.GestorBBDD;
import modelo.Menu;
import vista.Visor;

public class ControladorCaballeros {
	
	public static Scanner scan=new Scanner(System.in);
	
	public static void run() {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		int opcion;
		
		do {
			
			Menu.menuCaballeros();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			
			case Menu.SALIR: 
				
				System.out.println("Saliendo del menu de caballeros...");
				break;
				
			case Menu.VER_CABALLEROS:
				
				ArrayList<Caballero> caballeros = gestorBBDD.getCaballeros();
				Visor.visualizarCaballeros(caballeros);
				break;
				
			case Menu.INSERTAR_CABALLEROS:
				
				Caballero caballero = Formulario.introducirDatosCaballero();
				gestorBBDD.insertarCaballero(caballero);
				break;
				
			case Menu.ELIMINAR_CABALLEROS:
				
				caballeros = gestorBBDD.getCaballeros();
				Visor.visualizarCaballeros(caballeros);
				
				int idCaballero = Formulario.introducirIdCaballero();
				gestorBBDD.eliminarCaballero(idCaballero);
				break;
			
			case Menu.MODIFICAR_CABALLEROS:
				
				caballeros = gestorBBDD.getCaballeros();
				Visor.visualizarCaballeros(caballeros);
				
				idCaballero = Formulario.introducirIdCaballero();
				caballero = Formulario.introducirDatosCaballero();
				gestorBBDD.modificarCaballero(caballero, idCaballero);
				
				break;
				
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
		}while(opcion != Menu.SALIR);
		
	}
	
}
