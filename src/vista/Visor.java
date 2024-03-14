package vista;

import java.util.ArrayList;

import modelo.Escudo;
import modelo.Lucha;
import modelo.Arma;
import modelo.Caballero;

public class Visor {
	
	public static void visualizarEscudos(ArrayList<Escudo> escudos) {
		for (Escudo escudo : escudos) {
			System.out.println(escudo);
		}
	}
  
	public static void visualizarArmas(ArrayList<Arma> armas) {
		for (Arma arma : armas) {
			System.out.println(arma);
		}
	}
	
	public static void visualizarCaballeros(ArrayList<Caballero> caballeros) {
		for (Caballero caballero : caballeros) {
			System.out.println(caballero);
		}
	}

	public static void visualizarLuchas(ArrayList<Lucha> luchas) {
		for (Lucha lucha : luchas) {
			System.out.println(lucha);
		}
		
	}
  
}