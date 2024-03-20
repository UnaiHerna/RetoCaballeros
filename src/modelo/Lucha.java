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
		//Ganador y perdedor son nombres temporales, realmente luego se van a reasignar.
		
		//Si no tienen escudero, porcentaje para crearlo
		if(ganador.getEscudero()==null){
			porcentajeCrearEscudero(ganador);
		}
		if(perdedor.getEscudero()==null){
			porcentajeCrearEscudero(perdedor);
		}
		
		//Decide el ganador de la lucha
		if(perdedor.getFuerzaDeLucha()>=ganador.getFuerzaDeLucha()) {
			Caballero cabAuxiliar = ganador;
			setGanador(perdedor);
			setPerdedor(cabAuxiliar);
		}
		
		System.out.println("El ganador es...");
		System.out.println("¡¡¡"+ganador.getNombre()+"!!!\n");
		//Otorga experiencia de combate al ganador
		ganador.setExp(ganador.getExp()+2);
		
		if(ganador.getEscudero()!=null){
			//Posible subida de rango
			ganador.getEscudero().setExp(ganador.getEscudero().getExp()+2);
			subidaRango(ganador.getEscudero());
		}
	}

	public void porcentajeCrearEscudero(Caballero caballero) {
		// Crear un objeto de la clase Random
        Random rand = new Random();
        // Generar un número aleatorio en el rango del 1 al 5
        int numeroAleatorio = rand.nextInt(5) + 1;
        
        if (numeroAleatorio==1) {
        	System.out.println("A "+caballero.getNombre()+" se le ha asignado un escudero nuevo");
        	GestorBBDD gestorBBDD = new GestorBBDD();
        	Escudero escudero = Formulario.introducirDatosEscuderoSinExp();
        	caballero.setEscudero(escudero);
			gestorBBDD.insertarEscuderos(escudero, caballero.getId());
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
				
			System.out.println("El escudero va a ascender a caballero, dime el id del arma que quieres que utilice\n");
			Visor.visualizarArmas(gestorBBDD.getArmas());
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
