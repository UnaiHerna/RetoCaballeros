package modelo;

public class Escudo {
	private int id;
	private String nombre;
	private double defensa;
	
	public Escudo() {}
	
	public Escudo(int id, String nombre, double defensa) {
		this.id = id;
		this.nombre = nombre;
		this.defensa = defensa;
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

	public double getDefensa() {
		return defensa;
	}

	public void setDefensa(double defensa) {
		this.defensa = defensa;
	}
}

