package ProductoG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DataProducto {
Connection cx;
	
	public Connection Conectar() {
		try {
			cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/producto","root","");
					System.out.println("CONEXION EXITOSA");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cx;
	}
	
	public boolean insertarProducto(Producto p) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1,p.getIdproducto());
			ps.setString(2,p.getNombre());
			ps.setString(3, p.getProvedor());
			ps.setString(4,p.getPrecio());
			ps.setString(5, p.getExistencia());
			ps.setString(6, p.getDescripcion());
			ps.setString(7, p.getUnidad());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		}

	public boolean eliminarProducto(int idproducto) {
		PreparedStatement ps=null;
		try {
			Producto x=new Producto();
			x.setIdproducto(idproducto);
			if(x.cargarProducto()) {
				ps=Conectar().prepareStatement("DELETE FROM producto WHERE idproducto=?");
				ps.setInt(1, idproducto);
				ps.execute();
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean actualizarProducto(Producto p) {
		PreparedStatement ps=null;
		try {
			Producto x=new Producto();
			x.setIdproducto(p.getIdproducto());
			if(x.cargarProducto()) {
				ps=Conectar().prepareStatement("UPDATE producto SET nombre=?,provedor=?,precio=?,existencia=?,descripcion=?,unidad=?"
						+"WHERE idproducto=? ");
				
				
				ps.setString(1,p.getNombre());
				ps.setString(2, p.getProvedor());
				ps.setString(3,p.getPrecio());
				ps.setString(4, p.getExistencia());
				ps.setString(5, p.getDescripcion());
				ps.setString(6, p.getUnidad());
				ps.setInt(7,p.getIdproducto());
				ps.execute();
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean cargarProducto(Producto p) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=Conectar().prepareStatement("SELECT * FROM producto WHERE idproducto=?");
			ps.setInt(1,p.getIdproducto());
			rs=ps.executeQuery();
			if(rs.next()) {
				p.setNombre(rs.getString(2));
				p.setProvedor(rs.getString(3));
				p.setPrecio(rs.getString(4));
				p.setExistencia(rs.getString(5));
				p.setDescripcion(rs.getString(6));
				p.setUnidad(rs.getString(7));
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
}
}

