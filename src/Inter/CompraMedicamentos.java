package Inter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompraMedicamentos {

	public JFrame frmMedicamentos;
	private JButton btnRegresar;
	private JScrollPane scrollPaneM;
	private JTable tblM;
	private JTextField txtProducto;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtTotal;
	private JButton btnComprar;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraMedicamentos window = new CompraMedicamentos();
					window.frmMedicamentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CompraMedicamentos() {
		initialize();
	}

	
	private void initialize() {
		frmMedicamentos = new JFrame();
		frmMedicamentos.getContentPane().setBackground(new Color(0, 255, 255));
		frmMedicamentos.getContentPane().setLayout(null);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(348, 42, 89, 23);
		frmMedicamentos.getContentPane().add(btnRegresar);
		
		scrollPaneM = new JScrollPane();
		scrollPaneM.setBounds(10, 150, 414, 152);
		frmMedicamentos.getContentPane().add(scrollPaneM);
		
		tblM = new JTable();
		tblM.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPaneM.setViewportView(tblM);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 12, 74, 19);
		frmMedicamentos.getContentPane().add(lblNewLabel);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(94, 12, 129, 20);
		frmMedicamentos.getContentPane().add(txtProducto);
		txtProducto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(245, 13, 74, 19);
		frmMedicamentos.getContentPane().add(btnBuscar);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(10, 43, 48, 19);
		frmMedicamentos.getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(94, 43, 79, 20);
		frmMedicamentos.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(199, 71, 48, 19);
		frmMedicamentos.getContentPane().add(lblTotal);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setBounds(10, 71, 63, 19);
		frmMedicamentos.getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(94, 70, 79, 20);
		frmMedicamentos.getContentPane().add(txtCantidad);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(245, 70, 79, 20);
		frmMedicamentos.getContentPane().add(txtTotal);
		
		btnComprar = new JButton("");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cajero CJ=new Cajero();
				CJ.frmResumenDeCompra.setVisible(true);
			}
		});
		btnComprar.setBorder(null);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setIcon(new ImageIcon(CompraMedicamentos.class.getResource("/Imag/carrito-de-compras.png")));
		btnComprar.setBounds(364, 2, 63, 30);
		frmMedicamentos.getContentPane().add(btnComprar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(10, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(104, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(199, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnLimpiar);
		frmMedicamentos.setTitle("Medicamentos");
		frmMedicamentos.setBounds(100, 100, 453, 352);
		frmMedicamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
