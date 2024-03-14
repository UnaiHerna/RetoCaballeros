package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.*;
import vista.Visor;

public class ControladorLuchas {
	
	public static Scanner scan=new Scanner(System.in);
	
		public static void run() {
		
			GestorBBDD gestorBBDD = new GestorBBDD();
		
			int opcion;
			
			do {
				
				Menu.menuLucha();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				
				case Menu.SALIR:
					
					System.out.println("Saliendo del menu de luchas...");
					break;
				
				case Menu.VER_LUCHAS:
					
					ArrayList<Lucha> luchas = gestorBBDD.getLuchas();
					Visor.visualizarLuchas(luchas);
					break;

				case Menu.INSERTAR_LUCHA:
					
					Lucha lucha = Formulario.introducirDatosLucha();
					gestorBBDD.insertarLucha(lucha);
					
					System.out.println("Se ha introducido la lucha con exito");
					break;
					
				case Menu.ELIMINAR_LUCHA:
					
					luchas = gestorBBDD.getLuchas();
					Visor.visualizarLuchas(luchas);
					
					int idLucha = Formulario.introducirIdLucha();
					gestorBBDD.eliminarLucha(idLucha);
					
					System.out.println("La lucha se ha eliminado con exito");
					break;
					
				case Menu.MODIFICAR_LUCHA:
					
					luchas = gestorBBDD.getLuchas();
					Visor.visualizarLuchas(luchas);
					
					idLucha = Formulario.introducirIdLucha();
					lucha = Formulario.introducirDatosLucha();
					gestorBBDD.modificarLucha(lucha, idLucha);
					
					System.out.println("Se ha modificado el escudo con exito");
					break;
					
				
				case Menu.COMIENZA_LUCHA:
					
					luchas = gestorBBDD.getLuchas();
					Visor.visualizarLuchas(luchas);
					
					Lucha luchaPrueba = gestorBBDD.getLucha(Formulario.introducirIdLucha());
					Caballero ganador = luchaPrueba.comienzoLucha();
					System.out.println("El ganador es...");
					System.out.println("¡¡¡"+ganador.getNombre()+"!!!");
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}
				
			}while(opcion != Menu.SALIR);
		}
}
