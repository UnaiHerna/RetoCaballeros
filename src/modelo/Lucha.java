package modelo;

import java.util.Date;
import java.util.Random;

public class Lucha {
	private int id;
	private Date fecha;
	private Caballero caballero1;
	private Caballero caballero2;
	
	public Lucha() {}

	public Lucha(Date fecha, Caballero caballero1, Caballero caballero2) {
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
		return id + "." + " Fecha: " + fecha + ", 1.Caballero: " + caballero1.getNombre() + ", 2.Caballero: " + caballero2.getNombre();
	}
	
	public Caballero comienzoLucha() {
		Random randomizador = new Random();
		double numAleatorio = randomizador.nextDouble(1)/10;
		double numAleatorio2 = randomizador.nextDouble(1)/10;
		//System.out.println(numAleatorio);
		//System.out.println(numAleatorio2);
		
		//Ataque y defensa Cab1
		double ataqueCab1 = (caballero1.getFuerza()+caballero1.getDestreza()*2+caballero1.getArma().getDaño())-
				caballero1.getArma().getPeso()+caballero1.getEscudo().getPeso();
		//System.out.println(ataqueCab1);
		
		double defensaCab1 = (caballero1.getFuerza()+caballero1.getEscudo().getDefensa()/2);
		//System.out.println(defensaCab1);
		
		//Ataque y defensa Cab2
		double ataqueCab2 = (caballero2.getFuerza()+caballero2.getDestreza()*2+caballero2.getArma().getDaño())-
				caballero2.getArma().getPeso()+caballero2.getEscudo().getPeso();
		//System.out.println(ataqueCab2);
		
		double defensaCab2 = (caballero2.getFuerza()+caballero2.getEscudo().getDefensa()/2);
		//System.out.println(defensaCab2);
		
		//Fuerza de lucha de los caballeros
		double fuerzaDeLuchaCab1 = (ataqueCab1-defensaCab2)*(numAleatorio*caballero1.getExp());
		//System.out.println("Fuerza lucha: "+fuerzaDeLuchaCab1);
		
		double fuerzaDeLuchaCab2 = (ataqueCab2-defensaCab1)*(numAleatorio2*caballero2.getExp());
		//System.out.println("Fuerza lucha: "+fuerzaDeLuchaCab2);
		
		//Decide el ganador de la lucha
		if(fuerzaDeLuchaCab1>=fuerzaDeLuchaCab2) {
			return caballero1;
		}else {
			return caballero2;
		}
		
	}
	
}
