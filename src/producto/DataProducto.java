package producto;

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
	
	public boolean insertarProducto(Producto c) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1,c.getIdproducto());
			ps.setString(2,c.getNombre());
			ps.setString(3, c.getProvedor());
			ps.setString(4,c.getPrecio());
			ps.setString(5, c.getExistencia());
			ps.setString(6, c.getDescripcion());
			ps.setString(7, c.getUnidad());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		}
	public boolean cargarProducto(Producto c) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=Conectar().prepareStatement("SELECT * FROM producto WHERE idproducto=?");
			ps.setInt(1,c.getIdproducto());
			rs=ps.executeQuery();
			if(rs.next()) {
				c.setNombre(rs.getString(2));
				c.setProvedor(rs.getString(3));
				c.setPrecio(rs.getString(4));
				c.setExistencia(rs.getString(5));
				c.setDescripcion(rs.getString(6));
				c.setUnidad(rs.getString(7));
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
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
	public boolean actualizarProducto(Producto c) {
		PreparedStatement ps=null;
		try {
			Producto x=new Producto();
			x.setIdproducto(c.getIdproducto());
			if(x.cargarProducto()) {
				ps=Conectar().prepareStatement("UPDATE producto SET nombre=?,provedor=?,precio=?,existencia=?,descripcion=?,unidad=?"
						+"WHERE idproducto=? ");
				
				
				ps.setString(1,c.getNombre());
				ps.setString(2, c.getProvedor());
				ps.setString(3,c.getPrecio());
				ps.setString(4, c.getExistencia());
				ps.setString(5, c.getDescripcion());
				ps.setString(6, c.getUnidad());
				ps.setInt(7,c.getIdproducto());
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

}
