package Redsociall;

public class Comentario {
int idCom;
int idPub;
int idUser;
String texto;
String fecha;
	DataComentario dp=new DataComentario();
	public Comentario() {
		
	}
	public boolean insertarComentario() {
		if(dp.insertarComentario(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarComentario() {
		if	(dp.actualizarComentario(this)) {
		return true;
	}else {
	return false;	
	}
	}
	public boolean eliminarComentario() {
		if	(dp.eliminarComentario(this.getIdPub())) {
		return true;
	}else {
	return false;	
	}
	}
	
	public int getIdCom() {
		return idCom;
	}
	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}
	public int getIdPub() {
		return idPub;
	}
	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
