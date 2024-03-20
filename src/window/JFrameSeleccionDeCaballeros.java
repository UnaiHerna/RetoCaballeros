package window;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modelo.Caballero;
import modelo.GestorBBDD;
import modelo.Lucha;

public class JFrameSeleccionDeCaballeros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel botonPane;
	private ArrayList<Caballero> caballerosPelea = new ArrayList<Caballero>();

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
		contentPane = new JPanel();
		contentPane.setSize(650, 575);

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel personaje1 = new JLabel();
		personaje1.setIcon(new ImageIcon("C:\\\\Users\\\\plaiaundi\\\\eclipse-workspace\\\\RetoCaballeros\\\\recursos\\\\siegmeyer.png")); // Cambia la ruta de la imagen
		contentPane.add(personaje1);
	}

	public void rellenarConBotones() {
		//conectarse a la BBDD y traerme los caballeros
		
		GestorBBDD gestorBBDD = new GestorBBDD();	
		int size = gestorBBDD.getCaballeros().size();
		ArrayList<Caballero> caballeros = gestorBBDD.getCaballeros();

		botonPane = new JPanel();
		
		botonPane.setLayout(new GridLayout(size, 2, 5, 0));
		
			for (Caballero caballero : caballeros) {
				
				JButton btnNewButton = new JButton(caballero.getNombre());
				JLabel label = new JLabel(caballero.toString());
				label.setHorizontalAlignment(SwingConstants.LEFT); // Configuración para que el texto se alinee a la izquierda
				btnNewButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
			        // Aquí puedes definir lo que quieras que haga el botón al ser clicado
			        if (caballerosPelea.size()<2) {
			        	caballerosPelea.add(caballero);
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Has elegido a " + caballero.getNombre());
			        }
			        else {
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Ya has elegido dos personajes");
			        }
		        }
		        });
				botonPane.add(btnNewButton);
				botonPane.add(label);
			} 
			JButton btnLucha = new JButton("LUCHAR");
			btnLucha.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
			        // Aquí puedes definir lo que quieras que haga el botón al ser clicado
			        if (caballerosPelea.size()<2) {
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Te falta por seleccionar algún personaje");
			        }
			        else {
			        	pelear(caballerosPelea);
			        	caballerosPelea.clear();
			        }
		        }
		        });
			
		contentPane.add(botonPane);
		contentPane.add(btnLucha);
		
	}

	protected void pelear(ArrayList<Caballero> caballerosPelea) {
		GestorBBDD gestorBBDD = new GestorBBDD();	
		Lucha lucha = new Lucha(new Date(),caballerosPelea.get(0),caballerosPelea.get(1));
		//Se llaman ganador y perdedor pero se decide en comienzo lucha quien será
		lucha.comienzoLucha(); 
		gestorBBDD.insertarLucha(lucha);
		JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "El ganador es... ¡¡¡" +lucha.getGanador().getNombre()+"!!!");
	}

}