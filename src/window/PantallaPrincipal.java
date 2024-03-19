package window;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import modelo.*;

public class PantallaPrincipal {

	private JFrame frmLuchaMedieval;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frmLuchaMedieval.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLuchaMedieval = new JFrame();
		frmLuchaMedieval.setTitle("LUCHA MEDIEVAL");
		frmLuchaMedieval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Establecer el tamaño del JFrame
	    frmLuchaMedieval.setSize(650, 575);
	    frmLuchaMedieval.getContentPane().setLayout(null);
	    
	    // Crear un JLabel para la imagen de fondo
	    JLabel backgroundLabel = new JLabel();
	    backgroundLabel.setBounds(0, 0, 634, 536);
	    backgroundLabel.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\fondo.png"));
	    	    
	    // Agregar el JLabel al JFrame
	    frmLuchaMedieval.getContentPane().add(backgroundLabel);
	    
	    //Boton y funcionalidad
	    JButton btnNewButton = new JButton("LUCHAR");
	    btnNewButton.setBounds(270, 243, 108, 35);
	    frmLuchaMedieval.getContentPane().add(btnNewButton);
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		btnNewButton.setVisible(false);
	    		backgroundLabel.setVisible(false);
	    		selectorPersonajes();
			}
	    });
	    
	}
	
	private void selectorPersonajes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GestorBBDD gestorBBDD = new GestorBBDD();	
		
		ArrayList<Caballero> caballeros = gestorBBDD.getCaballeros();
		
			for (Caballero caballero : caballeros) {
				
				JButton btnNewButton = new JButton(caballero.getNombre());
				contentPane.add(btnNewButton);
			} 
			
	    contentPane.revalidate();
		contentPane.repaint();

		contentPane.setVisible(true);
	}
}
