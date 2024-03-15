package modelo;

import java.util.Date;
import java.util.Scanner;

import vista.Visor;

public class Formulario {

	public static Scanner scan = new Scanner(System.in);
	
	public static Caballero introducirDatosCaballero() {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		Caballero caballero = new Caballero();
		
		System.out.println("Introduce el nombre del caballero");
		caballero.setNombre(scan.nextLine());
		
		System.out.println("Introduce la experiencia del caballero");
		caballero.setExp(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Introduce la fuerza que tiene el caballero");
		caballero.setFuerza(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Introduce la destreza que tiene el caballero");
		caballero.setDestreza(Integer.parseInt(scan.nextLine()));
		
		//Arma
		Visor.visualizarArmas(gestorBBDD.getArmas());
		caballero.setArma(gestorBBDD.getArma(Formulario.introducirIdArma()));
		
		//Escudo
		Visor.visualizarEscudos(gestorBBDD.getEscudos());
		caballero.setEscudo(gestorBBDD.getEscudo(Formulario.introducirIdEscudo()));
		
		return caballero;
		
	}
	
	public static int introducirIdCaballero() {
		System.out.println("Introduce el id del caballero");
		return Integer.parseInt(scan.nextLine());
		
	}
	
	public static Escudo introducirDatosEscudo() {
		
		Escudo escudo = new Escudo();
		
		System.out.println("Introduce el nombre del escudo");
		escudo.setNombre(scan.nextLine());
		
		System.out.println("Introduce la defensa que proporciona el escudo");
		escudo.setDefensa(Double.parseDouble(scan.nextLine()));
		
		System.out.println("Introduce el peso del escudo");
		escudo.setPeso(Double.parseDouble(scan.nextLine()));
		
		return escudo;
	}
	
	public static int introducirIdEscudo() {
		System.out.println("Introducir el id del escudo");
		return Integer.parseInt(scan.nextLine());
  }
	
	public static Arma introducirDatosArma() {
		
		Arma arma = new Arma();
		
		System.out.println("Introduce el nombre del arma");
		arma.setNombre(scan.nextLine());
		
		System.out.println("Introduce el daño del arma");
		arma.setDaño(Double.parseDouble(scan.nextLine()));
		
		System.out.println("Introduce el peso del arma");
		arma.setPeso(Double.parseDouble(scan.nextLine()));
		
		return arma;
		
	}
	
	public static int introducirIdArma() {
		System.out.println("Introduce el id del arma que quieres");
		return Integer.parseInt(scan.nextLine());
	}

	public static int introducirIdLucha() {
		System.out.println("Introduce el id de la lucha que quieres");
		return Integer.parseInt(scan.nextLine());
	}

	public static Lucha introducirDatosLucha() {
		Lucha lucha = new Lucha();
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		lucha.setFecha(new Date());
		
		Visor.visualizarCaballeros(gestorBBDD.getCaballeros());
		lucha.setGanador(gestorBBDD.getCaballero(introducirIdCaballero()));
		
		Visor.visualizarCaballeros(gestorBBDD.getCaballeros());
		lucha.setPerdedor(gestorBBDD.getCaballero(introducirIdCaballero()));
		
		return lucha;
	}

	public static String yesOrNo() {
		System.out.println("Quieres eliminar un caballero con una lucha creada? "
				+ "\nSi lo haces todas sus luchas se borrarán (Y/n)");
		
		return scan.nextLine();
	}
	
}
