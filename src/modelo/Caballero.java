package modelo;

public class Caballero {
	private int id;
	private String nombre;
	private int nivel;
	private Arma arma;
	private Escudo escudo;
	
	public Caballero() {}

	public Caballero(int id, String nombre, int nivel, Arma arma, Escudo escudo) {
		this.id = id;
		this.nombre = nombre;
		this.nivel = nivel;
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
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
		return "Caballero [id=" + id + ", nombre=" + nombre + ", nivel=" + nivel + ", arma=" + arma + ", escudo="
				+ escudo + "]";
	}
}
