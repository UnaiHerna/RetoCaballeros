package modelo;

public class Escudero {
	private int id;
	private String nombre;
	private int exp;
	private double fortaleza;
	private Caballero caballero;
	
	public Escudero() {}
	
	public Escudero(int id, String nombre, int exp, double fortaleza, Caballero caballero) {
		this.id = id;
		this.nombre = nombre;
		this.exp = exp;
		this.fortaleza = fortaleza;
		this.caballero = caballero;
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

	public double getFortaleza() {
		return fortaleza;
	}

	public void setFortaleza(double fortaleza) {
		this.fortaleza = fortaleza;
	}

	public Caballero getCaballero() {
		return caballero;
	}

	public void setCaballero(Caballero caballero) {
		this.caballero = caballero;
	}

	@Override
	public String toString() {
		return "Escudero [id=" + id + ", nombre=" + nombre + ", exp=" + exp + ", fortaleza=" + fortaleza
				+ ", caballero=" + caballero + "]";
	}
	
}
