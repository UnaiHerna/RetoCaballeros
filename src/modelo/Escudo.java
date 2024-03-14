package modelo;

public class Escudo {
	private int id;
	private String nombre;
	private double defensa;
	private double peso;
	
	public Escudo() {}

	public Escudo(int id, String nombre, double defensa, double peso) {
		this.id = id;
		this.nombre = nombre;
		this.defensa = defensa;
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

	public double getDefensa() {
		return defensa;
	}

	public void setDefensa(double defensa) {
		this.defensa = defensa;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return id + "."+ nombre + ", Defensa= " + defensa + ", Peso= " + peso;
	}
}

