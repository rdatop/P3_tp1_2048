package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Main {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtNombre;
	private String nombreJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		nombreJugador="";
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBienvenidoA = new JLabel("Bienvenido a 2048");
		lblBienvenidoA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBienvenidoA.setBounds(99, 11, 253, 40);
		contentPane.add(lblBienvenidoA);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(155, 96, 197, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(99, 99, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNombreObligatorio = new JLabel("Debe ingresar un nombre");
		lblNombreObligatorio.setForeground(Color.RED);
		lblNombreObligatorio.setBounds(99, 134, 253, 14);
		lblNombreObligatorio.setVisible(false);
		contentPane.add(lblNombreObligatorio);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(txtNombre.getText().equals("")){
					lblNombreObligatorio.setVisible(true);
				}else
				{
					lblNombreObligatorio.setVisible(false);
					nombreJugador=txtNombre.getText();
				}
			}
		});
		btnJugar.setBounds(189, 156, 89, 23);
		contentPane.add(btnJugar);
		
		
	}

}
