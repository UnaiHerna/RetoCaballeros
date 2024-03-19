package modelo;

import java.util.*;

import vista.Visor;

public class Lucha {
	private int id;
	private Date fecha;
	private Caballero ganador;
	private Caballero perdedor;
	
	public Lucha() {}

	public Lucha(Date fecha, Caballero caballero1, Caballero caballero2) {
		this.fecha = fecha;
		this.ganador = caballero1;
		this.perdedor = caballero2;
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

	public Caballero getGanador() {
		return ganador;
	}

	public void setGanador(Caballero caballero1) {
		this.ganador = caballero1;
	}

	public Caballero getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(Caballero caballero2) {
		this.perdedor = caballero2;
	}

	@Override
	public String toString() {
		return id + "." + " Fecha: " + fecha + ", Ganador: " + ganador.getNombre() + ", Perdedor: " + perdedor.getNombre();
	}
	
	public void comienzoLucha() {
		
		//Decide el ganador de la lucha, ganador y perdedor tienen esos nombres, pero es temporal
		if(perdedor.getFuerzaDeLucha()>=ganador.getFuerzaDeLucha()) {
			Caballero cabAuxiliar = ganador;
			this.setGanador(perdedor);
			this.setPerdedor(cabAuxiliar);
		}
		
		System.out.println("El ganador es...");
		System.out.println("¡¡¡"+this.ganador.getNombre()+"!!!");
		
		if(ganador.getEscudero()!=null){
			//Posible subida de rango
			ganador.getEscudero().setExp(ganador.getEscudero().getExp()+2);
			subidaRango(ganador.getEscudero());
		}else {
			// Crear un objeto de la clase Random
	        Random rand = new Random();
	        // Generar un número aleatorio en el rango del 1 al 5
	        int numeroAleatorio = rand.nextInt(5) + 1;
	        
	        if (numeroAleatorio==1) {
	        	GestorBBDD gestorBBDD = new GestorBBDD();
	        	Escudero escudero = Formulario.introducirDatosEscudero();
				gestorBBDD.insertarEscuderos(escudero, ganador.getId());
	        }
		}
		
	}

	public void subidaRango(Escudero escudero) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		GestorBBDD gestorBBDD = new GestorBBDD();
		if(escudero.getExp()>=10) {
			Caballero caballero = new Caballero();
			caballero.setNombre(escudero.getNombre());
			caballero.setExp(1);
			caballero.setDestreza(5);
			caballero.setFuerza(5);
				
			Visor.visualizarArmas(gestorBBDD.getArmas());
			System.out.println("\nEl escudero va a ascender a caballero, dime el id del arma que quieres que utilice");
			caballero.setArma(gestorBBDD.getArma(Integer.parseInt(scanner.nextLine())));
				
				
			Visor.visualizarEscudos(gestorBBDD.getEscudos());
			System.out.println("\nDime el id del escudo que quieres que utilice");
			caballero.setEscudo(gestorBBDD.getEscudo(Integer.parseInt(scanner.nextLine())));
						
			gestorBBDD.insertarCaballero(caballero);
			gestorBBDD.eliminarEscudero(escudero.getId());
			
		}else {
			gestorBBDD.modificarEscuderos(escudero, escudero.getId());
		}
		
	}
	
}
