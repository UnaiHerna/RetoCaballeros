package window;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal {

	private JFrame frmLuchaMedieval;

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
	    
	    JButton btnNewButton = new JButton("LUCHAR");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFrameSeleccionDeCaballeros selectorCaballeros = new JFrameSeleccionDeCaballeros();

	    		selectorCaballeros.rellenarConBotones();
	    		selectorCaballeros.setVisible(true);
	    	}
	    });
	    btnNewButton.setBounds(270, 243, 108, 35);
	    frmLuchaMedieval.getContentPane().add(btnNewButton);
	    
	    // Crear un JLabel para la imagen de fondo
	    JLabel backgroundLabel = new JLabel();
	    backgroundLabel.setBounds(0, 0, 634, 536);
	    backgroundLabel.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\eclipse-workspace\\RetoCaballeros\\recursos\\fondo.png"));
	    	    
	    // Agregar el JLabel al JFrame
	    frmLuchaMedieval.getContentPane().add(backgroundLabel);
  
	}
}