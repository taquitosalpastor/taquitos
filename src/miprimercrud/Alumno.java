package miprimercrud;

public class Alumno {
int id;
String numcontrol;
String apellidop;
String Nombre;
String apellidom;
String curp;
String fecha;
String direccion;
String telefono;
String correo;
String grupo;
String carrea;
DataAlumno da=new DataAlumno();

public boolean insertarAlumno() {
	if(da.insertarAlumno(this)) {
		return true;
	}else {
		return false;
	}
	
}
public boolean eliminarAlumno() {
	if(da.eliminarAlumno(this.getId())) {
		return true;
	}else {
		return false;
	}
	
}
public boolean ActualizarAlumno() {
	if(da.ActualizarAlumno(this)) {
		return true;
	}else {
		return false;
	}
	
}

public Alumno() {

}


public Alumno(int id, String numcontrol, String apellidop,String Nombre, String apellidom, String curp, String fecha,
		String direccion, String telefono, String correo, String grupo, String carrea) {

	this.id = id;
	this.numcontrol = numcontrol;
	this.apellidop = apellidop;
	this.Nombre=Nombre;
	this.apellidom = apellidom;
	this.curp = curp;
	this.fecha = fecha;
	this.direccion = direccion;
	this.telefono = telefono;
	this.correo = correo;
	this.grupo = grupo;
	this.carrea = carrea;
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getNumcontrol() {
	return numcontrol;
}


public void setNumcontrol(String numcontrol) {
	this.numcontrol = numcontrol;
}


public String getApellidop() {
	return apellidop;
}


public void setApellidop(String apellidop) {
	this.apellidop = apellidop;
}
public String getNombre() {
	return Nombre;
}


public void setNombre(String Nombre) {
	this.Nombre = Nombre;
}

public String getApellidom() {
	return apellidom;
}


public void setApellidom(String apellidom) {
	this.apellidom = apellidom;
}


public String getCurp() {
	return curp;
}


public void setCurp(String curp) {
	this.curp = curp;
}


public String getFecha() {
	return fecha;
}


public void setFecha(String fecha) {
	this.fecha = fecha;
}


public String getDireccion() {
	return direccion;
}


public void setDireccion(String direccion) {
	this.direccion = direccion;
}


public String getTelefono() {
	return telefono;
}


public void setTelefono(String telefono) {
	this.telefono = telefono;
}


public String getCorreo() {
	return correo;
}


public void setCorreo(String correo) {
	this.correo = correo;
}


public String getGrupo() {
	return grupo;
}


public void setGrupo(String grupo) {
	this.grupo = grupo;
}


public String getCarrea() {
	return carrea;
}


public void setCarrea(String carrea) {
	this.carrea = carrea;
}







}
