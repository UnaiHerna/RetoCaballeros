package modelo;

public class Caballo {
	private int id;
	private String nombre;
	private double vMax;
	private double resistencia;
	private Caballero caballero;
	
	public Caballo() {}
	
	public Caballo(int id, String nombre, double vMax, double resistencia, Caballero caballero) {
		this.id = id;
		this.nombre = nombre;
		this.vMax = vMax;
		this.resistencia = resistencia;
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

	public double getvMax() {
		return vMax;
	}

	public void setvMax(double vMax) {
		this.vMax = vMax;
	}

	public double getResistencia() {
		return resistencia;
	}

	public void setResistencia(double resistencia) {
		this.resistencia = resistencia;
	}

	public Caballero getCaballero() {
		return caballero;
	}

	public void setCaballero(Caballero caballero) {
		this.caballero = caballero;
	}

	@Override
	public String toString() {
		return id + "."+ nombre + ", Velocidad Maxima= " + vMax + ", Resistencia= " + resistencia
				+ ", Caballero: " + caballero.getNombre();
	}
	
}
