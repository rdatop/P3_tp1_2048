package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import logica_negocio.Matriz;

public class InstanciadorFrameTablero {

	public static JFrame instanciaTablero(String nombreJugador,JFrame frameInicial){
		GeneradorTablero generador=new GeneradorTablero(nombreJugador,frameInicial);
		JFrame frameJuego=generador.creaFrameJuego(new Matriz(),new JLabel[4][4]);
		return frameJuego;
	}
	
}
