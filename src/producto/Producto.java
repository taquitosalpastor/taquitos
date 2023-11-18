package producto;


public class Producto {
int idproducto;
String nombre;
String provedor;
String precio;
String existencia;
String descripcion;
String unidad;
DataProducto dc=new DataProducto();

public boolean insertarProducto() {
	if(dc.insertarProducto(this)) {
		return true;
	}
	return false;
}

public boolean eliminarProducto() {
	if(dc.eliminarProducto(this.getIdproducto())) {
		return true;
	}
	return false;
	
}

public boolean actualizarProducto() {
	if(dc.actualizarProducto(this)) {
		return true;
	}
	return false;
	
}
public boolean cargarProducto() {
	if(dc.cargarProducto(this)) {
		return true;
	}
	return false;
}
public Producto(){
	
}
public int getIdproducto() {
	return idproducto;
}
public void setIdproducto(int idproducto) {
	this.idproducto = idproducto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getProvedor() {
	return provedor;
}
public void setProvedor(String provedor) {
	this.provedor = provedor;
}
public String getPrecio() {
	return precio;
}
public void setPrecio(String precio) {
	this.precio = precio;
}
public String getExistencia() {
	return existencia;
}
public void setExistencia(String existencia) {
	this.existencia = existencia;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getUnidad() {
	return unidad;
}
public void setUnidad(String unidad) {
	this.unidad = unidad;
}


}
