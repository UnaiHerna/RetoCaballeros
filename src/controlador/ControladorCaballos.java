package controlador;

import java.util.ArrayList;
import java.util.Scanner;

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
				gestorBBDD.insertarCaballos(caballo);
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
				caballo = gestorBBDD.getCaballo(idCaballo);
				gestorBBDD.modificarCaballos(caballo, idCaballo);
				
				break;
				
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
		}while(opcion != Menu.SALIR);
		
	}
	
}
