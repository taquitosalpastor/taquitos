package Redsociall;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import miprimercrud.Alumno;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.WildcardType;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class crudUsuario {

	public JFrame frmCrudUsuario;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JTable tblUsuarios;
	private JPasswordField txtPassword;
	 private JLabel txtidUser;
	    private JButton btnEliminar;
	    private JButton btnBorrar;
	    private JButton btnActualizar;
	    private JButton btnNewButton;
    DefaultTableModel model=new DefaultTableModel();
    ArrayList<Usuario> listaUsuario;
    DataUsuario du=new DataUsuario();
    Usuario u=null;
    int fila=0;
    int id=0;
   
	
	public crudUsuario() {
		initialize();
		actualizarTabla();
	}

	public void actualizarTabla() {
		while (model.getRowCount()>0) {	
		model.removeRow(0);
		}
		listaUsuario=du.selectUsuarios();
		for (Usuario u : listaUsuario) {
			Object o[]=new Object[5];
			o[0]=u.getIdUser();
			o[1]=u.getCorreo();
			o[2]=u.getTelefono();
			o[3]=u.getPassword();
			o[4]=u.getNombre();
			model.addRow(o);
		}
		tblUsuarios.setModel(model);
		
	}
	private void initialize() {
		frmCrudUsuario = new JFrame();
		frmCrudUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(crudUsuario.class.getResource("/Redsociall/descargar (3).jpg")));
		//frmCrudUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josue\\Downloads\\descargar.jpeg"));
		frmCrudUsuario.setTitle("CRUD USUARIO");
		frmCrudUsuario.setBounds(100, 100, 627, 599);
		frmCrudUsuario.setLocationRelativeTo(null);
		frmCrudUsuario.getContentPane().setLayout(null);
		
		JLabel lblidUser = new JLabel("id User");
		lblidUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblidUser.setBounds(48, 42, 84, 25);
		frmCrudUsuario.getContentPane().add(lblidUser);
		
		txtidUser = new JLabel("");
		txtidUser.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtidUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtidUser.setBounds(208, 42, 45, 25);
		frmCrudUsuario.getContentPane().add(txtidUser);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCorreo.setBounds(48, 99, 95, 25);
		frmCrudUsuario.getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCorreo.getText().length()>=100) {
				e.consume();
				}
			}
		});
		txtCorreo.setBounds(208, 100, 169, 31);
		frmCrudUsuario.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefono.setBounds(48, 155, 95, 25);
		frmCrudUsuario.getContentPane().add(lblTelefono);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(48, 208, 116, 25);
		frmCrudUsuario.getContentPane().add(lblPassword);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setBounds(48, 261, 84, 25);
		frmCrudUsuario.getContentPane().add(lblNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtTelefono.getText().length()>=10) {
				e.consume();
			}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(208, 149, 169, 31);
		frmCrudUsuario.getContentPane().add(txtTelefono);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length()>=100) {
				e.consume();
				}
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(208, 262, 169, 31);
		frmCrudUsuario.getContentPane().add(txtNombre);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario x = new Usuario();
					x.setCorreo(txtCorreo.getText());
					x.setTelefono(txtTelefono.getText());
					x.setPassword(encriptarPassword(txtPassword.getText()));
					x.setNombre(txtNombre.getText());
					

					if (x.insertarUsuario()) {
						JOptionPane.showMessageDialog(null, "Se Inserto Correctamente");
						actualizarTabla();
						limpiarFormulario();

					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(crudUsuario.class.getResource("/Redsociall/OIP2.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(430, 37, 158, 36);
		frmCrudUsuario.getContentPane().add(btnNewButton);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnBorrar.setIcon(new ImageIcon(crudUsuario.class.getResource("/Redsociall/BORRAR.jpg")));
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBorrar.setBounds(430, 150, 158, 36);
		frmCrudUsuario.getContentPane().add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					u.setCorreo(txtCorreo.getText());
					u.setTelefono(txtTelefono.getText());
					u.setPassword(encriptarPassword(txtPassword.getText()));
					u.setNombre(txtNombre.getText());
					

					if (u.actualizarUsuario()) {
						JOptionPane.showMessageDialog(null, "Se actualizo Correctamente");
						actualizarTabla();
						limpiarFormulario();

					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
	btnActualizar.setIcon(new ImageIcon(crudUsuario.class.getResource("/Redsociall/Actualizar.jpg")));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnActualizar.setBounds(430, 94, 158, 36);
		frmCrudUsuario.getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int op=JOptionPane.showConfirmDialog(null, "ESTAS SEGURO DE ELIMINAR REGISTRO?!!","ELIMINAR",JOptionPane.YES_NO_OPTION);
					if(op==0) {
						if(u.eliminarUsuario()) {
							JOptionPane.showMessageDialog(null, "SE ELIMINO  CORRECTAMENTE ");
							actualizarTabla();
							limpiarFormulario();
							u=null;
						}else {
							JOptionPane.showMessageDialog(null, "ERROR ");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR ");

				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(crudUsuario.class.getResource("/Redsociall/eliminar.jpg")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEliminar.setBounds(430, 203, 158, 36);
		frmCrudUsuario.getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 303, 545, 235);
		frmCrudUsuario.getContentPane().add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			fila=tblUsuarios.getSelectedRow();
			u=listaUsuario.get(fila);
			txtidUser.setText(""+u.getIdUser());
			txtCorreo.setText(u.getCorreo());
			txtTelefono.setText(u.getTelefono());
			txtPassword.setText(u.getPassword());
			txtNombre.setText(u.getNombre());
			
			}
		});
		model.addColumn("ID user");
		model.addColumn("COOREO");
		model.addColumn("TELEFONO");
		model.addColumn("PASSWORD");
		model.addColumn("NOMBRE");
		tblUsuarios.setModel(model);
		
		scrollPane.setViewportView(tblUsuarios);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtPassword.getText().length()>=100) {
					e.consume();
				}
			}
		});
		txtPassword.setBounds(208, 207, 169, 36);
		frmCrudUsuario.getContentPane().add(txtPassword);
	}
	public void limpiarFormulario() {
		txtidUser.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtPassword.setText("");
		txtNombre.setText("");
	}
	
	public String encriptarPassword(String password) {

	      MessageDigest md;
	      byte[] encoded = null;
		try {
			md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			 md.update(password.getBytes());
		      byte[] digest = md.digest();

		      for (byte b : digest) {
		         //System.out.print(Integer.toHexString(0xFF & b));
		      }
		      System.out.println();

		      encoded = Base64.encodeBase64(digest);
		      //System.out.println(new String(encoded));	
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return new String(encoded);
	}
}
