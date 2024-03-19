package window;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Caballero;
import modelo.GestorBBDD;
import javax.swing.JLabel;

public class JFrameSeleccionDeCaballeros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	 
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameSeleccionDeCaballeros frame = new JFrameSeleccionDeCaballeros();
					frame.setVisible(true);
			} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public JFrameSeleccionDeCaballeros() {
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(contentPane);
		
		JLabel personaje1 = new JLabel();
		personaje1.setBounds(0, 0, 100, 75);
		personaje1.setIcon(new ImageIcon("C:\\\\Users\\\\plaiaundi\\\\eclipse-workspace\\\\RetoCaballeros\\\\recursos\\\\siegmeyer.png"));
		contentPane.add(personaje1);
		
	}

	public void rellenarConBotones() {
		//conectarse a la BBDD y traerme los caballeros
		
		GestorBBDD gestorBBDD = new GestorBBDD();	
		
		ArrayList<Caballero> caballeros = gestorBBDD.getCaballeros();
		
			for (Caballero caballero : caballeros) {
				
				JButton btnNewButton = new JButton(caballero.getNombre());
				contentPane.add(btnNewButton);
			} 
			
			 contentPane.revalidate();
		     contentPane.repaint();
		}

}
