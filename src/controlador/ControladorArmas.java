package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Arma;
import modelo.Formulario;
import modelo.GestorBBDD;
import modelo.Menu;
import vista.Visor;

public class ControladorArmas {

	public static Scanner scan=new Scanner(System.in);
	
	public static void run() {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		int opcion;
		
		do {
			
			Menu.menuArmas();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			
			case Menu.SALIR: 
				
				System.out.println("Saliendo del menu de armas...");
				break;
			
			case Menu.VER_ARMAS:
				
				ArrayList<Arma> armas = gestorBBDD.getArmas();
				Visor.visualizarArmas(armas);
				break;
			
			case Menu.INSERTAR_ARMAS:
				
				Arma arma = Formulario.introducirDatosArma();
				gestorBBDD.insertarArmas(arma);
				System.out.println("Arma introducida con exito");
				
				break;
				
			case Menu.ELIMINAR_ARMA:
				
				armas = gestorBBDD.getArmas();
				Visor.visualizarArmas(armas);
				
				int idArma = Formulario.introducirIdArma();
				gestorBBDD.eliminarArma(idArma);
				
				System.out.println("Arma eliminada con exito");
				break;
				
			case Menu.MODIFICAR_ARMA:
				
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
			
		}while(opcion != Menu.SALIR);
	}
}

