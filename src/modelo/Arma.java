package modelo;

public class Arma {
	private int id;
	private String nombre;
	private double daño;
	
	public Arma() {}
	
	public Arma(int id, String nombre, double daño) {
		this.id = id;
		this.nombre = nombre;
		this.daño = daño;
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
}
