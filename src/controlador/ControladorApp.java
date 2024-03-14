package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import modelo.*;
import vista.Visor;

public class ControladorApp {
	
	public final static int SALIR = 0;
	public final static int VER_ESCUDOS = 1;
	public final static int INSERTAR_ESCUDOS = 2;
	public final static int ELIMINAR_ESCUDOS = 3;
	public final static int MODIFICAR_ESCUDOS = 4;
	
	public final static int VER_ARMAS = 1;
	public final static int INSERTAR_ARMAS = 2;
	public final static int ELIMINAR_ARMA = 3;
	public final static int MODIFICAR_ARMA = 4;
	public final static int PRUEBA_PELEA = 5;
	
		
	public static Scanner scan=new Scanner(System.in);

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
			
			case PRUEBA_PELEA:
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
		System.out.println(VER_ESCUDOS + "- Visualizar todos los escudos");
		System.out.println(INSERTAR_ESCUDOS + "- Crear escudos nuevos");
		System.out.println(ELIMINAR_ESCUDOS + "- Elimina escudos");
		System.out.println(MODIFICAR_ESCUDOS + "- Modifica los escudos ya creados");
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
