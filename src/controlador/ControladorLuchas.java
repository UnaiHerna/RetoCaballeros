package controlador;

import java.util.Date;
import java.util.Scanner;

import modelo.Arma;
import modelo.Caballero;
import modelo.Escudo;
import modelo.GestorBBDD;
import modelo.Lucha;
import modelo.Menu;

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
					Lucha lucha = new Lucha();
					Arma armaPrueba = new Arma(1, "pepo", 12, 12);
					Escudo escudoPrueba = new Escudo(1, "pepo", 12, 12);
					Caballero caballero1 = new Caballero(1, "Pedro", 3, 12, 13, armaPrueba, escudoPrueba);
					Caballero caballero2 = new Caballero(2, "Anakin", 5, 10, 9, armaPrueba, escudoPrueba);
					
					lucha.setId(1);
					lucha.setFecha(new Date());
					lucha.setCaballero1(caballero1);
					lucha.setCaballero2(caballero2);
					
					Caballero ganador = lucha.lucha(lucha.getCaballero1(), lucha.getCaballero2());
					System.out.println(ganador);
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}
				
			}while(opcion != Menu.SALIR);
		}
}
