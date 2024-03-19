package modelo;

public class Caballo {
	private int id;
	private String nombre;
	private double vMax;
	private double resistencia;
	
	public Caballo() {}
	
	public Caballo(int id, String nombre, double vMax, double resistencia) {
		this.id = id;
		this.nombre = nombre;
		this.vMax = vMax;
		this.resistencia = resistencia;
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

	@Override
	public String toString() {
		return id + "."+ nombre + ", Velocidad Maxima= " + vMax + ", Resistencia= " + resistencia;
	}
	
}
