package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;

public class GestorBBDD extends Conector{
	
	public ArrayList<Caballero> getCaballeros(){
		
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		
		String sql = "SELECT * FROM caballero";
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setExp(rs.getInt("exp"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setDestreza(rs.getInt("destreza"));
				caballero.setArma(getArma(rs.getInt("id_arma")));
				caballero.setEscudo(getEscudo(rs.getInt("id_escudo")));
				caballero.setCaballo(getCaballoXIdCaballero(caballero.getId()));
				caballero.setEscudero(getEscuderoXIdCaballero(caballero.getId()));
				
				caballeros.add(caballero);
			}
			
			return caballeros;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public ArrayList<Escudo> getEscudos(){
		
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		
		String sql = "SELECT * FROM escudos";
    
		try {
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setDefensa(rs.getDouble("defensa"));
				escudo.setPeso(rs.getDouble("peso"));
				
				escudos.add(escudo);
			}
			
			return escudos;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
  }
	
	public Escudo getEscudo(int idEscudo) {
		
		String sql = "SELECT * FROM escudos WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idEscudo);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setDefensa(rs.getDouble("defensa"));
				escudo.setPeso(rs.getDouble("peso"));
				
				return escudo;
			}
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un escudo con esa id");
		}
		
		return null;
		
	}
  
	public ArrayList<Arma> getArmas(){
		
		ArrayList<Arma> armas = new ArrayList<Arma>();
		
		String sql = "SELECT * FROM armas";
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		 
			while(rs.next()){
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setNombre(rs.getString("nombre"));
				arma.setDaño(rs.getDouble("daño"));
				arma.setPeso(rs.getDouble("peso"));
				
				armas.add(arma);
				
			}
			
			return armas;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public Arma getArma(int idArma) {
		
		String sql ="SELECT * FROM armas WHERE id=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idArma);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setNombre(rs.getString("nombre"));
				arma.setDaño(rs.getDouble("daño"));
				arma.setPeso(rs.getDouble("peso"));
			
				return arma;
			}	
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un arma con esa id");
		}
		
