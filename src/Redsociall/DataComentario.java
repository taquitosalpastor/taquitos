package Redsociall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataComentario {
	 Connection cx;
	 
	 public DataComentario() {
		 
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
	 public boolean insertarComentario(Comentario p) {
		 PreparedStatement ps;
			try {
			ps=conectar().prepareStatement("Insert Into comentario Values(null,?,?,?,null)");
			ps.setInt(1,p.getIdPub());
			ps.setInt(2,p.getIdUser());
			ps.setString(3,p.getTexto());
			ps.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	 }


	public ArrayList<Comentario> selectComentarios(){
		ArrayList<Comentario> listaComentario=new ArrayList<Comentario>();
		try {
			PreparedStatement ps=conectar().prepareStatement("SELECT * From comentario");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Comentario x = new Comentario();
				x.setIdCom(rs.getInt(1));
				x.setIdPub(rs.getInt(2));
				x.setIdUser(rs.getInt(3));
				x.setTexto(rs.getString(4));
				x.setFecha(rs.getString(5));
				listaComentario.add(x);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return listaComentario;
	}

	public boolean eliminarComentario(int idpub) {
		 PreparedStatement ps;
			try {
			ps=conectar().prepareStatement("DELETE FROM comentario WHERE id=?");
			ps.setInt(1,idpub);
			ps.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		 
	}

	public boolean actualizarComentario(Comentario p) {
		 PreparedStatement ps;
			try {
			ps=conectar().prepareStatement("UPDATE comentario SET iduser=?,idpub=?,texto=? WHERE id=?");
			ps.setInt(1,p.getIdUser());
			ps.setInt(2,p.getIdPub());
			ps.setString(3,p.getTexto());
			ps.setInt(4,p.getIdCom());
			ps.execute();
		
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		 
	}
	}
