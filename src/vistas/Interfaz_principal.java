package vistas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import logica_negocio.Matriz;

public class Interfaz_principal {

	private static final JLabel[][] matrizLabels = new JLabel[4][4];
	private JFrame frameMatriz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_principal window = new Interfaz_principal();
					window.frameMatriz.setVisible(true);
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
		
		//crea vista de juego
		frameMatriz = new JFrame();
		GeneradorTablero generador=new GeneradorTablero();
		generador.creaFrameJuego(frameMatriz, juego, matrizLabels);
		frameMatriz.setVisible(false);
	}
}
