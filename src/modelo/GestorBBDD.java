package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;

public class GestorBBDD extends Conector{
	
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
