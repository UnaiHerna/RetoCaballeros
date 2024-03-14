package controlador;

import java.util.Date;
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
				
				case Menu.PRUEBA_PELEA:
					Visor.visualizarCaballeros(gestorBBDD.getCaballeros());
					System.out.println("Escribe el id del primer participante de la pelea");
					Caballero caballero1 = gestorBBDD.getCaballero(Integer.parseInt(scan.nextLine()));
					
					System.out.println("Escribe el id del segundo participante de la pelea");	
					Caballero caballero2 = gestorBBDD.getCaballero(Integer.parseInt(scan.nextLine()));
					
					Lucha lucha = new Lucha(new Date(), caballero1, caballero2);
					lucha.lucha(caballero1, caballero2);
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}
				
			}while(opcion != Menu.SALIR);
		}
}
