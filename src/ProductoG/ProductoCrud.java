package ProductoG;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;





public class ProductoCrud {

	private JFrame frmProducto;
	private JTextField txtIdProducto;
	private JTextField txtNombre;
	private JTextField txtProvedor;
	private JTextField txtPrecio;
	private JTextField txtExistencia;
	private JTextField txtDescripcion;
	private JTextField txtUnidad;
	private JButton btnInsertar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCargar;
	private JButton btnLimpiar;
	Producto produc=new Producto();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductoCrud window = new ProductoCrud();
					window.frmProducto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ProductoCrud() {
		initialize();
	}

	
	private void initialize() {
		frmProducto = new JFrame();
		frmProducto.setIconImage(Toolkit.getDefaultToolkit().getImage(ProductoCrud.class.getResource("/Redsociall/descargar.jpeg")));
		frmProducto.setTitle("Producto");
		frmProducto.setBounds(100, 100, 345, 300);
		frmProducto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProducto.getContentPane().setLayout(null);
		
		JLabel lblIDProducto = new JLabel("Id Producto");
		lblIDProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIDProducto.setBounds(10, 11, 91, 14);
		frmProducto.getContentPane().add(lblIDProducto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 39, 91, 14);
		frmProducto.getContentPane().add(lblNombre);
		
		JLabel lblProvedor = new JLabel("Provedor");
		lblProvedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProvedor.setBounds(10, 68, 91, 14);
		frmProducto.getContentPane().add(lblProvedor);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(10, 93, 91, 14);
		frmProducto.getContentPane().add(lblPrecio);
		
		JLabel lblExistencia = new JLabel("Existencia");
		lblExistencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExistencia.setBounds(10, 118, 91, 14);
		frmProducto.getContentPane().add(lblExistencia);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(10, 149, 91, 14);
		frmProducto.getContentPane().add(lblDescripcion);
		
		JLabel lblUnidad = new JLabel("Unidad");
		lblUnidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnidad.setBounds(10, 178, 91, 14);
		frmProducto.getContentPane().add(lblUnidad);
		
		txtIdProducto = new JTextField();
		txtIdProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtIdProducto.getText().length()>3) {
					e.consume();
					}
			}
		});
		txtIdProducto.setBounds(124, 10, 98, 20);
		frmProducto.getContentPane().add(txtIdProducto);
		txtIdProducto.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length()>30) {
					e.consume();
					}
			}
		});
		txtNombre.setBounds(124, 38, 98, 20);
		frmProducto.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtProvedor = new JTextField();
		txtProvedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtProvedor.getText().length()>30) {
					e.consume();
					}
			}
		});
		txtProvedor.setColumns(10);
		txtProvedor.setBounds(124, 67, 98, 20);
		frmProducto.getContentPane().add(txtProvedor);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPrecio.getText().length()>10) {
					e.consume();
					}
			}
		});
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(124, 92, 98, 20);
		frmProducto.getContentPane().add(txtPrecio);
		
		txtExistencia = new JTextField();
		txtExistencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtExistencia.getText().length()>5) {
					e.consume();
					}
			}
		});
		txtExistencia.setColumns(10);
		txtExistencia.setBounds(124, 117, 98, 20);
		frmProducto.getContentPane().add(txtExistencia);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDescripcion.getText().length()>100) {
					e.consume();
					}
			}
		});
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(124, 148, 98, 20);
		frmProducto.getContentPane().add(txtDescripcion);
		
		txtUnidad = new JTextField();
		txtUnidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtUnidad.getText().length()>20) {
					e.consume();
					}
			}
		});
		txtUnidad.setColumns(10);
		txtUnidad.setBounds(124, 177, 98, 20);
		frmProducto.getContentPane().add(txtUnidad);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Producto p=new Producto();
					p.setIdproducto(Integer.parseInt(txtIdProducto.getText()));
					p.setNombre(txtNombre.getText());
					p.setProvedor(txtProvedor.getText());
					p.setPrecio(txtPrecio.getText());
					p.setExistencia(txtExistencia.getText());
					p.setDescripcion(txtDescripcion.getText());
					p.setUnidad(txtUnidad.getText());
					if(p.insertarProducto()) {
						JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE ");
						Limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"ERROR AL INSERTAR");
					}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR");
				}
			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInsertar.setBounds(133, 208, 89, 23);
		frmProducto.getContentPane().add(btnInsertar);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idproducto =Integer.parseInt(JOptionPane.showInputDialog("ID A CARGAR"));
					produc.setIdproducto(idproducto);
					if(produc.cargarProducto()) {
						txtIdProducto.setText(""+produc.getIdproducto());
						txtNombre.setText(produc.getNombre());
						txtProvedor.setText(produc.getProvedor());
						txtPrecio.setText(produc.getPrecio());
						txtExistencia.setText(produc.getExistencia());
						txtDescripcion.setText(produc.getDescripcion());
						txtUnidad.setText(produc.getUnidad());
						JOptionPane.showMessageDialog(null, "SE CARGO CORRECTAMENTE");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
						}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
				}
			}
		});
		btnCargar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCargar.setBounds(232, 115, 98, 23);
		frmProducto.getContentPane().add(btnCargar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idproducto=Integer.parseInt(JOptionPane.showInputDialog("Id a Eliminar"));
					produc.setIdproducto(idproducto);
					if(produc.eliminarProducto()) {
						Limpiar();
						JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
						
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
					}
				} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(228, 176, 102, 23);
		frmProducto.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					produc.setIdproducto(Integer.parseInt(txtIdProducto.getText()));
					produc.setNombre(txtNombre.getText());
					produc.setProvedor(txtProvedor.getText());
					produc.setPrecio(txtPrecio.getText());
					produc.setExistencia(txtExistencia.getText());
					produc.setDescripcion(txtDescripcion.getText());
					produc.setUnidad(txtUnidad.getText());;
					if(produc.actualizarProducto()) {	
						Limpiar();
						JOptionPane.showMessageDialog(null, "SE ACTUALIZO CORRECTAMENTE");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
				}
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.setBounds(232, 140, 98, 23);
		frmProducto.getContentPane().add(btnActualizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(20, 208, 98, 23);
		frmProducto.getContentPane().add(btnLimpiar);
	}
	public void Limpiar() {
		txtIdProducto.setText("");
		txtNombre.setText("");
		txtProvedor.setText("");
		txtPrecio.setText("");
		txtExistencia.setText("");
		txtDescripcion.setText("");
		txtUnidad.setText("");
	
	}
}
