package producto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CrudProducto {

	private JFrame frmProducto;
	private JTextField txtIdProducto;
	private JTextField txtNombre;
	private JTextField txtProvedor;
	private JTextField txtPrecio;
	private JTextField txtExistencia;
	private JTextField txtDescripcion;
	private JTextField txtUnidad;
	private JButton btnInsertar;
	private JButton btnCargar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	Producto po=new Producto();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudProducto window = new CrudProducto();
					window.frmProducto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CrudProducto() {
		initialize();
	}

	private void initialize() {
		frmProducto = new JFrame();
		frmProducto.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		frmProducto.setIconImage(Toolkit.getDefaultToolkit().getImage(CrudProducto.class.getResource("/Redsociall/descargar (3).jpg")));
		frmProducto.setTitle("Producto");
		frmProducto.setBounds(100, 100, 593, 435);
		frmProducto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProducto.getContentPane().setLayout(null);
		frmProducto.setLocationRelativeTo(null);
		
		
		JLabel lblidProducto = new JLabel("idProducto");
		lblidProducto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblidProducto.setBounds(10, 24, 115, 38);
		frmProducto.getContentPane().add(lblidProducto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(10, 64, 93, 38);
		frmProducto.getContentPane().add(lblNombre);
		
		JLabel lblprovedor = new JLabel("Provedor");
		lblprovedor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblprovedor.setBounds(10, 106, 93, 38);
		frmProducto.getContentPane().add(lblprovedor);
		
		JLabel lblprecio = new JLabel("Precio");
		lblprecio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblprecio.setBounds(10, 153, 93, 38);
		frmProducto.getContentPane().add(lblprecio);
		
		JLabel lblexistencia = new JLabel("Existencia");
		lblexistencia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblexistencia.setBounds(10, 202, 115, 38);
		frmProducto.getContentPane().add(lblexistencia);
		
		JLabel lbldescripcion = new JLabel("Descripcion");
		lbldescripcion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldescripcion.setBounds(10, 250, 115, 38);
		frmProducto.getContentPane().add(lbldescripcion);
		
		JLabel lblunidad = new JLabel("Unidad");
		lblunidad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblunidad.setBounds(10, 298, 93, 38);
		frmProducto.getContentPane().add(lblunidad);
		
		txtIdProducto = new JTextField();
		txtIdProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtIdProducto.getText().length()>2) {
					e.consume();
					}
				
			}
		});
		txtIdProducto.setBounds(135, 30, 168, 33);
		frmProducto.getContentPane().add(txtIdProducto);
		txtIdProducto.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtNombre.getText().length()>29) {
					e.consume();
					}
			
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(135, 69, 168, 33);
		frmProducto.getContentPane().add(txtNombre);
		
		txtProvedor = new JTextField();
		txtProvedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {


				if (txtProvedor.getText().length()>29) {
					e.consume();
					}
			
			
			}
		});
		txtProvedor.setColumns(10);
		txtProvedor.setBounds(135, 111, 168, 33);
		frmProducto.getContentPane().add(txtProvedor);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {


				if (txtPrecio.getText().length()>9) {
					e.consume();
					}
			
			
			}
		});
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(135, 153, 168, 33);
		frmProducto.getContentPane().add(txtPrecio);
		
		txtExistencia = new JTextField();
		txtExistencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {


				if (txtExistencia.getText().length()>4) {
					e.consume();
					}
			
			
			}
		});
		txtExistencia.setColumns(10);
		txtExistencia.setBounds(135, 207, 168, 33);
		frmProducto.getContentPane().add(txtExistencia);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {


				if (txtDescripcion.getText().length()>99) {
					e.consume();
					}
			
			
			}
		});
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(135, 255, 168, 33);
		frmProducto.getContentPane().add(txtDescripcion);
		
		txtUnidad = new JTextField();
		txtUnidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {


				if (txtUnidad.getText().length()>19) {
					e.consume();
					}
			
			
			}
		});
		txtUnidad.setColumns(10);
		txtUnidad.setBounds(135, 303, 168, 33);
		frmProducto.getContentPane().add(txtUnidad);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Producto c=new Producto();
					c.setIdproducto(Integer.parseInt(txtIdProducto.getText()));
					c.setNombre(txtNombre.getText());
					c.setProvedor(txtProvedor.getText());
					c.setPrecio(txtPrecio.getText());
					c.setExistencia(txtExistencia.getText());
					c.setDescripcion(txtDescripcion.getText());
					c.setUnidad(txtUnidad.getText());
					if(c.insertarProducto()) {
						JOptionPane.showMessageDialog(null, "Se inserto Correctamente ");
						
					}else {
						JOptionPane.showMessageDialog(null,"Error Al Insertar");
					}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
			
		});
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnInsertar.setBounds(363, 36, 137, 33);
		frmProducto.getContentPane().add(btnInsertar);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idproducto =Integer.parseInt(JOptionPane.showInputDialog("ID A CARGAR"));
					po.setIdproducto(idproducto);
					if(po.cargarProducto()) {
						txtIdProducto.setText(""+po.getIdproducto());
						txtNombre.setText(po.getNombre());
						txtProvedor.setText(po.getProvedor());
						txtPrecio.setText(po.getPrecio());
						txtExistencia.setText(po.getExistencia());
						txtDescripcion.setText(po.getDescripcion());
						txtUnidad.setText(po.getUnidad());
						JOptionPane.showMessageDialog(null, "SE CARGO CORRECTAMENTE");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR al Insertar");
						}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
		});
		btnCargar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnCargar.setBounds(363, 93, 137, 33);
		frmProducto.getContentPane().add(btnCargar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idproducto=Integer.parseInt(JOptionPane.showInputDialog("Id a Eliminar"));
					po.setIdproducto(idproducto);
					if(po.eliminarProducto()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
						
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
					}
				} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnEliminar.setBounds(363, 153, 137, 33);
		frmProducto.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					po.setIdproducto(Integer.parseInt(txtIdProducto.getText()));
					po.setNombre(txtNombre.getText());
					po.setProvedor(txtProvedor.getText());
					po.setPrecio(txtPrecio.getText());
					po.setExistencia(txtExistencia.getText());
					po.setDescripcion(txtDescripcion.getText());
					po.setUnidad(txtUnidad.getText());;
					if(po.actualizarProducto()) {	
						limpiar();
						JOptionPane.showMessageDialog(null, "Se actualizo Correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
				}
			
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnActualizar.setBounds(363, 207, 137, 33);
		frmProducto.getContentPane().add(btnActualizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limpiar();
			
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnLimpiar.setBounds(363, 262, 137, 33);
		frmProducto.getContentPane().add(btnLimpiar);
	}
	public void limpiar() {
		txtIdProducto.setText("");
		txtNombre.setText("");
		txtProvedor.setText("");
		txtPrecio.setText("");
		txtExistencia.setText("");
		txtDescripcion.setText("");
		txtUnidad.setText("");
	
	}
}
