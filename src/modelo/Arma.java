package modelo;

public class Arma {
	private int id;
	private String nombre;
	private double daño;
	private double peso;
	
	public Arma() {}

	public Arma(int id, String nombre, double daño, double peso) {
		this.id = id;
		this.nombre = nombre;
		this.daño = daño;
		this.peso = peso;
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

	public double getDaño() {
		return daño;
	}

	public void setDaño(double daño) {
		this.daño = daño;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Arma [id=" + id + ", nombre=" + nombre + ", daño=" + daño + ", peso=" + peso + "]";
	}
	
	
}
