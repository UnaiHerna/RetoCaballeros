package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;

public class GestorBBDD extends Conector{
	
	public ArrayList<Arma> getArmas(){
		
		ArrayList<Arma> armas = new ArrayList<Arma>();
		
		String sql = "SELECT * FROM armas";
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Arma arma = new Arma();
				arma.setNombre(rs.getString("nombre"));
				arma.setDaño(rs.getDouble("daño"));
				arma.setPeso(rs.getDouble("peso"));
				
				armas.add(arma);
				
			}
			
			return armas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarArma(Arma arma) {
		
		String sql = "UPDATE armas SET nombre=?, daño=?,peso=? WHERE id = ?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, arma.getNombre());
			pst.setDouble(2, arma.getDaño());
			pst.setDouble(3, arma.getPeso());
			
			pst.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
