package Redsociall;

/**
 * 
 */
public class Publicacion {
int idPub;
int idUser;
String texto;
String fecha;
DataPublicacion dp=new DataPublicacion();
public Publicacion () {

}
public boolean insertarPublicacion() {
	if(dp.insertarPublicacion(this)) {
		return true;
	}else {
		return false;
	}
}

public boolean eliminarPublicacion() {
	if	(dp.eliminarPublicacion(this.getIdPub())) {
	return true;
}else {
return false;	
}
}
public boolean actualizarPublicacion() {
	if	(dp.actualizarPublicacion(this)) {
	return true;
}else {
return false;	
}
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