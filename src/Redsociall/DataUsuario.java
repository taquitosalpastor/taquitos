package Redsociall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import miprimercrud.Alumno;

public class DataUsuario {
 Connection cx;
 
 public DataUsuario() {
	 
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
 public boolean insertarUsuario(Usuario u) {
	 PreparedStatement ps;
		try {
		ps=conectar().prepareStatement("Insert Into usuario Values(null,?,?,?,?)");
		ps.setString(1,u.getCorreo());
		ps.setString(2,u.getTelefono());
		ps.setString(3,u.getPassword());
		ps.setString(4,u.getNombre());
		ps.execute();
		return true;
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
 }
public boolean login (Usuario x) {
	try {
		PreparedStatement ps= conectar().prepareStatement("SELECT * FROM usuario WHERE correo=? AND password=?");
		ps.setString(1, x.getCorreo());
		ps.setString(2, x.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			x.setIdUser(rs.getInt(1));
			x.setCorreo(rs.getString(2));
			x.setTelefono(rs.getString(3));
			x.setPassword(rs.getString(4));
			x.setNombre(rs.getString(5));
			return true;
		}else {
			return false;
		}
	} catch (Exception e) {
		return false;
	}
}

public ArrayList<Usuario> selectUsuarios(){
	ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
	try {
		PreparedStatement ps=conectar().prepareStatement("SELECT * From usuario");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Usuario x = new Usuario();
			x.setIdUser(rs.getInt(1));
			x.setCorreo(rs.getString(2));
			x.setTelefono(rs.getString(3));
			x.setPassword(rs.getString(4));
			x.setNombre(rs.getString(5));
			listaUsuarios.add(x);
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return listaUsuarios;
}

public boolean eliminarUsuario(int id) {
	 PreparedStatement ps;
		try {
		ps=conectar().prepareStatement("DELETE FROM usuario WHERE iduser=?");
		ps.setInt(1,id);
		ps.execute();
		return true;
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	 
}

public boolean actualizarUsuario(Usuario u) {
	 PreparedStatement ps;
		try {
		ps=conectar().prepareStatement("UPDATE usuario SET correo=?,telefono=?,password=?,nombre=? WHERE iduser=?");
		ps.setString(1,u.getCorreo());
		ps.setString(2,u.getTelefono());
		ps.setString(3,u.getPassword());
		ps.setString(4,u.getNombre());
		ps.setInt(5,u.getIdUser());
		ps.execute();
		return true;
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	} 
	 
}
}
