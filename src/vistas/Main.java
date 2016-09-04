package vistas;

import java.awt.CardLayout;
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

//import logica_negocio.Matriz;

public class Main {

	private JFrame frame;
	private JPanel panelInicial;
	private JTextField txtNombre;
	@SuppressWarnings("unused")
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panelInicial = new JPanel();
		panelInicial.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panelInicial, "name_14773862535808");
		panelInicial.setLayout(null);
		
		JLabel lblBienvenidoA = new JLabel("Bienvenido a 2048");
		lblBienvenidoA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBienvenidoA.setBounds(99, 11, 253, 40);
		panelInicial.add(lblBienvenidoA);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(155, 96, 197, 20);
		panelInicial.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(99, 99, 46, 14);
		panelInicial.add(lblNombre);
		
		JLabel lblNombreObligatorio = new JLabel("Debe ingresar un nombre");
		lblNombreObligatorio.setForeground(Color.RED);
		lblNombreObligatorio.setBounds(99, 134, 253, 14);
		lblNombreObligatorio.setVisible(false);
		panelInicial.add(lblNombreObligatorio);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(189, 156, 89, 23);
		panelInicial.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(txtNombre.getText().equals("")){
					lblNombreObligatorio.setVisible(true);
				}else
				{
					lblNombreObligatorio.setVisible(false);
					nombreJugador=txtNombre.getText();
					//frame=new GeneradorTablero().creaFrameJuego(frame,new Matriz(),new JLabel[4][4]);
				}
			}
		});	
	}
}