		return null;
		
	}
	
	public ArrayList<Caballo> getCaballos(){
		
		ArrayList<Caballo> caballos = new ArrayList<Caballo>();
		
		String sql = "SELECT * FROM caballos";
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Caballo caballo = new Caballo();
				caballo.setId(rs.getInt("id"));
				caballo.setNombre(rs.getString("Nombre"));
				caballo.setvMax(rs.getDouble("vMAx"));
				caballo.setResistencia(rs.getDouble("resistencia"));
				
				caballos.add(caballo);
				
			}
			
			return caballos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Caballo getCaballo(int idCaballo) {
		
		String sql ="SELECT * FROM caballos WHERE id=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idCaballo);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Caballo caballo = new Caballo();
				caballo.setId(rs.getInt("id"));
				caballo.setNombre(rs.getString("nombre"));
				caballo.setvMax(rs.getDouble("vMax"));
				caballo.setResistencia(rs.getDouble("resistencia"));

			
				return caballo;
			}	
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un caballo con esa id");
		}
		
		return null;
		
	}
	
	public ArrayList<Escudero> getEscuderos(){
		
		ArrayList<Escudero> escuderos = new ArrayList<Escudero>();
		
		String sql = "SELECT * FROM escuderos";
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Escudero escudero = new Escudero();
				escudero.setId(rs.getInt("id"));
				escudero.setNombre(rs.getString("nombre"));
				escudero.setExp(rs.getInt("experiencia"));
				escudero.setFortaleza(rs.getDouble("fortaleza"));
				
				escuderos.add(escudero);
			}
			
			return escuderos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public Escudero getEscudero(int idEscudero) {
		
		String sql ="SELECT * FROM escuderos WHERE id=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idEscudero);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Escudero escudero = new Escudero();
				escudero.setId(rs.getInt("id"));
				escudero.setNombre(rs.getString("nombre"));
				escudero.setExp(rs.getInt("experiencia"));
				escudero.setFortaleza(rs.getDouble("fortaleza"));
			
				return escudero;
			}	
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un escudero con esa id");
		}
		
		return null;
		
	}
	
	public Caballero getCaballero(int idCaballero) {
		
		String sql ="SELECT * FROM caballero WHERE id=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idCaballero);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setExp(rs.getInt("exp"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setDestreza(rs.getInt("destreza"));
				caballero.setArma(getArma(rs.getInt("id_arma")));
				caballero.setEscudo(getEscudo(rs.getInt("id_escudo")));
				caballero.setCaballo(getCaballoXIdCaballero(caballero.getId()));
				caballero.setEscudero(getEscuderoXIdCaballero(caballero.getId()));
				return caballero;
			}	
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un caballero con esa id");
		}
		
		return null;
		
	}
	
	public void insertarCaballero(Caballero caballero) {
		
		String sql ="INSERT INTO caballero (nombre,exp,fuerza,destreza,id_arma,id_escudo) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getExp());
			pst.setInt(3, caballero.getFuerza());
			pst.setInt(4, caballero.getDestreza());
			pst.setInt(5, caballero.getArma().getId());
			pst.setInt(6, caballero.getEscudo().getId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void insertarEscudo(Escudo escudo) {
		
		String sql ="INSERT INTO escudos (nombre,defensa,peso) VALUES (?,?,?)";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, escudo.getNombre());
			pst.setDouble(2, escudo.getDefensa());
			pst.setDouble(3, escudo.getPeso());
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
  }
  
	public void insertarArmas(Arma arma) {
		
		String sql = "INSERT INTO armas (nombre,daño,peso) VALUES (?,?,?)";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, arma.getNombre());
			pst.setDouble(2, arma.getDaño());
			pst.setDouble(3, arma.getPeso());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertarCaballos(Caballo caballo, int idCaballero) {
		
		String sql = "INSERT INTO caballos (Nombre,vMax,resistencia,id_caballero) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, caballo.getNombre());
			pst.setDouble(2, caballo.getvMax());
			pst.setDouble(3, caballo.getResistencia());
			pst.setInt(4, idCaballero);
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertarEscuderos(Escudero escudero, int idCaballero) {
		
		String sql = "INSERT INTO escuderos (Nombre,experiencia,fortaleza,id_caballero) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, escudero.getNombre());
			pst.setInt(2, escudero.getExp());
			pst.setDouble(3, escudero.getFortaleza());
			pst.setInt(4, idCaballero);
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminarCaballero(int idCaballero) {
		
		String sql ="DELETE FROM caballero WHERE id = ?";
		
		boolean salir = false;
		
		while(!salir) {
			try {
				PreparedStatement pst = cn.prepareStatement(sql);
				pst.setInt(1, idCaballero);
				
				pst.execute();
				salir=true;
			} catch (SQLException e) {
				String respuesta = Formulario.yesOrNo();
				if (respuesta.equalsIgnoreCase("N")) {
					System.out.println("No se ha borrado el caballero");
					salir=true;
				} else {
					eliminarLuchaXIDParticipante(idCaballero);
				}
			}
		}
	}
	
	public void eliminarLuchaXIDParticipante(int idCaballero) {
		String sql = "DELETE FROM luchas WHERE id_ganador = ? OR id_perdedor = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idCaballero);
			pst.setInt(2, idCaballero);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado una lucha asociada a esa id");
		}
		System.out.println("Lo ha hecho correctamente");
	}

	public void eliminarEscudo(int idEscudo) {
		
		String sql = "DELETE FROM escudos WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idEscudo);
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("No puedes eliminar un escudo con un caballero usándolo");
		}
	}
	
	public void eliminarArma(int idArma) {
		
		String sql = "DELETE FROM armas WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idArma);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("No puedes eliminar un arma con un caballero usándolo");
		}
		
	}
	
	public void eliminarCaballo(int idCaballo) {
		
		String sql = "DELETE FROM caballos WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idCaballo);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un caballo con esa id");
		}
	}
	
	public void eliminarEscudero(int idEscudero) {
		
		String sql = "DELETE FROM escuderos WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idEscudero);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un escudero con esa id");
		}
	}
	
	public void modificarCaballero(Caballero caballero, int idCaballero) {
		
		String sql ="UPDATE caballero SET nombre = ?, exp = ?, fuerza=?, destreza=?, id_arma=?,id_escudo=? WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getExp());
			pst.setInt(3, caballero.getFuerza());
			pst.setInt(4, caballero.getDestreza());
			pst.setInt(5, caballero.getArma().getId());
			pst.setInt(6, caballero.getEscudo().getId());
			pst.setInt(7, idCaballero);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un caballero con esa id");
		}
	}
	
	public void modificarEscudo(Escudo escudo, int idEscudo) {
		
		String sql = "UPDATE escudos SET nombre=?, defensa=?, peso=? WHERE id =?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, escudo.getNombre());
			pst.setDouble(2, escudo.getDefensa());
			pst.setDouble(3, escudo.getPeso());
			pst.setInt(4, idEscudo);
			
			pst.executeUpdate();
      
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un escudo con esa id");
		}
	}
	
	public void modificarArma(Arma arma, int idArma) {
		
		String sql = "UPDATE armas SET nombre=?, daño=?,peso=? WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, arma.getNombre());
			pst.setDouble(2, arma.getDaño());
			pst.setDouble(3, arma.getPeso());
			pst.setInt(4, idArma);
			
			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("No se ha encontrado un arma con esa id");
		}
	}
	
	public void modificarCaballos(Caballo caballo, int idCaballo) {
		
		String sql = "UPDATE caballos SET nombre=?, vMax=?,resistencia=? WHERE id=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, caballo.getNombre());
			pst.setDouble(2, caballo.getvMax());
			pst.setDouble(3, caballo.getResistencia());
			pst.setInt(4, idCaballo);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un caballo con esa id");
		}
	}
	
	public void modificarEscuderos(Escudero escudero, int idEscudero) {
		
		String sql = "UPDATE escuderos SET nombre=?, experiencia=?,fortaleza=? WHERE id=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, escudero.getNombre());
			pst.setDouble(2, escudero.getExp());
			pst.setDouble(3, escudero.getFortaleza());
			pst.setInt(4, idEscudero);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un escudero con esa id");
		}
	}

	public ArrayList<Lucha> getLuchas() {

		ArrayList<Lucha> luchas = new ArrayList<Lucha>();
		
		String sql = "SELECT * FROM luchas";
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		 
			while(rs.next()){
				Lucha lucha = new Lucha();
				lucha.setId(rs.getInt("id"));
				lucha.setFecha(rs.getDate("fecha"));
				lucha.setGanador(getCaballero(rs.getInt("id_ganador")));
				lucha.setPerdedor(getCaballero(rs.getInt("id_perdedor")));
				
				luchas.add(lucha);
				
			}
			
			return luchas;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void insertarLucha(Lucha lucha) {
		String sql = "INSERT INTO luchas (fecha,id_ganador,id_perdedor) VALUES (?,?,?)";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setDate(1, new java.sql.Date(lucha.getFecha().getTime()));
			pst.setInt(2, lucha.getGanador().getId());
			pst.setInt(3, lucha.getPerdedor().getId());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void eliminarLucha(int idLucha) {
		String sql = "DELETE FROM luchas WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idLucha);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado una lucha con esa id");
		}
		
	}

	public void modificarLucha(Lucha lucha, int idLucha) {
		String sql = "UPDATE luchas SET fecha=?, id_ganador=?, id_perdedor=? WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setDate(1, new java.sql.Date(lucha.getFecha().getTime()));
			pst.setInt(2, lucha.getGanador().getId());
			pst.setInt(3, lucha.getPerdedor().getId());
			pst.setInt(4, idLucha);
			
			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("No se ha encontrado una lucha con esa id");
		}
	}

	public Lucha getLucha(int idLucha) {
		
		String sql ="SELECT * FROM luchas WHERE id=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idLucha);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Lucha lucha = new Lucha();
				lucha.setId(rs.getInt("id"));
				lucha.setFecha(rs.getDate("fecha"));
				lucha.setGanador(getCaballero(rs.getInt("id_ganador")));
				lucha.setPerdedor(getCaballero(rs.getInt("id_perdedor")));
				return lucha;
			}	
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado una lucha con esa id");
		}
		
		return null;
	}
	
	public Caballo getCaballoXIdCaballero(int idCaballero) {
		String sql = "SELECT * FROM caballos WHERE id_caballero = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idCaballero);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Caballo caballo = new Caballo();
				caballo.setId(rs.getInt("id"));
				caballo.setNombre(rs.getString("nombre"));
				caballo.setvMax(rs.getDouble("vMax"));
				caballo.setResistencia(rs.getDouble("resistencia"));
				
				return caballo;
			}
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un caballo con esa id");
		}
		
		return null;
	}
	
	public Escudero getEscuderoXIdCaballero(int idCaballero) {
		String sql = "SELECT * FROM escuderos WHERE id_caballero = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idCaballero);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Escudero escudero = new Escudero();
				escudero.setId(rs.getInt("id"));
				escudero.setNombre(rs.getString("nombre"));
				escudero.setExp(rs.getInt("experiencia"));
				escudero.setFortaleza(rs.getDouble("fortaleza"));
				
				return escudero;
			}
			
		} catch (SQLException e) {
			System.out.println("No se ha encontrado un escudero con esa id");
		}
		
		return null;
	}
}
