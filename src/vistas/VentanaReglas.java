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
public class VentanaReglas extends JFrame {

	//variables de instancia
	private JPanel _contentPane;
	private JButton _btnNewButton;

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
	 * Constructor create the frame.
	 */
	public VentanaReglas() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 498, 338);
		_contentPane = new JPanel();
		_contentPane.setBackground(SystemColor.menu);
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(_contentPane);
		_contentPane.setLayout(null);

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		_btnNewButton = new JButton("Entendido");
		_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		_btnNewButton.setBounds(196, 271, 89, 23);
		_contentPane.add(_btnNewButton);

		JLabel lblcmoJugar = new JLabel("\u00BFC\u00F3mo jugar 2048?");
		lblcmoJugar.setForeground(new Color(255, 51, 0));
		lblcmoJugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcmoJugar.setBounds(152, 0, 155, 20);
		_contentPane.add(lblcmoJugar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 23, 462, 247);
		_contentPane.add(panel);
		panel.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(0, 0, 462, 247);
		textArea.setText("El juego es simple, este consiste en desplazar la matriz en cuatro direcciones \r\ncos las flechas del cursor (arriba, abajo, derecha e izquierda) la matriz se \r\ndesplaza de forma integra sobre los espacios vac\u00EDos.\r\nEn cuanto las baldosas se muevan si hay dos iguales las mismas se suman,  \r\nel objetivo principal es que producto de la suma una baldosa llegue al valor \r\n2048.\r\n\r\n* Los controles son: Arriba \u2191 , Abajo \u2193, Izquierda \u2190 y Derecha \u2192.\r\n* Para deshacer una jugada presionar la letra (d).\r\n* Para reiniciar el juego presionar la tecla escape (Esc) respondiendo a la \r\n   consulta.\r\n* En caso de querer abandonar el juego solamente presiona con el click \r\n   izquierdo del mouse la caracter\u00EDstica X que se encuentra en la parte \r\n   superior derecha de la ventana principal.\r\n                BUENA SUERTE Y QUE LO DISFRUTES!!!!!!!!  {O u O}\r\n");
		textArea.setMaximumSize(new Dimension(42767, 42767));
		textArea.setEditable(false);
		panel.add(textArea);

	}
}
