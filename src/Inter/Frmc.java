package Inter;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

	public class Frmc {

	    public JFrame frmFarmaciaUsuario;
	    private JLabel lblNewLabel;
	    private JLabel lblCliente;
	    private JButton btnComprar;
	    private JButton btnNewButton;
	    private JLabel lblHora;
	    private JPanel panel;
	    private JButton btnQuejas;
	    private JButton btnComentario;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Frmc window = new Frmc();
	                    window.frmFarmaciaUsuario.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public Frmc() {
	        initialize();
	        HoraMX();
	    }

	    private void initialize() {

	        frmFarmaciaUsuario = new JFrame();
	        frmFarmaciaUsuario.setBackground(new Color(128, 255, 255));
	        frmFarmaciaUsuario.getContentPane().setBackground(new Color(128, 255, 255));
	        frmFarmaciaUsuario.setTitle("Farmacia Usuario");
	        frmFarmaciaUsuario.setBounds(600, 600, 1073, 992);
	        frmFarmaciaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmFarmaciaUsuario.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        frmFarmaciaUsuario.setLocationRelativeTo(null);
	        frmFarmaciaUsuario.getContentPane().setLayout(null);

	        lblNewLabel = new JLabel("Farmacia Full House");
	        lblNewLabel.setBounds(95, 13, 232, 21);
	        lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 17));
	        frmFarmaciaUsuario.getContentPane().add(lblNewLabel);

	        lblCliente = new JLabel("Cliente:");
	        lblCliente.setBounds(10, 32, 183, 35);
	        lblCliente.setBorder(new LineBorder(new Color(0, 255, 255), 2, true));
	        lblCliente.setFont(new Font("Serif", Font.BOLD, 14));
	        frmFarmaciaUsuario.getContentPane().add(lblCliente);

	        btnComprar = new JButton("Comprar Medicamento");
	        btnComprar.setBounds(10, 78, 145, 50);
	        btnComprar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CompraMedicamentos CM=new CompraMedicamentos();
					CM.frmMedicamentos.setVisible(true);
	        	}
	        });
	        btnComprar.setBorder(null);
	        btnComprar.setVerticalAlignment(SwingConstants.BOTTOM);
	        btnComprar.setRolloverIcon(new ImageIcon(Frmc.class.getResource("/Imag/medicamento (1).png")));
	        btnComprar.setPressedIcon(new ImageIcon(Frmc.class.getResource("/Imag/medicamento (2).png")));
	        btnComprar.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnComprar.setFont(new Font("Tahoma", Font.BOLD, 10));
	        btnComprar.setBackground(new Color(255, 255, 255));
	        btnComprar.setForeground(new Color(0, 0, 0));
	        btnComprar.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnComprar.setContentAreaFilled(false);
	        btnComprar.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/medicamento (2).png")));
	        frmFarmaciaUsuario.getContentPane().add(btnComprar);

	        btnNewButton = new JButton("Agenda");
	        btnNewButton.setBounds(10, 132, 130, 49);
	        btnNewButton.setContentAreaFilled(false);
	        btnNewButton.setRolloverIcon(new ImageIcon(Frmc.class.getResource("/Imag/calendario.png")));
	        btnNewButton.setPressedIcon(new ImageIcon(Frmc.class.getResource("/Imag/calendario (1).png")));
	        btnNewButton.setBorder(null);
	        btnNewButton.setOpaque(false);
	        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnNewButton.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/calendario (1).png")));
	        frmFarmaciaUsuario.getContentPane().add(btnNewButton);

	        
			lblHora = new JLabel("");
			lblHora.setBounds(358, 13, 91, 25);
			lblHora.setBorder(new LineBorder(new Color(14, 203, 218), 2, true));
			frmFarmaciaUsuario.getContentPane().add(lblHora);
			
			JLabel lblNewLabel_2 = new JLabel("DevProg Innovations");
			lblNewLabel_2.setBounds(240, 163, 142, 21);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			frmFarmaciaUsuario.getContentPane().add(lblNewLabel_2);
			
			panel = new JPanel();
			panel.setBounds(10, 191, 439, 53);
			panel.setBorder(new LineBorder(new Color(0, 221, 221), 2, true));
			panel.setBackground(new Color(0, 221, 221));
			frmFarmaciaUsuario.getContentPane().add(panel);
			panel.setLayout(null);
			
			btnQuejas = new JButton("Quejas");
			btnQuejas.setFont(new Font("Times New Roman", Font.BOLD, 11));
			btnQuejas.setContentAreaFilled(false);
			btnQuejas.setBounds(0, 0, 89, 23);
			panel.add(btnQuejas);
			
			btnComentario = new JButton("Comentarios");
			btnComentario.setFont(new Font("Times New Roman", Font.BOLD, 11));
			btnComentario.setContentAreaFilled(false);
			btnComentario.setBounds(111, 0, 106, 23);
			panel.add(btnComentario);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(230, 44, 161, 127);
			lblNewLabel_1.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/Farmlog.jpg")));
			frmFarmaciaUsuario.getContentPane().add(lblNewLabel_1);

			
			
			
	    }
	    public void HoraMX() {
	    	new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ZonedDateTime mexicoTime = ZonedDateTime.now(ZoneId.of("America/Mexico_City"));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					lblHora.setText("Hora: "+mexicoTime.format(formatter));
				}
			}).start();
	    }
}
