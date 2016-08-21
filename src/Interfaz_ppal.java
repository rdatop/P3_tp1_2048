import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Interfaz_ppal {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtPuntos;
	private JTextField txtRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_ppal window = new Interfaz_ppal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz_ppal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane matriz_i0j0 = new JTextPane();
		matriz_i0j0.setFont(new Font("Dialog", Font.BOLD, 28));
		matriz_i0j0.setToolTipText("i0 j0");
		matriz_i0j0.setBounds(25, 165, 53, 53);
		
		JTextPane matriz_i0j1 = new JTextPane();
		matriz_i0j1.setBounds(84, 165, 53, 53);
		matriz_i0j1.setEditable(false);
		
		JTextPane matriz_i0j2 = new JTextPane();
		matriz_i0j2.setBounds(143, 165, 53, 53);
		matriz_i0j2.setEditable(false);
		
		JTextPane matriz_i0j3 = new JTextPane();
		matriz_i0j3.setBounds(202, 165, 53, 53);
		matriz_i0j3.setEditable(false);
		
		JTextPane matriz_i1j0 = new JTextPane();
		matriz_i1j0.setBounds(25, 224, 53, 53);
		matriz_i1j0.setEditable(false);
		
		JTextPane matriz_i1j1 = new JTextPane();
		matriz_i1j1.setBounds(84, 224, 53, 53);
		matriz_i1j1.setEditable(false);
		
		JTextPane matriz_i1j2 = new JTextPane();
		matriz_i1j2.setBounds(143, 224, 53, 53);
		matriz_i1j2.setEditable(false);
		
		JTextPane matriz_i1j3 = new JTextPane();
		matriz_i1j3.setBounds(202, 224, 53, 53);
		matriz_i1j3.setEditable(false);
		
		JTextPane matriz_i2j0 = new JTextPane();
		matriz_i2j0.setBounds(25, 283, 53, 53);
		matriz_i2j0.setEditable(false);
		
		JTextPane matriz_i2j1 = new JTextPane();
		matriz_i2j1.setBounds(84, 283, 53, 53);
		matriz_i2j1.setEditable(false);
		
		JTextPane matriz_i2j2 = new JTextPane();
		matriz_i2j2.setBounds(143, 283, 53, 53);
		matriz_i2j2.setEditable(false);
		
		JTextPane matriz_i2j3 = new JTextPane();
		matriz_i2j3.setBounds(202, 283, 53, 53);
		matriz_i2j3.setEditable(false);
		
		JTextPane matriz_i3j0 = new JTextPane();
		matriz_i3j0.setBounds(25, 342, 53, 53);
		matriz_i3j0.setEditable(false);
		
		JTextPane matriz_i3j1 = new JTextPane();
		matriz_i3j1.setBounds(84, 342, 53, 53);
		matriz_i3j1.setEditable(false);
		
		JTextPane matriz_i3j2 = new JTextPane();
		matriz_i3j2.setBounds(143, 342, 53, 53);
		matriz_i3j2.setEditable(false);
		
		JTextPane matriz_i3j3 = new JTextPane();
		matriz_i3j3.setBounds(202, 342, 53, 53);
		matriz_i3j3.setEditable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(matriz_i2j0);
		frame.getContentPane().add(matriz_i2j1);
		frame.getContentPane().add(matriz_i2j2);
		frame.getContentPane().add(matriz_i2j3);
		frame.getContentPane().add(matriz_i3j0);
		frame.getContentPane().add(matriz_i3j1);
		frame.getContentPane().add(matriz_i3j2);
		frame.getContentPane().add(matriz_i3j3);
		frame.getContentPane().add(matriz_i1j0);
		frame.getContentPane().add(matriz_i1j1);
		frame.getContentPane().add(matriz_i1j2);
		frame.getContentPane().add(matriz_i1j3);
		frame.getContentPane().add(matriz_i0j0);
		frame.getContentPane().add(matriz_i0j1);
		frame.getContentPane().add(matriz_i0j2);
		frame.getContentPane().add(matriz_i0j3);
		
		JLabel PonTuNombrelbl = new JLabel("Pon tu Nombre");
		PonTuNombrelbl.setFont(new Font("Dialog", Font.BOLD, 12));
		PonTuNombrelbl.setBounds(262, 200, 84, 16);
		frame.getContentPane().add(PonTuNombrelbl);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(350, 198, 126, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPuntuacon = new JLabel("Puntuac\u00EDon");
		lblPuntuacon.setBounds(267, 258, 84, 16);
		frame.getContentPane().add(lblPuntuacon);
		
		txtPuntos = new JTextField();
		txtPuntos.setBounds(350, 256, 84, 20);
		frame.getContentPane().add(txtPuntos);
		txtPuntos.setColumns(10);
		
		JLabel lblRecord = new JLabel("Record");
		lblRecord.setBounds(267, 318, 55, 16);
		frame.getContentPane().add(lblRecord);
		
		txtRecord = new JTextField();
		txtRecord.setColumns(10);
		txtRecord.setBounds(350, 316, 84, 20);
		frame.getContentPane().add(txtRecord);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(324, 151, 80, 24);
		frame.getContentPane().add(btnJugar);
		
		JButton btnOtraVez = new JButton("Otra Vez");
		btnOtraVez.setFont(new Font("Dialog", Font.BOLD, 10));
		btnOtraVez.setBounds(267, 371, 80, 24);
		frame.getContentPane().add(btnOtraVez);
		
		JTextPane txtRaglas = new JTextPane();
		txtRaglas.setEditable(false);
		txtRaglas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		txtRaglas.setText("\r\nEl juego es facil, tienes que llegar a 2048 en esta grilla 4 X 4. En cada turno, el jugador presiona una de las flechas del cursor y los numeros se mueven en la direccion especifcada por el usuario. En cada turno, aparece un nuevo numero en la grilla, que puede ser 2 o 4. Cuando dos numeros iguales colisionan se suman en una unica celda y asi hasta llegar a 2048......Mucha suerte!!");
		txtRaglas.setBounds(25, 12, 440, 117);
		frame.getContentPane().add(txtRaglas);
		
		JButton btnPosiciones = new JButton("Posiciones");
		btnPosiciones.setFont(new Font("Dialog", Font.BOLD, 10));
		btnPosiciones.setBounds(387, 371, 89, 24);
		frame.getContentPane().add(btnPosiciones);
	}
}
