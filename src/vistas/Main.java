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
	
	//variables de instancia
	private JFrame _frameInicial;
	private JFrame _frameJuego;
	private JPanel _panelInicial;
	private JTextField _txtNombre;
	private String _nombreJugador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window._frameInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	// Manejo de LOOKANDFEEL
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
		_nombreJugador="";
		_frameInicial = new JFrame();
		_frameInicial.setBounds(400, 100, 450, 300);
		_frameInicial.setTitle("Powered by - @pablorecagno_and_@agustinrivas");
		_frameInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frameInicial.getContentPane().setLayout(new CardLayout(0, 0));
		
		_panelInicial = new JPanel();
		_panelInicial.setBorder(new EmptyBorder(5, 5, 5, 5));
		_frameInicial.getContentPane().add(_panelInicial, "name_14773862535808");
		_panelInicial.setLayout(null);
		
		JLabel lblBienvenidoA = new JLabel("Bienvenido a 2048");
		lblBienvenidoA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBienvenidoA.setBounds(99, 11, 253, 40);
		_panelInicial.add(lblBienvenidoA);
		
		_txtNombre = new JTextField();
		_txtNombre.setBounds(134, 72, 197, 34);
		_panelInicial.add(_txtNombre);
		_txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(78, 82, 46, 14);
		_panelInicial.add(lblNombre);
		
		JLabel lblNombreObligatorio = new JLabel("Debe ingresar un nombre");
		lblNombreObligatorio.setForeground(Color.RED);
		lblNombreObligatorio.setBounds(160, 117, 151, 14);
		lblNombreObligatorio.setVisible(false);
		_panelInicial.add(lblNombreObligatorio);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(134, 154, 89, 23);
		_panelInicial.add(btnJugar);
		
		JButton btnVerReglas = new JButton("Ver reglas");
		btnVerReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaReglas ventanaReglas=new VentanaReglas();
				ventanaReglas.setVisible(true);
			}
		});
		btnVerReglas.setBounds(242, 154, 89, 23);
		_panelInicial.add(btnVerReglas);
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(_txtNombre.getText().equals("")){
					lblNombreObligatorio.setVisible(true);
				}else{
					lblNombreObligatorio.setVisible(false);
					_nombreJugador=_txtNombre.getText();
					_frameInicial.setVisible(false);
					GeneradorTablero generador=new GeneradorTablero(_nombreJugador, _frameInicial);
					_frameJuego=generador.creaFrameJuego();
					_frameJuego.setVisible(true);
				}
			}
		});	
	}
}