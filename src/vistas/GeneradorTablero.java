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

import logica_negocio.Matriz;

public class GeneradorTablero 
{
	public static JFrame agregaKeyListener(JFrame frmMatriz,Matriz juego,JLabel[][] matriz)
	{
		frmMatriz.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						frmMatriz.setTitle("Arriba");
						juego.MoverHaciaArriba();
						juego.AsignaPosRandom();
						dibujarTablero(juego,matriz);
						break;
					case KeyEvent.VK_DOWN:
						frmMatriz.setTitle("Abajo");
						juego.MoverHaciaAbajo();
						juego.AsignaPosRandom();
						dibujarTablero(juego,matriz);
						break;
					case KeyEvent.VK_LEFT:
						frmMatriz.setTitle("Izq");
						juego.MoverHaciaIzq();	
						juego.AsignaPosRandom();
						dibujarTablero(juego,matriz);
						break;
					case KeyEvent.VK_RIGHT:
						frmMatriz.setTitle("Der");
						juego.MoverHaciaDer();	
						juego.AsignaPosRandom();
						dibujarTablero(juego,matriz);
						break;
					case KeyEvent.VK_ESCAPE:
						frmMatriz.setTitle("salir");
						break;
				}
			}
		});
		
		frmMatriz.setResizable(false);
		frmMatriz.setTitle("Matriz");
		frmMatriz.setBounds(100, 100, 480, 480);
		frmMatriz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Se crea una matriz 4x4 para acomodar las etiquetas
		frmMatriz.getContentPane().setLayout(new GridLayout(4, 4));

		
		juego.IniciarMatriz();
		juego.AsignaPosRandom();
		juego.AsignaPosRandom();

		Border borde = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);

		// Ahora se crea una matriz de JLabel
		// no puedo hacer q se vea desde Dsign porque se despelota
		// trate de hacer algo para que veas esto hacelo de nuevo vos porque es una porqueria
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				int numero = juego.ObtenerElem(i, j);
				
				// Se crean las etiquetas
				if (numero != 0) {
					matriz[i][j] = new JLabel(String.valueOf(juego.ObtenerElem(i, j)));
					matriz[i][j].setBackground(Color.CYAN);//.lightGray
				} else {
					matriz[i][j] = new JLabel(String.valueOf(""));
				}
				
				// Para que se pueda ver el color de fondo
				matriz[i][j].setOpaque(true);
				// centrado de la etiqueta
				matriz[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				// borde de etiqueta
				matriz[i][j].setBorder(borde);
				// se colocan etiquetas en formulario
				frmMatriz.getContentPane().add(matriz[i][j]);
			}
		}

		
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

		// Se agregan las etiquetas al formulario lo comente porque si no se despelota
		/*
		frmMatriz.getContentPane().add(lbl1);
		frmMatriz.getContentPane().add(lbl2);
		frmMatriz.getContentPane().add(lbl3);
		frmMatriz.getContentPane().add(lbl4);
		frmMatriz.getContentPane().add(lbl5);
		frmMatriz.getContentPane().add(lbl6);
		frmMatriz.getContentPane().add(lbl7);
		frmMatriz.getContentPane().add(lbl8);
		frmMatriz.getContentPane().add(lbl9);
		frmMatriz.getContentPane().add(lbl10);
		frmMatriz.getContentPane().add(lbl11);
		frmMatriz.getContentPane().add(lbl12);
		frmMatriz.getContentPane().add(lbl13);
		frmMatriz.getContentPane().add(lbl14);
		frmMatriz.getContentPane().add(lbl15);
		frmMatriz.getContentPane().add(lbl16);
		*/
		
		return frmMatriz;
	}
	
	public static void dibujarTablero(Matriz juego,JLabel[][] matrizJLabels) {
		for (int i = 0; i < matrizJLabels.length; i++) {
			for (int j = 0; j < matrizJLabels.length; j++) {
				int numero = juego.ObtenerElem(i, j);
				
				switch (numero) {
					case 0:
						matrizJLabels[i][j].setText("");
						matrizJLabels[i][j].setBackground(Color.LIGHT_GRAY);						
						break;
					case 2:
						matrizJLabels[i][j].setText(String.valueOf(numero));
						matrizJLabels[i][j].setBackground(Color.CYAN);
						break;
					case 4:
						matrizJLabels[i][j].setText(String.valueOf(numero));
						matrizJLabels[i][j].setBackground(Color.YELLOW);
						break;
					case 8:
						matrizJLabels[i][j].setText(String.valueOf(numero));
						matrizJLabels[i][j].setBackground(Color.ORANGE);
						break;
					case 16:
						matrizJLabels[i][j].setText(String.valueOf(numero));
						matrizJLabels[i][j].setBackground(Color.pink);
						break;
					case 32:
						matrizJLabels[i][j].setText(String.valueOf(numero));
						matrizJLabels[i][j].setBackground(Color.red);
						break;
					default:
						matrizJLabels[i][j].setText(String.valueOf(numero));
						matrizJLabels[i][j].setBackground(Color.DARK_GRAY);						
						break;
				}
			}
		}
	}
}
