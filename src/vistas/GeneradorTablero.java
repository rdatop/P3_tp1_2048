package vistas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Font;
import logica_negocio.Matriz;
import modelo.DAOPuntajes;
import modelo.Puntaje;
import logica_negocio.GeneradorRandom;

public class GeneradorTablero{
	
	//variables de instancia
	private JFrame frameTablero;
	private JFrame frameInicial;
	private String nombreJugador;
	private Matriz matrizJuego;
	private JLabel[][] matrizLabels;
	private String nombreArchivo;
	
	// Constructor
	public GeneradorTablero(String jugador,JFrame frameInicio){
		frameTablero=new JFrame();
		frameTablero.getContentPane().setForeground(Color.LIGHT_GRAY.brighter());
		frameTablero.getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 57));
		frameInicial=frameInicio;
		matrizJuego=new Matriz();
		matrizLabels=new JLabel[4][4];
		seteaDatosPartida(0);
		nombreJugador=jugador;
		nombreArchivo="puntajes.json";
	}
	
	// Crea el frame 
	public JFrame creaFrameJuego(){
		oirEventosTeclado(frameTablero, matrizJuego, matrizLabels);
		configInicialFrameJuego(frameTablero);
		matrizJuego.iniciarMatriz();
		GeneradorRandom.asignaPosRandom();
		GeneradorRandom.asignaPosRandom();
		Border borde = BorderFactory.createLineBorder(Color.LIGHT_GRAY.darker(), 4);
		populaMatrizLabels(frameTablero,matrizLabels,borde);
		creaTextosDeLabels(borde);
		return frameTablero;
	}
	
	// Llenado de Matriz
	private void populaMatrizLabels(JFrame frameMatriz,JLabel[][] matrizLabels, Border borde) {
		for (int i = 0; i < matrizLabels.length; i++) {
			for (int j = 0; j < matrizLabels.length; j++) {
				int numero = Matriz.obtenerElem(i, j);
				//se crean las coordenadas iniciales con dos posibles colores
				if (numero != 0) {
					matrizLabels[i][j] = new JLabel(String.valueOf(Matriz.obtenerElem(i, j)));
					if(numero==2){//si es 2 rosa claro
						matrizLabels[i][j].setBackground(Color.PINK.brighter());
					}else{//si es 4 rosa furton
						matrizLabels[i][j].setBackground(Color.PINK);
					}
				}else{
					matrizLabels[i][j] = new JLabel(String.valueOf(""));
				}
				matrizLabels[i][j].setOpaque(true);//color de fondo
				matrizLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);//centrado de texto
				matrizLabels[i][j].setBorder(borde);//borde de JLabels
				frameMatriz.getContentPane().add(matrizLabels[i][j]);//textos en la matriz de JLabels
			}
		}
	}

	/*-- Métodos auxiliares, acciones referentes a la interaccion con el usuario--*/
	private void oirEventosTeclado(JFrame frameMatriz, Matriz matrizJuego, JLabel[][] matrizJLabel) {
		frameMatriz.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				
					case KeyEvent.VK_LEFT:
						finalizarJuego();
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						matrizJuego.moverElementosIzq();	
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaDatosPartida(matrizJuego.getPuntajeActual());
						break;	
						
					case KeyEvent.VK_RIGHT:
						finalizarJuego();
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						matrizJuego.moverElementosDer();	
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaDatosPartida(matrizJuego.getPuntajeActual());
						break;	
						
					case KeyEvent.VK_DOWN:
						finalizarJuego();
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						matrizJuego.moverElementosAbajo();
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaDatosPartida(matrizJuego.getPuntajeActual());
						break;
						
					case KeyEvent.VK_UP:
						finalizarJuego();
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						matrizJuego.moverElementosArriba();
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaDatosPartida(matrizJuego.getPuntajeActual());
						break;
				
					case KeyEvent.VK_D:
						finalizarJuego();
						matrizJuego.regresarAtras();
						dibujarTablero(matrizJLabel);
						seteaDatosPartida(matrizJuego.getPuntajeActual());
						break;
													
					case KeyEvent.VK_ESCAPE:
						if(confirmacionDialog("Salir","Desea salir?")){
							System.exit(0);
						}
						break;
				}
			}
		});
	}
	
	// Finaliza el juego en caso que la matriz este completa
	public void finalizarJuego(){
		if(Matriz.matrizCompleta()==true){//si la matriz está completa
			//guardo el puntaje
			try{
				DAOPuntajes dao=new DAOPuntajes(nombreArchivo);
				dao.agregarPuntaje(new Puntaje(nombreJugador,matrizJuego.getPuntajeActual()));
			}catch(IOException excepcion){
				excepcion.printStackTrace();
			}
			
			if(confirmacionDialog("Game Over","Reintentar?")){//sí el usuario decide reintentar
				frameTablero.setVisible(false);/////quita la matriz
				frameInicial.setVisible(true);//////e inicia la presentacion inicial
			}else{//el usuario decidió no reintentar y es llevado a la ventana
			///de puntajes
				new VentanaPuntajes().instanciaPuntajes();
			}
			
		}
	}
	
	// Muestra un modal preguntandole
	private boolean confirmacionDialog(String titulo,String mensaje){
	    int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
	    if (respuesta == JOptionPane.YES_OPTION){
	      return true;
	    }
	    return false;
	}
	
	// Muestra el valor del puntaje en el marco del frame
	private void seteaDatosPartida(int puntaje){
		frameTablero.setTitle("Puntaje: "+puntaje+" - Jugador: "+nombreJugador);
	}
	// Configuracion inicial de frame
	private void configInicialFrameJuego(JFrame frameMatriz) {
		frameMatriz.setResizable(false);
		seteaDatosPartida(0);
		frameMatriz.setBounds(400, 100, 480, 480);
		frameMatriz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Se crea una matriz 4x4 para acomodar las etiquetas
		frameMatriz.getContentPane().setLayout(new GridLayout(4, 4));
	}
	
	
	// Se dibuja el tablero
	public static void dibujarTablero(JLabel[][] matrizJLabels) {
		for (int fila = 0; fila < matrizJLabels.length; fila++) {
			for (int colum = 0; colum < matrizJLabels.length; colum++) {
				int numero = Matriz.obtenerElem(fila, colum);
				
				switch (numero) {
					case 0:
						matrizJLabels[fila][colum].setText("");
						matrizJLabels[fila][colum].setBackground(Color.LIGHT_GRAY);						
						break;
					case 2:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.PINK.brighter());
						break;
					case 4:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.PINK);
						break;
					case 8:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.PINK.darker());
						break;
					case 16:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.YELLOW.brighter());
						break;
					case 32:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.ORANGE);
						break;
					case 64:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.ORANGE.darker());
						break;
					case 128:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.CYAN.brighter());
						break;                            
					case 256:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.YELLOW);
						break;
					case 512:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.YELLOW.darker());
						break;
					case 1024:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.RED.brighter());
						break;
					case 2048:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.RED);
						break;
					default:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.DARK_GRAY);						
						break;
				}
			}
		}
	}
	
	// Se crean los textos que representan la matriz
	private void creaTextosDeLabels(Border borde) {
		JLabel lbl1 = new JLabel("i0-j0");
		JLabel lbl2 = new JLabel("i0-j1");
		JLabel lbl3 = new JLabel("i0-j2");
		JLabel lbl4 = new JLabel("i0-j3");
		JLabel lbl5 = new JLabel("i1-j0");
		JLabel lbl6 = new JLabel("i1-j1");
		JLabel lbl7 = new JLabel("i1-j2");
		JLabel lbl8 = new JLabel("i1-j3");
		JLabel lbl9 = new JLabel("i2-j0");
		JLabel lbl10 = new JLabel("i2-j1");
		JLabel lbl11 = new JLabel("i2-j2");
		JLabel lbl12 = new JLabel("i2-j3");
		JLabel lbl13 = new JLabel("i3-j0");
		JLabel lbl14 = new JLabel("i3-j1");
		JLabel lbl15 = new JLabel("i3-j2");
		JLabel lbl16 = new JLabel("i3-j3");

		// Centrado de elementos dentro de la matriz de JLabels
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		lbl13.setHorizontalAlignment(SwingConstants.CENTER);
		lbl14.setHorizontalAlignment(SwingConstants.CENTER);
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		lbl16.setHorizontalAlignment(SwingConstants.CENTER);

		// Bordes de los JLabels
		lbl1.setBorder(borde);
		lbl2.setBorder(borde);
		lbl3.setBorder(borde);
		lbl4.setBorder(borde);
		lbl5.setBorder(borde);
		lbl6.setBorder(borde);
		lbl7.setBorder(borde);
		lbl8.setBorder(borde);
		lbl9.setBorder(borde);
		lbl10.setBorder(borde);
		lbl11.setBorder(borde);
		lbl12.setBorder(borde);
		lbl13.setBorder(borde);
		lbl14.setBorder(borde);
		lbl15.setBorder(borde);
		lbl16.setBorder(borde);
	}
}
