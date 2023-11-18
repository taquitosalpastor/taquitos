package CCelular;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Toolkit;

public class CrudCelular {

	private JFrame frmCrudCelular;
	private JTextField txtIdCelular;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSistema;
	private JTextField txtProcesador;
	private JButton btnLimpiar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCargar;
	private JButton btnInsertar;
	Celular cel=new Celular();

	ArrayList<Celular> lisCelulars = new ArrayList<Celular>();
	private JButton btnPDF;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudCelular window = new CrudCelular();
					window.frmCrudCelular.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CrudCelular() {
		initialize();
	}

	
	private void initialize() {
		frmCrudCelular = new JFrame();
		frmCrudCelular.setIconImage(Toolkit.getDefaultToolkit().getImage(CrudCelular.class.getResource("/Redsociall/Memi and dash icons.jpg")));
		frmCrudCelular.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		frmCrudCelular.setTitle("CRUD Celular");
		frmCrudCelular.setBounds(100, 100, 450, 300);
		frmCrudCelular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrudCelular.getContentPane().setLayout(null);
		frmCrudCelular.setLocationRelativeTo(null);
		
		JLabel lblIdCel = new JLabel("IdCelular");
		lblIdCel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 15));
		lblIdCel.setBounds(10, 21, 81, 19);
		frmCrudCelular.getContentPane().add(lblIdCel);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 15));
		lblMarca.setBounds(10, 50, 81, 19);
		frmCrudCelular.getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 15));
		lblModelo.setBounds(10, 78, 81, 19);
		frmCrudCelular.getContentPane().add(lblModelo);
		
		JLabel lblSistema = new JLabel("Sistema");
		lblSistema.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 15));
		lblSistema.setBounds(10, 112, 81, 19);
		frmCrudCelular.getContentPane().add(lblSistema);
		
		JLabel lblProcesador = new JLabel("Procesador");
		lblProcesador.setFont(new java.awt.Font("Tahoma",  java.awt.Font.BOLD, 15));
		lblProcesador.setBounds(10, 143, 96, 19);
		frmCrudCelular.getContentPane().add(lblProcesador);
		
		txtIdCelular = new JTextField();
		txtIdCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtIdCelular.getText().length()>11) {
					e.consume();
					}
				}
		});
		txtIdCelular.setBounds(121, 23, 96, 19);
		frmCrudCelular.getContentPane().add(txtIdCelular);
		txtIdCelular.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtMarca.getText().length()>50) {
					e.consume();
					}
			}
		});
		txtMarca.setColumns(10);
		txtMarca.setBounds(121, 52, 96, 19);
		frmCrudCelular.getContentPane().add(txtMarca);
		
		txtModelo = new JTextField();
		txtModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtMarca.getText().length()>50) {
					e.consume();
					}
			}
		});
		txtModelo.setColumns(10);
		txtModelo.setBounds(121, 80, 96, 19);
		frmCrudCelular.getContentPane().add(txtModelo);
		
		txtSistema = new JTextField();
		txtSistema.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtSistema.getText().length()>50) {
					e.consume();
					}
			}
		});
		txtSistema.setColumns(10);
		txtSistema.setBounds(121, 112, 96, 19);
		frmCrudCelular.getContentPane().add(txtSistema);
		
		txtProcesador = new JTextField();
		txtProcesador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtProcesador.getText().length()>50) {
					e.consume();
					}
			}
		});
		txtProcesador.setColumns(10);
		txtProcesador.setBounds(121, 145, 96, 19);
		frmCrudCelular.getContentPane().add(txtProcesador);
		
		
		
		
		btnPDF = new JButton("PDF");
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
        btnPDF.setIcon(new ImageIcon(CrudCelular.class.getResource("/Imag/medi.png")));
        btnPDF. setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        btnPDF.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPDF.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPDF.setHorizontalAlignment(SwingConstants.CENTER);
        btnPDF.setBounds(287, 24, 97, 93);
        frmCrudCelular.getContentPane().add(btnPDF);
   
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Celular c=new Celular();
					c.setIdcel(Integer.parseInt(txtIdCelular.getText()));
					c.setMarca(txtMarca.getText());
					c.setModelo(txtModelo.getText());
					c.setSistema(txtSistema.getText());
					c.setProcesador(txtProcesador.getText());
					if(c.insertarCel()) {
						JOptionPane.showMessageDialog(null, "Se inserto Correctamente ");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"Error Al Insertar");
					}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
		});
		btnInsertar.setBounds(10, 183, 85, 21);
		frmCrudCelular.getContentPane().add(btnInsertar);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idcel=Integer.parseInt(JOptionPane.showInputDialog("ID A CARGAR"));
					cel.setIdcel(idcel);
					if(cel.cargaCel()) {
						txtIdCelular.setText(""+cel.getIdcel());
						txtMarca.setText(cel.getMarca());
						txtModelo.setText(cel.getModelo());
						txtProcesador.setText(cel.getProcesador());
						txtSistema.setText(cel.getSistema());
						JOptionPane.showMessageDialog(null, "SE CARGO CORRECTAMENTE");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR al Insertar");
						}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
		});
		btnCargar.setBounds(107, 183, 85, 21);
		frmCrudCelular.getContentPane().add(btnCargar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idcel=Integer.parseInt(JOptionPane.showInputDialog("Id a Eliminar"));
					cel.setIdcel(idcel);
					if(cel.eliminarCel()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
						
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
					}
				} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
				}
				
			}
		});
		btnEliminar.setBounds(202, 183, 85, 21);
		frmCrudCelular.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cel.setIdcel(Integer.parseInt(txtIdCelular.getText()));
					cel.setMarca(txtMarca.getText());
					cel.setModelo(txtModelo.getText());
					cel.setSistema(txtSistema.getText());
					cel.setProcesador(txtProcesador.getText());
					if(cel.actualizarCel()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se actualizo Correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
				}
			}
		});
		btnActualizar.setBounds(311, 183, 85, 21);
		frmCrudCelular.getContentPane().add(btnActualizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(311, 144, 85, 21);
		frmCrudCelular.getContentPane().add(btnLimpiar);
	}
	public void limpiar() {
		txtIdCelular.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtProcesador.setText("");
		txtSistema.setText("");
	}
	
	 public void generarPDF() {
         try {
                FileOutputStream archivo;
                
                File file = new File("C:\\Users\\jonht\\OneDrive\\Escritorio\\tacos-\\src\\pdf\\pdf.pdf");
                archivo = new FileOutputStream(file);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);
                doc.open();
               Image img = Image.getInstance("C:\\Users\\jonht\\OneDrive\\Escritorio\\tacos-\\src\\Imag\\FarmaciaLogo.png");

                img.setAlignment(Element.ALIGN_CENTER);
                img.scaleToFit(150, 150);
                doc.add(img);
                Paragraph p = new Paragraph(10);
                Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                p.add(Chunk.NEWLINE);
                p.add("CONTROL DE CELULARES");
                p.add(Chunk.NEWLINE);
                p.add(Chunk.NEWLINE);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);
                
                PdfPTable tabla = new PdfPTable(5);
                tabla.setWidthPercentage(100);
                PdfPCell c1 = new PdfPCell(new Phrase("ID CEL", negrita));
                PdfPCell c2 = new PdfPCell(new Phrase("MARCA", negrita));
                PdfPCell c3 = new PdfPCell(new Phrase("MODELO", negrita));
                PdfPCell c4 = new PdfPCell(new Phrase("SISTEMA", negrita));
                PdfPCell c5 = new PdfPCell(new Phrase("PROCESADOR", negrita));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                c3.setHorizontalAlignment(Element.ALIGN_CENTER);
                c4.setHorizontalAlignment(Element.ALIGN_CENTER);
                c5.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setBackgroundColor(BaseColor.CYAN);
                c2.setBackgroundColor(BaseColor.CYAN);
                c3.setBackgroundColor(BaseColor.CYAN);
                c4.setBackgroundColor(BaseColor.CYAN);
                c5.setBackgroundColor(BaseColor.CYAN);
                tabla.addCell(c1);
                tabla.addCell(c2);
                tabla.addCell(c3);
                tabla.addCell(c4);
                tabla.addCell(c5);
                
                DataCelular dc=new DataCelular();
                lisCelulars=dc.selectCelulares();
                for (Celular c : lisCelulars) {
                    tabla.addCell("" +c.getIdcel());
                    tabla.addCell("" + c.getMarca());
                    tabla.addCell("" + c.getModelo());
                    tabla.addCell("" + c.getSistema());
                    tabla.addCell("" + c.getProcesador());
                }
                doc.add(tabla);
                Paragraph p1 = new Paragraph(10);
                p1.add(Chunk.NEWLINE);
                p1.add("NÚMERO DE CELULARES: " + lisCelulars.size());
                p1.add(Chunk.NEWLINE);
                p1.add(Chunk.NEWLINE);
                p1.setAlignment(Element.ALIGN_RIGHT);
                doc.add(p1);
                doc.close();
                archivo.close();
                Desktop.getDesktop().open(file);
            } catch (FileNotFoundException ex) {
            } catch (DocumentException ex) {
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmCrudCelular, "" + ex.getMessage());
               
            }
    }
	 public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
	        java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho,
	                alto, java.awt.Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(imgEscalada);
	        return image;
	    }
}
	
	
	
	

