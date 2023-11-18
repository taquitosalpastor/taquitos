package Redsociall;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {
	private JButton btnUsuario;
	private JButton btnPublicacion;
	private JButton btnComentario;
	private JFrame frmCrudUsuarioo;
	
	
	



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmCrudUsuarioo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		initialize();
	}

	private void initialize() {
		frmCrudUsuarioo = new JFrame();
		frmCrudUsuarioo.setTitle("PRINCIPAL");
		frmCrudUsuarioo.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Redsociall/descargar.jpeg")));
		frmCrudUsuarioo.setBounds(100, 100, 647, 427);
		frmCrudUsuarioo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrudUsuarioo.getContentPane().setLayout(null);
		frmCrudUsuarioo.setLocationRelativeTo(null);
		
		btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudUsuario crudU =new crudUsuario();
				crudU.frmCrudUsuario.setVisible(true);
			}
		});
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUsuario.setBounds(78, 54, 162, 86);
		frmCrudUsuarioo.getContentPane().add(btnUsuario);
		
		btnPublicacion = new JButton("Publicacion");
		btnPublicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudPublicacion crudP =new crudPublicacion();
				crudP.frmCrudPublicaccion.setVisible(true);
			}
		});
		btnPublicacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPublicacion.setBounds(360, 54, 162, 86);
		frmCrudUsuarioo.getContentPane().add(btnPublicacion);
		
		btnComentario = new JButton("Comentario");
		btnComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudComentario crudC =new crudComentario();
				crudC.frame.setVisible(true);
			}
		});
		btnComentario.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComentario.setBounds(235, 204, 162, 86);
		frmCrudUsuarioo.getContentPane().add(btnComentario);
	}
}