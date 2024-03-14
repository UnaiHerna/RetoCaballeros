package vista;

import java.util.ArrayList;

import modelo.Escudo;

public class Visor {
	
	public static void verEscudos(ArrayList<Escudo> escudos) {
		
		for (Escudo escudo : escudos) {
			System.out.println(escudo);
		}
	}
	
	
}
