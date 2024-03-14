package vista;

import java.util.ArrayList;

import modelo.Escudo;
import modelo.Arma;

public class Visor {
	
	public static void verEscudos(ArrayList<Escudo> escudos) {
		
		for (Escudo escudo : escudos) {
			System.out.println(escudo);
		}
	}
  
  public static void visualizarArmas(ArrayList<Arma> armas) {
			for (Arma arma : armas) {
				System.out.println(arma);
			}
	}
	
}