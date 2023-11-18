package CCelular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataCelular {
Connection cx;
public Connection Conectar() {
	try {
		cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/celulares","root","");
				System.out.println("CONEXION EXITOSA");
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return cx;
}
public boolean insertarCel(Celular c) {
	PreparedStatement ps=null;
	try {
		ps=Conectar().prepareStatement("INSERT INTO celulares VALUES(?,?,?,?,?)");
		ps.setInt(1,c.getIdcel());
		ps.setString(2,c.getMarca());
		ps.setString(3, c.getModelo());
		ps.setString(4,c.getSistema());
		ps.setString(5, c.getProcesador());
		ps.execute();
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
	}
	public boolean cargarCel(Celular c) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=Conectar().prepareStatement("SELECT * FROM celulares WHERE idcel=?");
			ps.setInt(1,c.getIdcel());
			rs=ps.executeQuery();
			if(rs.next()) {
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setProcesador(rs.getString(4));
				c.setSistema(rs.getString(5));
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
}
	public boolean eliminarCel(int idcel) {
		PreparedStatement ps=null;
		try {
			Celular x=new Celular();
			x.setIdcel(idcel);
			if(x.cargaCel()) {
				ps=Conectar().prepareStatement("DELETE FROM celulares WHERE idcel=?");
				ps.setInt(1, idcel);
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
	public boolean actualizarCel(Celular c) {
		PreparedStatement ps=null;
		try {
			Celular x=new Celular();
			x.setIdcel(c.getIdcel());
			if(x.cargaCel()) {
				ps=Conectar().prepareStatement("UPDATE  celulares SET marca=?,modelo=?,sistema=?,procesador=?"
						+"WHERE idCel=? ");
				
				
				ps.setString(1,c.getMarca());
				ps.setString(2, c.getModelo());
				ps.setString(3,c.getSistema());
				ps.setString(4, c.getProcesador());
				ps.setInt(5,c.getIdcel());
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
	public ArrayList<Celular> selectCelulares() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Celular> listaCelulares=new ArrayList<Celular>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM celulares");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Celular c=new Celular();
                c.setIdcel(rs.getInt(1));
                c.setMarca(rs.getString(2));
                c.setModelo(rs.getString(3));
                c.setSistema(rs.getString(4));
                c.setProcesador(rs.getString(5));
                listaCelulares.add(c);
            }
        } catch (Exception e) {
        }
        return listaCelulares;
    }
}
