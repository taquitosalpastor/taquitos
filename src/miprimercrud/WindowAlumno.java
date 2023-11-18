package miprimercrud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowAlumno {

	public JFrame frmCrudAlumno;
	public DefaultTableModel modelo = new DefaultTableModel();
	private JTextField txtNumControl;
	private JTextField txtNombre;
	private JTextField txtApellidoM;
	private JTextField txtApellidoP;
	private JTextField txtCURP;
	private JTextField txtFeachaNac;
	private JTextField txtDirrecion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtGrupo;
	private JTextField txtCarrera;
	private JTable tblAlumnos;
	private JLabel lblNumControl;
	private JScrollPane TablaExel;
	private JButton btnBorrar;
	private JButton btnAgregar;
	private JButton btnBorrarDato;
	ArrayList<Alumno> listaAlumnos = null;
	Alumno x = null;
	int fila = 0;
	int id = 0;
	private JLabel lblID;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		WindowAlumno window = new WindowAlumno();
		window.frmCrudAlumno.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public WindowAlumno() {
		initialize();
		actualizarTabla();
	}

	public void actualizarTabla() {
		DataAlumno da = new DataAlumno();

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		listaAlumnos = da.selctAlumnos();
		for (Alumno Alumnoss : listaAlumnos) {
			Object o[] = new Object[12];
			o[0] = Alumnoss.getId();
			o[1] = Alumnoss.getNumcontrol();
			o[2] = Alumnoss.getNombre();
			o[3] = Alumnoss.getApellidom();
			o[4] = Alumnoss.getApellidop();
			o[5] = Alumnoss.getCurp();
			o[6] = Alumnoss.getFecha();
			o[7] = Alumnoss.getDireccion();
			o[8] = Alumnoss.getTelefono();
			o[9] = Alumnoss.getCorreo();
			o[10] = Alumnoss.getGrupo();
			o[11] = Alumnoss.getCarrea();

			modelo.addRow(o);

		}
		tblAlumnos.setModel(modelo);
	}

	private void initialize() {
		frmCrudAlumno = new JFrame();
		frmCrudAlumno.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(WindowAlumno.class.getResource("/BotonRadeo/cecytem-logo-D0CECF053F-seeklogo.com.png")));
		frmCrudAlumno.setTitle("Formulario Alumno");
		frmCrudAlumno.setBounds(100, 100, 1322, 682);
		frmCrudAlumno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrudAlumno.getContentPane().setLayout(null);
		frmCrudAlumno.setLocationRelativeTo(null);

		lblNumControl = new JLabel("Numero de control");
		lblNumControl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumControl.setBounds(23, 102, 158, 33);
		frmCrudAlumno.getContentPane().add(lblNumControl);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(242, 30, 72, 33);
		frmCrudAlumno.getContentPane().add(lblNombre);

		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(62, 30, 40, 33);
		frmCrudAlumno.getContentPane().add(lblId);

		JLabel lblApellidoM = new JLabel("Apellido M");
		lblApellidoM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidoM.setBounds(242, 102, 88, 33);
		frmCrudAlumno.getContentPane().add(lblApellidoM);

		JLabel lblApellidoP = new JLabel("Apellido P");
		lblApellidoP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidoP.setBounds(422, 30, 88, 33);
		frmCrudAlumno.getContentPane().add(lblApellidoP);

		JLabel lblCurp = new JLabel("curp");
		lblCurp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurp.setBounds(437, 102, 48, 33);
		frmCrudAlumno.getContentPane().add(lblCurp);

		JLabel lblFechaDeNacimiento = new JLabel("fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFechaDeNacimiento.setBounds(583, 30, 154, 33);
		frmCrudAlumno.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDireccion.setBounds(608, 102, 88, 33);
		frmCrudAlumno.getContentPane().add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(831, 30, 88, 33);
		frmCrudAlumno.getContentPane().add(lblTelefono);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCorreo.setBounds(831, 102, 65, 33);
		frmCrudAlumno.getContentPane().add(lblCorreo);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrupo.setBounds(1045, 30, 88, 33);
		frmCrudAlumno.getContentPane().add(lblGrupo);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCarrera.setBounds(1045, 102, 88, 33);
		frmCrudAlumno.getContentPane().add(lblCarrera);

		txtNumControl = new JTextField();
		txtNumControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNumControl.getText().length() >= 14) {
					e.consume();
				}
			}
		});
		txtNumControl.setBounds(23, 160, 128, 19);
		frmCrudAlumno.getContentPane().add(txtNumControl);
		txtNumControl.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtNombre.setBounds(218, 73, 145, 19);
		frmCrudAlumno.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidoM = new JTextField();
		txtApellidoM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApellidoM.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtApellidoM.setBounds(218, 160, 145, 19);
		frmCrudAlumno.getContentPane().add(txtApellidoM);
		txtApellidoM.setColumns(10);

		txtApellidoP = new JTextField();
		txtApellidoP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApellidoP.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtApellidoP.setBounds(407, 73, 135, 19);
		frmCrudAlumno.getContentPane().add(txtApellidoP);
		txtApellidoP.setColumns(10);

		txtCURP = new JTextField();
		txtCURP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCURP.getText().length() >= 18) {
					e.consume();
				}
			}
		});
		txtCURP.setColumns(10);
		txtCURP.setBounds(407, 160, 135, 19);
		frmCrudAlumno.getContentPane().add(txtCURP);

		txtFeachaNac = new JTextField();
		txtFeachaNac.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtFeachaNac.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtFeachaNac.setColumns(10);
		txtFeachaNac.setBounds(583, 73, 154, 19);
		frmCrudAlumno.getContentPane().add(txtFeachaNac);

		txtDirrecion = new JTextField();
		txtDirrecion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDirrecion.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtDirrecion.setColumns(10);
		txtDirrecion.setBounds(583, 160, 154, 19);
		frmCrudAlumno.getContentPane().add(txtDirrecion);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(796, 73, 154, 19);
		frmCrudAlumno.getContentPane().add(txtTelefono);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCorreo.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(796, 160, 154, 19);
		frmCrudAlumno.getContentPane().add(txtCorreo);

		txtGrupo = new JTextField();
		txtGrupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtGrupo.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtGrupo.setColumns(10);
		txtGrupo.setBounds(990, 73, 178, 19);
		frmCrudAlumno.getContentPane().add(txtGrupo);

		txtCarrera = new JTextField();
		txtCarrera.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCarrera.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(990, 160, 178, 19);
		frmCrudAlumno.getContentPane().add(txtCarrera);

		TablaExel = new JScrollPane();
		TablaExel.setBounds(118, 304, 965, 301);
		frmCrudAlumno.getContentPane().add(TablaExel);

		tblAlumnos = new JTable();
		tblAlumnos.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				fila = tblAlumnos.getSelectedRow();
				x = listaAlumnos.get(fila);
				lblID.setText("" + x.getId());
				;
				txtNumControl.setText(x.getNumcontrol());
				txtNombre.setText(x.getNombre());
				txtApellidoM.setText(x.getApellidom());
				txtApellidoP.setText(x.getApellidop());
				txtFeachaNac.setText(x.getFecha());
				txtCURP.setText(x.getCurp());
				txtDirrecion.setText(x.getDireccion());
				txtTelefono.setText(x.getTelefono());
				txtGrupo.setText(x.getGrupo());
				txtCarrera.setText(x.getCarrea());

			}
		});
		actualizarTabla();
		TablaExel.setViewportView(tblAlumnos);
		modelo.addColumn("id");
		modelo.addColumn("Numero de Control");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido M");
		modelo.addColumn("Apellido P");
		modelo.addColumn("Curp");
		modelo.addColumn("Fecha N");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Correo");
		modelo.addColumn("Grupo");
		modelo.addColumn("Carrera");
		tblAlumnos.setModel(modelo);
		actualizarTabla();
		TablaExel.setViewportView(tblAlumnos);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Alumno x = new Alumno();
					x.setNumcontrol(txtNumControl.getText());
					x.setNombre(txtNombre.getText());
					x.setApellidom(txtApellidoM.getText());
					x.setApellidop(txtApellidoP.getText());
					x.setCurp(txtCURP.getText());
					x.setFecha(txtFeachaNac.getText());
					x.setDireccion(txtDirrecion.getText());
					x.setTelefono(txtTelefono.getText());
					x.setCorreo(txtCorreo.getText());
					x.setGrupo(txtGrupo.getText());
					x.setCarrea(txtCarrera.getText());

					if (x.insertarAlumno()) {
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
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregar.setBounds(129, 227, 157, 33);
		frmCrudAlumno.getContentPane().add(btnAgregar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBorrar.setBounds(328, 227, 157, 33);
		frmCrudAlumno.getContentPane().add(btnBorrar);

		btnBorrarDato = new JButton("EliminarDato");
		btnBorrarDato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar este registro?", "ELIMINAR",
							JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					System.out.println("Opcion: " + op);
					if (op == 0) {
						if (x.eliminarAlumno()) {
							JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
							actualizarTabla();
							limpiarFormulario();
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Se elimino correctamente");
				}
			}
		});
		btnBorrarDato.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBorrarDato.setBounds(876, 227, 157, 33);
		frmCrudAlumno.getContentPane().add(btnBorrarDato);

		lblID = new JLabel("Id");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblID.setBounds(62, 76, 40, 33);
		frmCrudAlumno.getContentPane().add(lblID);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
				
					x.setNumcontrol(txtNumControl.getText());
					x.setNombre(txtNombre.getText());
					x.setApellidom(txtApellidoM.getText());
					x.setApellidop(txtApellidoP.getText());
					x.setCurp(txtCURP.getText());
					x.setFecha(txtFeachaNac.getText());
					x.setDireccion(txtDirrecion.getText());
					x.setTelefono(txtTelefono.getText());
					x.setCorreo(txtCorreo.getText());
					x.setGrupo(txtGrupo.getText());
					x.setCarrea(txtCarrera.getText());

					if (x.ActualizarAlumno()) {
						JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
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
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActualizar.setBounds(539, 227, 157, 33);
		frmCrudAlumno.getContentPane().add(btnActualizar);

	}

	public void limpiarFormulario() {
		lblID.setText("");
		txtNumControl.setText("");
		txtNombre.setText("");
		txtApellidoM.setText("");
		txtApellidoP.setText("");
		txtCURP.setText("");
		txtFeachaNac.setText("");
		txtDirrecion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtGrupo.setText("");
		txtCarrera.setText("");

	}
}
