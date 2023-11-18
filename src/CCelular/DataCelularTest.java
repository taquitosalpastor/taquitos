package CCelular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataCelularTest {

	@Test
	void testInsertarCel() {
		Celular c=new Celular();
		c.setIdcel(551);
		c.setMarca("Realme red");
		c.setModelo("REalmeP");
		c.setProcesador("SnapDragon15");
		c.setSistema("Android 10");
		assertTrue(c.insertarCel());
	}
	@Test
	void testCargarCel() {
		Celular c=new Celular();
		c.setIdcel(551);
		
		assertTrue(c.cargaCel());
	}
	@Test
	void testActualizarCel() {
		Celular c=new Celular();
		c.setIdcel(551);
		c.setMarca("Xiaomi");
		c.setModelo("C 12");
		c.setProcesador("SnapDragon");
		c.setSistema("Android 12");
		assertTrue(c.actualizarCel());
	}
	
	
	
	@Test
	void testEliminarCel() {
		Celular c=new Celular();
		c.setIdcel(551);
		
		assertTrue(c.eliminarCel());
	}

	
	

}
