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
	private JLabel personaje = new JLabel();
	private int idBoton=0;
	private ArrayList<Caballero> caballerosPelea = new ArrayList<Caballero>();

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
		
		personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\siegmeyer.png")); // Cambia la ruta de la imagen
		contentPane.add(personaje);
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
		        	// Cambia la imagen por imagenes predefinidas
			        if (caballero.getNombre().toLowerCase().contains("havel")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\havel.png"));
			        }else if (caballero.getNombre().toLowerCase().contains("parches")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\parches.png"));
					}
					else if (caballero.getNombre().toLowerCase().contains("ricard")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\ricard.png"));
					}
					else if (caballero.getNombre().toLowerCase().contains("yuria")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\yuria.png"));
					}
					else if (caballero.getNombre().toLowerCase().contains("solaire")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\solaire.png"));
					}
					else if (caballero.getNombre().toLowerCase().contains("siegmeyer")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\siegmeyer.png"));
					}
					else if (caballero.getNombre().toLowerCase().contains("radahn")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\radahn.png"));
					}
					else if (caballero.getNombre().toLowerCase().contains("malenia")) {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\malenia.png"));
					}
					else {
						personaje.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\predeterminado.png"));
					}
		        	
		        	
			        //Comprueba cuantos han sido seleccionados
			        if (caballerosPelea.size()<2 && (idBoton!=caballero.getId())) {
			        	caballerosPelea.add(caballero);
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Has elegido a " + caballero.getNombre(),"", JOptionPane.INFORMATION_MESSAGE);
			        }else if (idBoton==caballero.getId()) {
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Ya has elegido este personaje anteriormente", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			        else {
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Ya has elegido dos personajes", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			        idBoton=caballero.getId();
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
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Te falta por seleccionar algún personaje", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			        else {
			        	pelear(caballerosPelea);
			        	caballerosPelea.clear();
			        }
		        }
		        });
			JButton btnClear = new JButton("LIMPIAR");
			btnClear.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
			        // Aquí puedes definir lo que quieras que haga el botón al ser clicado
			        if (caballerosPelea.size()>0) {
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "Se han desmarcado los caballeros", "", JOptionPane.INFORMATION_MESSAGE);
			        	caballerosPelea.clear();
			        }
			        else {
			        	JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "No has seleccionado ningún caballero", "Error", JOptionPane.ERROR_MESSAGE);
			        }
		        }
		        });
		
		contentPane.add(botonPane);
		contentPane.add(btnClear);
		contentPane.add(btnLucha);

	}

	protected void pelear(ArrayList<Caballero> caballerosPelea) {
		GestorBBDD gestorBBDD = new GestorBBDD();	
		Lucha lucha = new Lucha(new Date(),caballerosPelea.get(0),caballerosPelea.get(1));
		//Se llaman ganador y perdedor pero se decide en comienzo lucha quien será
		lucha.comienzoLucha(); 
		gestorBBDD.insertarLucha(lucha);
		JOptionPane.showMessageDialog(JFrameSeleccionDeCaballeros.this, "El ganador es... ¡¡¡" +lucha.getGanador().getNombre()+"!!!\n"
				+ "Esta lucha ha sido introducida en la base de datos","GANADOR", JOptionPane.INFORMATION_MESSAGE);
	}

}