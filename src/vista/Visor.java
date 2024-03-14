package vista;

import java.util.ArrayList;

import modelo.Arma;

public class Visor {

	public static void visualizarArmas(ArrayList<Arma> armas) {
			for (Arma arma : armas) {
				System.out.println(arma);
			}
	}

	
}



