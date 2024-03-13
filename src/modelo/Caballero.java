package modelo;

public class Caballero {
	private int id;
	private String nombre;
	private int nivel;
	private Arma arma;
	private Escudo escudo;
	private Caballo caballo;
	private Escudero escudero;
	
	public Caballero() {}

	public Caballero(int id, String nombre, int nivel, Arma arma, Escudo escudo, Caballo caballo, Escudero escudero) {
		this.id = id;
		this.nombre = nombre;
		this.nivel = nivel;
		this.arma = arma;
		this.escudo = escudo;
		this.caballo = caballo;
		this.escudero = escudero;
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

	@Override
	public String toString() {
		return "Caballero [id=" + id + ", nombre=" + nombre + ", nivel=" + nivel + ", arma=" + arma + ", escudo="
				+ escudo + ", caballo=" + caballo + ", escudero=" + escudero + "]";
	}
}
