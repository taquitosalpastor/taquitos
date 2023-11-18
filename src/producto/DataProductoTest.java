package producto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;





class DataProductoTest {

	void testInsertarProducto() {
		Producto p= new Producto();
		p.setIdproducto(3);
		p.setNombre("2");
		p.setProvedor("2");
		p.setPrecio("2");
		p.setExistencia("2");
		p.setDescripcion("2");
		p.setUnidad("2");
		assertTrue(p.insertarProducto());
	}

	void testCargarProducto() {
		Producto p=new Producto();
		p.setIdproducto(3);
		
		assertTrue(p.cargarProducto());
	}

	void testEliminarProducto() {
		Producto p=new Producto();
		p.setIdproducto(3);
		
		assertTrue(p.eliminarProducto());
	}


	void testActualizarProducto() {
		Producto p=new Producto();
		p.setIdproducto(3);
		p.setNombre("2");
		p.setProvedor("2");
		p.setPrecio("2");
		p.setExistencia("2");
		p.setDescripcion("2");
		p.setUnidad("2");
		assertTrue(p.actualizarProducto());
	}

}
