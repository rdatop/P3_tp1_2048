package vistas;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class VentanaReglas extends JFrame {//extiende de reglas

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReglas frame = new VentanaReglas();
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
	public VentanaReglas() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 498, 338);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		btnNewButton = new JButton("Entendido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(196, 271, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblcmoJugar = new JLabel("\u00BFC\u00F3mo jugar 10.000?");
		lblcmoJugar.setForeground(new Color(255, 51, 0));
		lblcmoJugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcmoJugar.setBounds(163, 5, 155, 20);
		contentPane.add(lblcmoJugar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 23, 462, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(0, 0, 462, 247);
		textArea.setText("El primer jugador lanza los seis dados. \r\nLuego de este lance, el jugador debe seleccionar qu\u00E9 dados se  guardan para sumar \r\ny lanzar los restantes, para intentar obtener la mayor cantidad de puntos.\r\n\r\nLos puentos se pueden sumar segun las siguientes combinaciones de dados:\r\n\r\n1. Cualquier dado que muestre un 1 vale 100 puntos.\r\n2. Cualquier dado que muestre un 5 vale 50 puntos.\r\n3. Tres dados iguales valen 100 veces el n\u00FAmero de los dados \r\n(por ejemplo, 3+3+3 = 300 puntos); excepto el tr\u00EDo de unos, que vale 1000 puntos.\r\n4. Cuatro dados iguales valen 200 veces el n\u00FAmero de los dados \r\n(por ejemplo, 4 +4 + 4 = 400 puntos mientras que 4 + 4 + 4 + 4 = 800 puntos).\r\n5. Tres pares de dados iguales valen 1.000 puntos.\r\n6. Una escalera de 5 dados (1 + 2 + 3 + 4 + 5 o 2 + 3 + 4 + 5 + 6) vale 500 puntos.\r\n7. Una escalera de 6 dados (1 + 2 + 3 + 4 + 5 + 6) vale 1.500 puntos.\r\n\r\nUna vez lanzados los dados, el jugador encierra algunos de los dados y vuelve a \r\nlanzar los restantes. Para esto de deben seleccionar los dados desde el checkbox \r\ny presionando el bot\u00F3n sumar\r\n\r\nSi al volver a lanzar los dados no obtiene m\u00E1s puntos que antes, entonces pierde \r\ntodos los puntos y el turno pasa al siguiente jugador. \r\n\r\nSi al volver a lanzar los dados se obtienen m\u00E1s puntos que en el lanzamiento anterior, \r\nel jugador puede dar por terminado su turno (y sumar los puntos obtenidos) o \r\nencerrar algunos de los dados lanzados y volver a lanzar. \r\n\r\nEl juego contin\u00FAa por turnos hasta que alg\u00FAn jugador llega a 10.000 puntos. \r\nEse jugador es el ganador.");
		textArea.setMaximumSize(new Dimension(42767, 42767));
		textArea.setEditable(false);
		panel.add(textArea);

	}
}
