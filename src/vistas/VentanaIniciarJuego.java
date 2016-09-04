package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaIniciarJuego extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIniciarJuego frame = new VentanaIniciarJuego();
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
	public VentanaIniciarJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
					lblNombreObligatorio.setVisible(true);//refactorizar!!!!!
				}else
				{
					lblNombreObligatorio.setVisible(false);
				}
			}
		});
		btnJugar.setBounds(189, 156, 89, 23);
		contentPane.add(btnJugar);
		
		JLabel lblBienvenidoA = new JLabel("Bienvenido a 2048");
		lblBienvenidoA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBienvenidoA.setBounds(99, 11, 253, 40);
		contentPane.add(lblBienvenidoA);
	}
}
