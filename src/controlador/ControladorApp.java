package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.*;
import vista.Visor;

public class ControladorApp {

public static Scanner scan=new Scanner(System.in);

	public final static int SALIR = 0;
	public final static int VER_ARMAS = 1;
	public final static int INSERTAR_ARMAS = 2;
	public final static int ELIMINAR_ARMA = 3;
	public final static int MODIFICAR_ARMA = 4;
	
	
	public static void run() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		boolean salir=false;
		
		int opcion;
		
		do{
			menuArmas();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case SALIR: 
				System.out.println("Saliendo del programa");
				salir = true;
				break;
			
			case VER_ARMAS:
				
				ArrayList<Arma> armas = gestorBBDD.getArmas();
				Visor.visualizarArmas(armas);
				break;
			
			case INSERTAR_ARMAS:
				
				Arma arma = Formulario.introducirDatosArma();
				gestorBBDD.insertarArmas(arma);
				System.out.println("Arma introducida con exito");
				
				break;
				
			case ELIMINAR_ARMA:
				
				armas = gestorBBDD.getArmas();
				Visor.visualizarArmas(armas);
				
				int idArma = Formulario.introducirIdArma();
				gestorBBDD.eliminarArma(idArma);
				
				System.out.println("Arma eliminada con exito");
				break;
				
			case MODIFICAR_ARMA:
				
				armas = gestorBBDD.getArmas();
				Visor.visualizarArmas(armas);
				
				
				idArma = Formulario.introducirIdArma();
				arma = Formulario.introducirDatosArma();
				gestorBBDD.modificarArma(arma, idArma);
				
				System.out.println("Se ha modificado con exito");
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
		}while(!salir);
	}

	public static void menuArmas(){
		
		System.out.println("--MENU--");
		System.out.println(SALIR + "- Salir del programa");
		System.out.println(VER_ARMAS + "- Visualizar todas las armas");
		System.out.println(INSERTAR_ARMAS + "- Crear armas nuevas");
		System.out.println(ELIMINAR_ARMA + "- Elimina armas");
		System.out.println(MODIFICAR_ARMA + "- Modifica las armas ya creadas");
	}
	
}
