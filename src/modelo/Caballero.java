package modelo;

public class Caballero {
	private int id;
	private String nombre;
	private int exp;
	private int fuerza;
	private int destreza;
	private Arma arma;
	private Escudo escudo;
	
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

	@Override
	public String toString() {
		return "Caballero [id=" + id + ", nombre=" + nombre + ", exp=" + exp + ", fuerza=" + fuerza + ", destreza="
				+ destreza + ", arma=" + arma + ", escudo=" + escudo + "]";
	}

	
}
