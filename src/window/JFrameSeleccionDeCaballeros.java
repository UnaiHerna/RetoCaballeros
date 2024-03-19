package window;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Caballero;
import modelo.GestorBBDD;

public class JFrameSeleccionDeCaballeros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrameSeleccionDeCaballeros frame = new JFrameSeleccionDeCaballeros();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public JFrameSeleccionDeCaballeros() {
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(650, 575);

		setContentPane(contentPane);
		
		JLabel personaje1 = new JLabel();
		personaje1.setBounds(0, 0, 100, 75); // Ajusta el tamaño del JLabel
		personaje1.setIcon(new ImageIcon("C:\\\\Users\\\\plaiaundi\\\\eclipse-workspace\\\\RetoCaballeros\\\\recursos\\\\siegmeyer.png")); // Cambia la ruta de la imagen
		contentPane.add(personaje1);
	}

	public void rellenarConBotones() {
		//conectarse a la BBDD y traerme los caballeros
		
		GestorBBDD gestorBBDD = new GestorBBDD();	
		
		ArrayList<Caballero> caballeros = gestorBBDD.getCaballeros();
		
			for (Caballero caballero : caballeros) {
				
				JButton btnNewButton = new JButton(caballero.getNombre());
				JLabel label = new JLabel(caballero.toString());
				label.setHorizontalAlignment(SwingConstants.LEFT); // Configuración para que el texto se alinee a la izquierda
				btnNewButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
			        // Aquí puedes definir lo que quieras que haga el botón al ser clicado
			        JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Has elegido a " + caballero.getNombre());
			        JButton btnNewButton = new JButton(caballero.getNombre());
		        }
		        });
				contentPane.add(btnNewButton);
				contentPane.add(label);
			} 
	}

}