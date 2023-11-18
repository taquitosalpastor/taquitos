package Inter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Registro {

	
	public JFrame Registrossss;
	private JTextField textNom;
	private JTextField textAp;
	private JTextField textCorreo;
	private JPasswordField passwordC;
	private JButton btnR;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
					window.Registrossss.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param b 
	 * @param object 
	 */
	public Registro() {
		
		initialize();
	}

	
	private void initialize() {
		Registrossss = new JFrame();
		Registrossss.getContentPane().setBackground(new Color(0, 255, 255));
	//	Registrossss.setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/Imag/perfil-del-usuario.png")));
		Registrossss.setTitle("Registro");
		Registrossss.setBounds(100, 100, 337, 341);
		Registrossss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Registrossss.getContentPane().setLayout(null);
		Registrossss.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Usuario");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel.setBounds(97, 11, 119, 18);
		Registrossss.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(59, 40, 56, 14);
		Registrossss.getContentPane().add(lblNewLabel_1);
		
		textNom = new JTextField();
		textNom.setBounds(135, 40, 126, 20);
		Registrossss.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(59, 72, 56, 14);
		Registrossss.getContentPane().add(lblNewLabel_2);
		
		textAp = new JTextField();
		textAp.setBounds(135, 71, 126, 20);
		Registrossss.getContentPane().add(textAp);
		textAp.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(59, 100, 46, 14);
		Registrossss.getContentPane().add(lblNewLabel_3);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(135, 98, 126, 20);
		Registrossss.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Contraseña");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(59, 128, 70, 18);
		Registrossss.getContentPane().add(lblNewLabel_4);
		
		passwordC = new JPasswordField();
		passwordC.setBounds(135, 129, 126, 20);
		Registrossss.getContentPane().add(passwordC);
		
		btnR = new JButton("Registro");
		btnR.setBounds(107, 163, 83, 23);
		Registrossss.getContentPane().add(btnR);
		
		lblNewLabel_6 = new JLabel("");
	//	lblNewLabel_6.setIcon(new ImageIcon(Registro.class.getResource("/Imag/perfil-del-usuario.png")));
		lblNewLabel_6.setBounds(117, 197, 70, 64);
		Registrossss.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(0, 213, 213));
		lblNewLabel_5.setBounds(41, 11, 235, 257);
		Registrossss.getContentPane().add(lblNewLabel_5);
	}

}
