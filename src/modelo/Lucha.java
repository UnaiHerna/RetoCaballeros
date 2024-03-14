package modelo;

import java.util.Date;

public class Lucha {
	private int id;
	private Date fecha;
	private Caballero caballero1;
	private Caballero caballero2;
	
	public Lucha() {}

	public Lucha(int id, Date fecha, Caballero caballero1, Caballero caballero2) {
		this.id = id;
		this.fecha = fecha;
		this.caballero1 = caballero1;
		this.caballero2 = caballero2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Caballero getCaballero1() {
		return caballero1;
	}

	public void setCaballero1(Caballero caballero1) {
		this.caballero1 = caballero1;
	}

	public Caballero getCaballero2() {
		return caballero2;
	}

	public void setCaballero2(Caballero caballero2) {
		this.caballero2 = caballero2;
	}

	@Override
	public String toString() {
		return "Lucha [id=" + id + ", fecha=" + fecha + ", caballero1=" + caballero1 + ", caballero2=" + caballero2
				+ "]";
	}
	
	public Caballero lucha(Caballero caballero1, Caballero caballero2) {
		int fuerzaDeLuchaCab1;
		
		return caballero1;
		
	}
	
}
