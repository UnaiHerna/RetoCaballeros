package modelo;

import java.util.Random;

public class Caballero {
	private int id;
	private String nombre;
	private int exp;
	private int fuerza;
	private int destreza;
	private Arma arma;
	private Escudo escudo;
	private Caballo caballo;
	private Escudero escudero;
	
	public Caballero() {}

	public Caballero(int id, String nombre, int exp, int fuerza, int destreza, Arma arma, Escudo escudo) {
		this.id = id;
		this.nombre = nombre;
		this.exp = exp;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.arma = arma;
		this.escudo = escudo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}
	
	public Caballo getCaballo() {
		return caballo;
	}

	public void setCaballo(Caballo caballo) {
		this.caballo = caballo;
	}

	public Escudero getEscudero() {
		return escudero;
	}

	public void setEscudero(Escudero escudero) {
		this.escudero = escudero;
	}

	public double getAtaque() {
		if(caballo == null) {
			setCaballo(new Caballo(0, "", 0, 0)); 
		}
		if(escudero == null) {
			setEscudero(new Escudero(0, "", 0, 0)); 
		}
		return (fuerza+destreza*3+arma.getDaño()+caballo.getvMax())-(arma.getPeso()+escudo.getPeso());
	}
	
	public double getDefensa() {
		return fuerza+(escudo.getDefensa()/2)+caballo.getResistencia()+escudero.getFortaleza();
	}
	
	public double getFuerzaDeLucha() {
		Random randomizador = new Random();
		double numAleatorio = randomizador.nextDouble(1)/10;
		System.out.println(numAleatorio);
		return (getAtaque()-getDefensa())*(numAleatorio*exp);
	}
	
	@Override
	public String toString() {
		String caballero = id + "."+ nombre + ": Experencia= " + exp + ", Fuerza= " + fuerza + ", Destreza= "
				+ destreza + ", Arma: " + arma.getNombre() + ", Escudo: " + escudo.getNombre();
		if(caballo != null) {
			caballero = caballero + ", Caballo: " +caballo.getNombre();
		}
		if(escudero != null) {
			caballero = caballero + ", Escudero: " +escudero.getNombre();
		}
		return caballero;
	}

	
}
