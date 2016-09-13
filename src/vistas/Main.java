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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Main {

	private JFrame frameInicial;
	private JFrame frameJuego;
	private JPanel panelInicial;
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
					window.frameInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	/*manejo de LOOKANDFEEL
	* iniciamos con el cambio de interfaz
	* eso se hace desde el UIManager con un try/catch*/
	public Main() {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		nombreJugador="";
		frameInicial = new JFrame();
		frameInicial.setBounds(400, 100, 450, 300);
		frameInicial.setTitle("Powered by - @pablorecagno_and_@agustinrivas");
		frameInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicial.getContentPane().setLayout(new CardLayout(0, 0));
		
		panelInicial = new JPanel();
		panelInicial.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameInicial.getContentPane().add(panelInicial, "name_14773862535808");
		panelInicial.setLayout(null);
		
		JLabel lblBienvenidoA = new JLabel("Bienvenido a 2048");
		lblBienvenidoA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBienvenidoA.setBounds(99, 11, 253, 40);
		panelInicial.add(lblBienvenidoA);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(134, 72, 197, 34);
		panelInicial.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(78, 82, 46, 14);
		panelInicial.add(lblNombre);
		
		JLabel lblNombreObligatorio = new JLabel("Debe ingresar un nombre");
		lblNombreObligatorio.setForeground(Color.RED);
		lblNombreObligatorio.setBounds(160, 117, 151, 14);
		lblNombreObligatorio.setVisible(false);
		panelInicial.add(lblNombreObligatorio);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(134, 154, 89, 23);
		panelInicial.add(btnJugar);
		
		JButton btnVerReglas = new JButton("Ver reglas");
		btnVerReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaReglas ventanaReglas=new VentanaReglas();
				ventanaReglas.setVisible(true);
			}
		});
		btnVerReglas.setBounds(242, 154, 89, 23);
		panelInicial.add(btnVerReglas);
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(txtNombre.getText().equals("")){
					lblNombreObligatorio.setVisible(true);
				}else
				{
					lblNombreObligatorio.setVisible(false);
					nombreJugador=txtNombre.getText();
					frameInicial.setVisible(false);
					frameJuego=InstanciadorFrameTablero.instanciaTablero(nombreJugador, frameInicial);
					frameJuego.setVisible(true);
				}
			}
		});	
	}
}