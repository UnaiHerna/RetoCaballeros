package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Escudo;
import modelo.Formulario;
import modelo.GestorBBDD;
import modelo.Menu;
import vista.Visor;

public class ControladorEscudos {
	
	public static Scanner scan=new Scanner(System.in);
	
		public static void run() {
			
			GestorBBDD gestorBBDD = new GestorBBDD();
			
			int opcion;
			
			do {
				
				Menu.menuEscudos();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				
				case Menu.SALIR: 
					
					System.out.println("Saliendo del menu de escudos...");
					break;
				
				case Menu.VER_ESCUDOS:
					
					ArrayList<Escudo> escudos = gestorBBDD.getEscudos();
					Visor.visualizarEscudos(escudos);
					break;

				case Menu.INSERTAR_ESCUDOS:
					
					Escudo escudo = Formulario.introducirDatosEscudo();
					gestorBBDD.insertarEscudo(escudo);
					
					System.out.println("Se ha introducido el escudo con exito");
					break;
					
				case Menu.ELIMINAR_ESCUDOS:
					
					escudos = gestorBBDD.getEscudos();
					Visor.visualizarEscudos(escudos);
					
					int idEscudo = Formulario.introducirIdEscudo();
					gestorBBDD.eliminarEscudo(idEscudo);
					
					System.out.println("El escudo se ha eliminado con exito");
					break;
					
				case Menu.MODIFICAR_ESCUDOS:
					
					escudos = gestorBBDD.getEscudos();
					Visor.visualizarEscudos(escudos);
					
					idEscudo = Formulario.introducirIdEscudo();
					escudo = Formulario.introducirDatosEscudo();
					gestorBBDD.modificarEscudo(escudo, idEscudo);
					
					System.out.println("Se ha modificado el escudo con exito");
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}
				
				
			}while(opcion != Menu.SALIR);
		}
}
