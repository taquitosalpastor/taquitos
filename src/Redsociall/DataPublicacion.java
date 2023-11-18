package Redsociall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataPublicacion {
	 Connection cx;
	 
	 public DataPublicacion() {
		 
	 }
	 public Connection conectar() {
			try {
				cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/redsocial3","root","");
				System.out.println("CONEXION EXITOSA");
			} catch (SQLException e) {
				System.out.println("FALLO CONEXION");
				e.printStackTrace();
			}
			return cx;
			
		    }
	 public boolean insertarPublicacion(Publicacion p) {
		 PreparedStatement ps;
			try {
			ps=conectar().prepareStatement("INSERT INTO publicacion VALUES(null,?,?,null)");
			ps.setInt(1,p.getIdUser());
			ps.setString(2,p.getTexto());
			ps.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	 }

public ArrayList<Publicacion> selectPublicaciones(){
	ArrayList<Publicacion> listaPublicaciones=new ArrayList<Publicacion>();
	try {
		PreparedStatement ps=conectar().prepareStatement("SELECT * FROM publicacion");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Publicacion x = new Publicacion();
			x.setIdPub(rs.getInt(1));
			x.setIdUser(rs.getInt(2));
			x.setTexto(rs.getString(3));
			x.setFecha(rs.getString(4));
			listaPublicaciones.add(x);
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return listaPublicaciones;
}

public boolean eliminarPublicacion(int idpub) {
	 PreparedStatement ps;
		try {
		ps=conectar().prepareStatement("DELETE FROM publicacion WHERE idpub=?");
		ps.setInt(1,idpub);
		ps.execute();
		return true;
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	 
}

public boolean actualizarPublicacion(Publicacion p) {
	 PreparedStatement ps;
		try {
		ps=conectar().prepareStatement("UPDATE publicacion SET iduser=?,texto=? WHERE idpub=?");
		ps.setInt(1,p.getIdUser());
		ps.setString(2,p.getTexto());
		ps.setInt(3,p.getIdPub());
		ps.execute();
		return true;
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	} 
	 
}
}