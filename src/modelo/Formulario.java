package modelo;

import java.util.Scanner;

public class Formulario {

	public static Scanner scan = new Scanner(System.in);
	
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
		
		int idEscudo;
		
		System.out.println("Introducir el id del escudo");
		idEscudo = Integer.parseInt(scan.nextLine());
		
		return idEscudo;
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
		
		int idArma;
		
		System.out.println("Introduce el id del arma que quieres");
		idArma = Integer.parseInt(scan.nextLine());
		
		return idArma;
	}
	
}
