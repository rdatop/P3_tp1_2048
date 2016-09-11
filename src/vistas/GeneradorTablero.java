package vistas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Font;
import logica_negocio.Matriz;
import logica_negocio.GeneradorRandom;

public class GeneradorTablero 
{
	private JFrame frame;
	public GeneradorTablero(){
		frame=new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY.brighter());
		frame.getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 57));
		seteaScorePuntaje(0);
	}
	
	public JFrame creaFrameJuego(Matriz MatrizJuego,JLabel[][] matrizLabels){
		
		oirEventosTeclado(frame, MatrizJuego, matrizLabels);
		configInicialFrameJuego(frame);
		
		MatrizJuego.iniciarMatriz();
		GeneradorRandom.asignaPosRandom();
		GeneradorRandom.asignaPosRandom();
		Border borde = BorderFactory.createLineBorder(Color.LIGHT_GRAY.darker(), 4);
		populaMatrizLabels(frame,matrizLabels,borde);
		creaTextosDeLabels(borde);
		return frame;
	}
	
	private void populaMatrizLabels(JFrame frameMatriz,JLabel[][] matrizLabels, Border borde) {
		for (int i = 0; i < matrizLabels.length; i++) {
			for (int j = 0; j < matrizLabels.length; j++) {
				int numero = Matriz.obtenerElem(i, j);
				
				//se crean las coordenadas iniciales con dos posibles colores
				if (numero != 0) {
					matrizLabels[i][j] = new JLabel(String.valueOf(Matriz.obtenerElem(i, j)));
					if(numero==2){//si es 2 celeste
						matrizLabels[i][j].setBackground(Color.PINK.brighter());
					}else{//si es 4 amarillo
						matrizLabels[i][j].setBackground(Color.PINK);
					}
				}else{
					matrizLabels[i][j] = new JLabel(String.valueOf(""));
				}
				
				// Para que se pueda ver el color de fondo
				matrizLabels[i][j].setOpaque(true);
				// centrado de la etiqueta
				matrizLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				// borde de etiqueta
				matrizLabels[i][j].setBorder(borde);
				// se colocan etiquetas en formulario
				frameMatriz.getContentPane().add(matrizLabels[i][j]);
			}
		}
	}

	/*-- Métodos auxiliares --*/
	private void oirEventosTeclado(JFrame frameMatriz, Matriz matrizJuego, JLabel[][] matrizJLabel) {
		frameMatriz.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				
					case KeyEvent.VK_LEFT:
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						frameMatriz.setTitle("Izq");
						matrizJuego.moverElementosIzq();	
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaScorePuntaje(matrizJuego.getPuntaje());
						break;	
						
					case KeyEvent.VK_RIGHT:
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						frameMatriz.setTitle("Der");
						matrizJuego.moverElementosDer();	
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaScorePuntaje(matrizJuego.getPuntaje());
						break;	
						
					case KeyEvent.VK_DOWN:
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						frameMatriz.setTitle("Abajo");
						matrizJuego.moverElementosAbajo();
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaScorePuntaje(matrizJuego.getPuntaje());
						break;
					case KeyEvent.VK_UP:
						Matriz._matrizAnterior=Matriz.getMatrizActual();
						frameMatriz.setTitle("Arriba");
						matrizJuego.moverElementosArriba();
						GeneradorRandom.asignaPosRandom();
						dibujarTablero(matrizJLabel);
						seteaScorePuntaje(matrizJuego.getPuntaje());
						break;
				
					case KeyEvent.VK_D:
						frame.setTitle("deshacer");
						matrizJuego.regresarAtras();
						dibujarTablero(matrizJLabel);
						System.out.println(matrizJuego.getPuntaje());
						break;
						
					case KeyEvent.VK_ESCAPE:
						frameMatriz.setTitle("salir");
						break;
				}
			}
			
		});
	}
	
	// Configuracion inicial de frame
	private void configInicialFrameJuego(JFrame frameMatriz) {
		frameMatriz.setResizable(false);
		//frameMatriz.setTitle("Juego_2048_SobreMatriz");
		seteaScorePuntaje(0);
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
						matrizJLabels[fila][colum].setBackground(Color.PINK.brighter());//CYAN
						break;
					case 4:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.PINK);//
						break;
					case 8:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.PINK.darker());//
						break;
					case 16:
						matrizJLabels[fila][colum].setText(String.valueOf(numero));
						matrizJLabels[fila][colum].setBackground(Color.YELLOW.brighter());//
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
	
	private void creaTextosDeLabels(Border borde) {
		// Se crean los textos que representan la matriz
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

		// centrado de etiquetas
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

		// borde de etiquetas
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
	
	private void seteaScorePuntaje(int puntaje){//setea el valor del puntaje
		//en el marco del frame
		frame.setTitle("Puntaje: "+puntaje);
	}
}
