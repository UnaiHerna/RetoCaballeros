package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Caballero;
import modelo.Caballo;
import modelo.Formulario;
import modelo.GestorBBDD;
import modelo.Menu;
import vista.Visor;

public class ControladorCaballos {

	static Scanner scan = new Scanner(System.in);
	
	public static void run() {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		int opcion;
		
		do {
			
			Menu.menuCaballos();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.VER_CABALLOS:
				
				ArrayList<Caballo> caballos = gestorBBDD.getCaballos();
				Visor.visualizarCaballos(caballos);
				break;
			
			case Menu.INSERTAR_CABALLOS:			
				Caballo caballo = Formulario.introducirDatosCaballo();
				ArrayList<Caballero> caballeros = gestorBBDD.getCaballeros();
				Visor.visualizarCaballeros(caballeros);
				
				int idCaballero = Formulario.introducirIdCaballero();
				gestorBBDD.insertarCaballos(caballo, idCaballero);
				break;
				
			case Menu.ELIMINAR_CABALLOS:
				
				caballos = gestorBBDD.getCaballos();
				Visor.visualizarCaballos(caballos);
				
				int idCaballo = Formulario.introducirIdCaballo();
				gestorBBDD.eliminarCaballo(idCaballo);
				break;
				
			case Menu.MODIFICAR_CABALLOS:
				
				caballos = gestorBBDD.getCaballos();
				Visor.visualizarCaballos(caballos);
				
				idCaballo = Formulario.introducirIdCaballo();
				caballo = Formulario.introducirDatosCaballo();
				gestorBBDD.modificarCaballos(caballo, idCaballo);
				
				break;
				
			case Menu.SALIR:
				
				System.out.println("Saliendo del menu de caballos");
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
		}while(opcion != Menu.SALIR);
		
	}
	
}
