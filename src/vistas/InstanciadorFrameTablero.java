package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import logica_negocio.Matriz;

public class InstanciadorFrameTablero {

	/*-- Devuelve una instancia del tablero de juego --*/
	public static JFrame instanciaTablero(String nombreJugador){
		GeneradorTablero generador=new GeneradorTablero(nombreJugador);
		JFrame frameJuego=generador.creaFrameJuego(new Matriz(),new JLabel[4][4]);
		return frameJuego;
	}	
}