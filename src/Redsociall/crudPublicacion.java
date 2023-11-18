package Redsociall;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class crudPublicacion {

	public JFrame frmCrudPublicaccion;
	private JLabel lblNewLabel;
	private JTextField txtTexto;
	private JTable tblPublicaciones;
	private JLabel txtID;
	private JButton btnAgregar;
	private JComboBox cmbUser;
	ArrayList<Usuario> listaUsuario=null;
	ArrayList<Publicacion>listaPub=null;
	DefaultTableModel model=new DefaultTableModel();
	DefaultComboBoxModel modelCombo=null;
	DataPublicacion dp=new DataPublicacion();
	Publicacion p=null;
	int fila=0;
	private JButton btnNewButton_1;
	private JButton btnE;
	private JButton btnActualizar;
	
	public crudPublicacion() {
		initialize();
		DataUsuario du=new DataUsuario();
		listaUsuario=du.selectUsuarios();
		Object nombresUsuario[]=new Object[listaUsuario.size()];
		for (int i = 0; i <listaUsuario.size(); i++) {
			nombresUsuario[i]=listaUsuario.get(i).getNombre();
		}
		modelCombo=new DefaultComboBoxModel(nombresUsuario);
		cmbUser.setModel(modelCombo);
		
		btnE = new JButton("Eliminar");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int op=JOptionPane.showConfirmDialog(null, "ESTAS SEGURO DE ELIMINAR REGISTRO?!!","ELIMINAR",JOptionPane.YES_NO_OPTION);
				if(op==0) {
					if(p.eliminarPublicacion()) {
					JOptionPane.showMessageDialog(null, "se elimino correctamente");
					actualizarTabla();
				}else {
					JOptionPane.showMessageDialog(null, "ERROR");

				}
				
				}
			}
		});
		btnE.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnE.setBounds(440, 91, 141, 40);
		frmCrudPublicaccion.getContentPane().add(btnE);
		
		btnActualizar = new JButton("actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				p.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIdUser());
				p.setTexto(txtTexto.getText());
				if(p.actualizarPublicacion()) {
						JOptionPane.showMessageDialog(null, "Se actualizo Correctamente");
						actualizarTabla();

					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnActualizar.setBounds(440, 145, 141, 40);
		frmCrudPublicaccion.getContentPane().add(btnActualizar);
		actualizarTabla();
	}

	public void actualizarTabla() {
		while (model.getRowCount()>0) {	
			model.removeRow(0);
			}
			listaPub=dp.selectPublicaciones();
			for (Publicacion u : listaPub) {
				Object o[]=new Object[4];
				o[0]=u.getIdPub();
				o[1]=getNombre(u.getIdUser());
				o[2]=u.getTexto();
				o[3]=u.getFecha();
				model.addRow(o);
			}
			tblPublicaciones.setModel(model);
			
		
	}
	
	public String getNombre(int idUser) {
		String nombre="";
		for (Usuario u : listaUsuario) {
			if (u.getIdUser()==idUser) {
				nombre= u.getNombre();
			}
		}
		return nombre;
	}
	public int seleccionarUsuario(Publicacion p) {
		int pos=0;
		for (Usuario u : listaUsuario) {
			if (u.getIdUser()==p.getIdUser()) {
			break;
			}
			pos++;
		}
		return pos;
	}
	public void initialize() {
		frmCrudPublicaccion = new JFrame();
		frmCrudPublicaccion.setIconImage(Toolkit.getDefaultToolkit().getImage(crudPublicacion.class.getResource("/Redsociall/Memi and dash icons.jpg")));
		frmCrudPublicaccion.setTitle("CRUD PUBLICACION");
		frmCrudPublicaccion.setBounds(100, 100, 702, 643);
		frmCrudPublicaccion.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("ID PUB");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(25, 32, 94, 40);
		frmCrudPublicaccion.getContentPane().add(lblNewLabel);
		
		txtID = new JLabel("IDPUB");
		txtID.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtID.setBounds(135, 32, 94, 40);
		frmCrudPublicaccion.getContentPane().add(txtID);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblUsuario.setBounds(25, 94, 94, 40);
		frmCrudPublicaccion.getContentPane().add(lblUsuario);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTexto.setBounds(25, 144, 94, 40);
		frmCrudPublicaccion.getContentPane().add(lblTexto);
		
		cmbUser = new JComboBox();
		cmbUser.setBounds(135, 94, 141, 35);
		frmCrudPublicaccion.getContentPane().add(cmbUser);
		
		txtTexto = new JTextField();
		txtTexto.setBounds(133, 159, 222, 102);
		frmCrudPublicaccion.getContentPane().add(txtTexto);
		txtTexto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 271, 651, 325);
		frmCrudPublicaccion.getContentPane().add(scrollPane);
		
		tblPublicaciones = new JTable();
		tblPublicaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila=tblPublicaciones.getSelectedRow();
				p=listaPub.get(fila);
				txtID.setText(""+p.getIdPub());
				cmbUser.setSelectedIndex(seleccionarUsuario(p));
				txtTexto.setText(p.getTexto());
			}
		});
		model.addColumn("ID PUB");
		model.addColumn("USUARIO");
		model.addColumn("TEXTO");
		model.addColumn("FECHA");
		tblPublicaciones.setModel(model);
		scrollPane.setViewportView(tblPublicaciones);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Publicacion p=new Publicacion();
					p.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIdUser());
					p.setTexto(txtTexto.getText());
					if(p.insertarPublicacion()) {
						JOptionPane.showMessageDialog(null, "se inserto correctamente");
						actualizarTabla();
					}else {
						JOptionPane.showMessageDialog(null, "ERROR");

					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAgregar.setBounds(440, 32, 141, 40);
		frmCrudPublicaccion.getContentPane().add(btnAgregar);
		frmCrudPublicaccion.setLocationRelativeTo(null);
	}
}
