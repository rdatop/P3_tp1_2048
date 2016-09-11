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

		JLabel lblcmoJugar = new JLabel("\u00BFC\u00F3mo jugar 2048?");
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
		textArea.setText("*Utilizando las flechas arriba,abajo,izquierda y derecha se mueve el tablero"
				+ "\r\n*Con la letra D se deshace la última jugada."
				+ "\r\n*El objetivo del juego es llegar a los 2048 puntos.");
		textArea.setMaximumSize(new Dimension(42767, 42767));
		textArea.setEditable(false);
		panel.add(textArea);

	}
}
