package Redsociall;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class crudComentario {

	public JFrame frame;
	private JButton btnAgregar;
	private JTextField txtTexto;
	private JTable tblComentarios;
	private JLabel txtID;
	private JComboBox cmbUser;
	private JComboBox cmbPublicacion;
	

	ArrayList<Usuario> listaUsuario=null;
	ArrayList<Publicacion>listaPub=null;
	ArrayList<Comentario>listaCom=null;
	DefaultTableModel model=new DefaultTableModel();
	DefaultComboBoxModel modelCombo=null;
	DefaultComboBoxModel modelCombo2=null;
	DataComentario dc=new DataComentario();
	Comentario p=null;
	int fila=0;
	private JButton btnEliminar;
	private JButton btnActualizar;
	
	
	public crudComentario() {
		initialize();
		DataUsuario du=new DataUsuario();
		listaUsuario=du.selectUsuarios();
		Object nombresUsuario[]=new Object[listaUsuario.size()];
		for (int i = 0; i <listaUsuario.size(); i++) {
			nombresUsuario[i]=listaUsuario.get(i).getNombre();
		}
		modelCombo=new DefaultComboBoxModel(nombresUsuario);
		cmbUser.setModel(modelCombo);
		
		DataPublicacion dp = new DataPublicacion();
		listaPub = dp.selectPublicaciones();
		Object nombresPub[] = new Object[listaPub.size()];
	for (int i = 0; i< listaPub.size();i++) {
		nombresPub[i] = getNombre(listaPub.get(i).getIdUser())+":"+listaPub.get(i).getTexto();
	}
	modelCombo2 = new DefaultComboBoxModel(nombresPub);
	cmbPublicacion.setModel(modelCombo);
	actualizarTabla();
		
	}
	public void actualizarTabla() {
		while (model.getRowCount()>0) {	
			model.removeRow(0);
			}
			listaCom = dc.selectComentarios();
			for (Comentario u : listaCom) {
				Object o[]=new Object[5];
				o[0]=u.getIdCom();
				o[1]=getNombre(u.getIdUser());
				o[2]=getPub(u.getIdPub());
				o[3]=u.getTexto();
				o[4]=u.getFecha();
				
				model.addRow(o);
			}
			tblComentarios.setModel(model);
	}
	
	public String  getNombre(int idUser) {
		String nombre = "";
		for (Usuario u: listaUsuario) {
			if(u.getIdUser()== idUser){
				nombre = u.getNombre();
				
			}
		}
		return nombre;
	}
	public String  getPub(int idPub) {
		String pub = "";
		for (Publicacion u: listaPub) {
			if(u.getIdUser()== idPub){
				System.out.println("id user:"+u.getIdUser());
				pub = getNombre(u.getIdUser())+":"+u.getTexto();
			}
		}
		return pub;
	}
	 public int seleccionarUsuario(Comentario p) {
		 int pos =0;
		 for (Publicacion u : listaPub) {
			if (u.getIdUser() == p.getIdPub()) {
				
			}
		}
		return pos;
		 
	 }
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(crudComentario.class.getResource("/Redsociall/_0.jpg")));
		frame.setBounds(100, 100, 653, 535);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id com");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 30, 72, 25);
		frame.getContentPane().add(lblNewLabel);
		
		txtID = new JLabel("id com");
		txtID.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtID.setBounds(107, 30, 72, 25);
		frame.getContentPane().add(txtID);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsuario.setBounds(21, 77, 82, 25);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblPublicacion = new JLabel("Publicacion");
		lblPublicacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPublicacion.setBounds(21, 129, 115, 25);
		frame.getContentPane().add(lblPublicacion);
		
		cmbUser = new JComboBox();
		cmbUser.setBounds(146, 80, 143, 27);
		frame.getContentPane().add(cmbUser);
		
		cmbPublicacion = new JComboBox();
		cmbPublicacion.setBounds(146, 127, 143, 27);
		frame.getContentPane().add(cmbPublicacion);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Comentario p= new Comentario();
					p.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIdUser());
					p.setIdPub(listaPub.get(cmbPublicacion.getSelectedIndex()).getIdPub());
					p.setTexto(txtTexto.getText());
					if(p.insertarComentario()) {
						JOptionPane.showConfirmDialog(null, "se inserto correctamente");
						actualizarTabla();
					}else {
						JOptionPane.showConfirmDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "ERROR");
				}
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregar.setBounds(442, 20, 135, 53);
		frame.getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este registro?","eliminar",JOptionPane.YES_NO_OPTION);
				if(op==0) {
					if(p.eliminarComentario()) {
						JOptionPane.showConfirmDialog(null, "se inserto correctamente");
						actualizarTabla();
					}else {
						JOptionPane.showConfirmDialog(null, "ERROR");
					}
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(442, 83, 135, 53);
		frame.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					p.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIdUser());
					p.setIdPub(listaPub.get(cmbPublicacion.getSelectedIndex()).getIdPub());
					p.setTexto(txtTexto.getText());
					if(p.actualizarComentario()) {
						JOptionPane.showConfirmDialog(null, "se inserto correctamente");
						actualizarTabla();
					}else {
						JOptionPane.showConfirmDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "ERROR");
				}
				
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnActualizar.setBounds(442, 146, 135, 63);
		frame.getContentPane().add(btnActualizar);
		
		JLabel lblNewLabel_1_1 = new JLabel("texto");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(21, 184, 72, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtTexto = new JTextField();
		txtTexto.setBounds(113, 184, 315, 99);
		frame.getContentPane().add(txtTexto);
		txtTexto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 293, 577, 195);
		frame.getContentPane().add(scrollPane);
		
		tblComentarios = new JTable();
		tblComentarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblComentarios.getSelectedRow();
				p = listaCom.get(fila);
				txtID.setText(""+p.getIdCom());
				cmbUser.setSelectedIndex(seleccionarUsuario(p));
				cmbPublicacion.setSelectedIndex(seleccionarUsuario(p));
				txtTexto.setText(p.getTexto());
			
			}
		});
		model.addColumn("ID COM");
		model.addColumn("USUARIO");
		model.addColumn("PUBLICACION");
		model.addColumn("TEXTO");
		model.addColumn("FECHA");
		tblComentarios.setModel(model);
		scrollPane.setViewportView(tblComentarios);
	}
}
