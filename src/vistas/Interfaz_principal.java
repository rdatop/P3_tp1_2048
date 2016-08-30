package vistas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logica_negocio.Matriz;

public class Interfaz_principal {

	private static final JLabel[][] matriz = new JLabel[4][4];
	private JFrame frmMatriz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_principal window = new Interfaz_principal();
					window.frmMatriz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz_principal() {
		initialize(new Matriz());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Matriz juego) {
		frmMatriz = new JFrame();
		vistas.GeneradorTablero.agregaKeyListener(frmMatriz, juego, matriz);
	}
}
