package modelo;

import java.util.Scanner;

public class Formulario {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static Arma introducirDatosArma() {
		
		Arma arma = new Arma();
		
		arma.setId(getIdArma());
		
		System.out.println("Introduce el nombre del arma");
		arma.setNombre(scan.nextLine());
		
		System.out.println("Introduce el daño del arma");
		arma.setDaño(Double.parseDouble(scan.nextLine()));
		
		System.out.println("Introduce el peso del arma");
		arma.setPeso(Double.parseDouble(scan.nextLine()));
		
		return arma;
		
	}
	
	public static int getIdArma() {
		
		int idArma;
		
		System.out.println("Introduce el id del arma que quieres");
		idArma = Integer.parseInt(scan.nextLine());
		
		return idArma;
		
	}
	
}
