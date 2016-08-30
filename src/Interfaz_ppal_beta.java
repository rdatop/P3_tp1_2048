import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Juego.Matriz;

public class Interfaz_ppal_beta {

	private static final JLabel[][] matriz = new JLabel[4][4];
	private JFrame frmMatriz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_ppal_beta window = new Interfaz_ppal_beta();
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
	public Interfaz_ppal_beta() {
		initialize(new Matriz());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Matriz juego) {
		frmMatriz = new JFrame();
		Juego.Tablero.agregaKeyListener(frmMatriz, juego, matriz);
	}
}
