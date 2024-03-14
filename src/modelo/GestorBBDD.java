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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public Caballero getCaballero(int idCaballero) {
		
		String sql ="SELECT * FROM caballeros WHERE id=?";
		
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
				caballero.setDestreza(rs.getInt("fuerza"));
				caballero.setArma(getArma(rs.getInt("id_arma")));
				caballero.setEscudo(getEscudo(rs.getInt("id_escudo")));
				return caballero;
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public void eliminarCaballero(int idCaballero) {
		
		String sql ="DELETE FROM caballero WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idCaballero);
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarEscudo(int idEscudo) {
		
		String sql = "DELETE FROM escudos WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idEscudo);
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarArma(int idArma) {
		
		String sql = "DELETE FROM armas WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, idArma);
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
}
