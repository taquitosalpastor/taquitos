package miprimercrud;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAlumno {
	Connection cx;

	public static void main(String[] args) {
		DataAlumno da = new DataAlumno();
		da.conectar();
	}
	
	public DataAlumno() {
		
	}
	
public Connection conectar() {
	try {
		cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/alumno","root","");
		System.out.println("CONEXION EXITOSA");
	} catch (SQLException e) {
		System.out.println("FALLO CONEXION");
		e.printStackTrace();
	}
	return cx;
	
    }
public boolean insertarAlumno(Alumno a) {
	PreparedStatement ps;
	try {
	ps=conectar().prepareStatement("Insert Into Alumno Values(null,?,?,?,?,?,?,?,?,?,?,?)");
	ps.setString(1,a.getNumcontrol());
	ps.setString(2,a.getNombre());
	ps.setString(3,a.getApellidom());
	ps.setString(4,a.getApellidop());
	ps.setString(5,a.getCurp());
	ps.setString(6,a.getFecha());
	ps.setString(7,a.getDireccion());
	ps.setString(8,a.getTelefono());
	ps.setString(9,a.getCorreo());
	ps.setString(10,a.getGrupo());
	ps.setString(11,a.getCarrea());
	ps.execute();
	return true;
}catch (SQLException e) {
	e.printStackTrace();
	return false;
}
	
}


public ArrayList<Alumno> selctAlumnos(){
	ArrayList<Alumno> listaAlumno=new ArrayList<Alumno>();
	try {
		PreparedStatement ps=conectar().prepareStatement("SELECT * From ALUMNO");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Alumno x = new Alumno();
			x.setId(rs.getInt(1));
			x.setNumcontrol(rs.getString(2));
			x.setNombre(rs.getString(3));
			x.setApellidom(rs.getString(4));
			x.setApellidop(rs.getString(5));
			x.setFecha(rs.getString(6));
			x.setCurp(rs.getString(7));
			x.setDireccion(rs.getString(8));
			x.setTelefono(rs.getString(9));
			x.setCorreo(rs.getString(10));
			x.setGrupo(rs.getString(11));
			x.setCarrea(rs.getString(12));
			listaAlumno.add(x);
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return listaAlumno;
}
public boolean eliminarAlumno(int id) {
	PreparedStatement ps;
	try {
	ps=conectar().prepareStatement("DELETE FROM alumno WHERE id=?");
	ps.setInt(1,id);
	ps.execute();
	return true;
}catch (SQLException e) {
	e.printStackTrace();
	return false;
}
	
}
public boolean ActualizarAlumno(Alumno a) {
	PreparedStatement ps;
	try {
	ps=conectar().prepareStatement("UPDATE alumno SET numControl=?,Nombre=?,Am=?,Ap=?,FechaN=?,Curp=?,direccion=?,telefono=?,"
			+ "correo=?,grupo=?,carrera=? WHERE id=?");
	ps.setString(1,a.getNumcontrol());
	ps.setString(2,a.getNombre());
	ps.setString(3,a.getApellidom());
	ps.setString(4,a.getApellidop());
	ps.setString(5,a.getCurp());
	ps.setString(6,a.getFecha());
	ps.setString(7,a.getDireccion());
	ps.setString(8,a.getTelefono());
	ps.setString(9,a.getCorreo());
	ps.setString(10,a.getGrupo());
	ps.setString(11,a.getCarrea());
	ps.setInt(12,a.getId());
	ps.execute();
	return true;
}catch (SQLException e) {
	e.printStackTrace();
	return false;
}
	
}
}
