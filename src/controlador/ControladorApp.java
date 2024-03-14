package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.*;
import vista.Visor;

public class ControladorApp {

public final static int SALIR = 0;
public final static int VER_ESCUDOS = 1;
public final static int INSERTAR_ESCUDOS = 2;
public final static int ELIMINAR_ESCUDOS = 3;
public final static int MODIFICAR_ESCUDOS = 4;
	
public static Scanner scan=new Scanner(System.in);
	
	public static void run() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		boolean salir=false;
		
		int opcion;
		
		do{
			
			menuEscudos();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case SALIR:
				System.out.println("Saliendo del programa");
				salir = true;
				break;
			
			case VER_ESCUDOS:
				
				ArrayList<Escudo> escudos = gestorBBDD.getEscudos();
				Visor.verEscudos(escudos);

			case INSERTAR_ESCUDOS:
				
				Escudo escudo = Formulario.introducirDatosEscudo();
				gestorBBDD.insertarEscudo(escudo);
				
				System.out.println("Se ha introducido el escudo con exito");
				break;
				
			case ELIMINAR_ESCUDOS:
				
				escudos = gestorBBDD.getEscudos();
				Visor.verEscudos(escudos);
				
				int idEscudo = Formulario.introducirIdEscudo();
				gestorBBDD.eliminarEscudo(idEscudo);
				
				System.out.println("El escudo se ha eliminado con exito");
				break;
				
			case MODIFICAR_ESCUDOS:
				
				escudos = gestorBBDD.getEscudos();
				Visor.verEscudos(escudos);
				
				idEscudo = Formulario.introducirIdEscudo();
				escudo = Formulario.introducirDatosEscudo();
				gestorBBDD.modificarEscudo(escudo, idEscudo);
				
				System.out.println("Se ha modificado el escudo con exito");
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
		}while(!salir);
	}

	
	
	public static void menuEscudos(){
		
		System.out.println("--MENU--");
		System.out.println(SALIR + "- Salir del programa");
		System.out.println(VER_ESCUDOS + "- Visualizar todas las armas");
		System.out.println(INSERTAR_ESCUDOS + "- Crear armas nuevas");
		System.out.println(ELIMINAR_ESCUDOS + "- Elimina armas");
		System.out.println(MODIFICAR_ESCUDOS + "- Modifica las armas ya creadas");
	}
}
