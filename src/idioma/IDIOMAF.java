package idioma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class IDIOMAF {

	private JFrame frmIdiomaF;
	private JTextField txt1;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDIOMAF window = new IDIOMAF();
					window.frmIdiomaF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IDIOMAF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIdiomaF = new JFrame();
		frmIdiomaF.setIconImage(Toolkit.getDefaultToolkit().getImage(IDIOMAF.class.getResource("/BotonRadeo/cecytem-logo-D0CECF053F-seeklogo.com.png")));
		frmIdiomaF.setTitle("idioma f");
		frmIdiomaF.setBounds(100, 100, 861, 423);
		frmIdiomaF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIdiomaF.getContentPane().setLayout(null);
		frmIdiomaF.setLocationRelativeTo(null);
		txt1 = new JTextField();
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String texto=txt1.getText();
				texto=texto.replace("a", "afa");
				texto=texto.replace("e", "efe");
				texto=texto.replace("i", "ifi");
				texto=texto.replace("o", "ofo");
				texto=texto.replace("u", "ufu");
				texto=texto.replace("A", "AFA");
				texto=texto.replace("E", "EFE");
				texto=texto.replace("I", "IFI");
				texto=texto.replace("O", "OFO");
				texto=texto.replace("U", "UFU");
				
				txt2.setText(texto);
				
			}
		});
		txt1.setBounds(49, 10, 760, 124);
		frmIdiomaF.getContentPane().add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(49, 215, 760, 124);
		frmIdiomaF.getContentPane().add(txt2);
	}
}
