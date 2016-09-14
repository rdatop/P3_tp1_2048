package logica_negocio;

import java.util.Random;
import logica_negocio.Matriz;

public class GeneradorRandom {
	
	// Asigna posiciones aleatorias para llenado (coordenadas) y Nro(s) de llenado
	public static void asignaPosRandom() {
		int fila = posicionesRandom();
		int columna = posicionesRandom();
		    
		while (Matriz.obtenerElem(fila, columna)!=0) {
			fila = posicionesRandom();
			columna = posicionesRandom();
		}
		Matriz.pisarElemAnterior(fila, columna, asignaNroRandom());
	}
	
	// Numero aleatorio entre 0 y 3 (coordenadas de la matriz)
	public static int posicionesRandom() {
		int posiciones=4;
		Random rnd=new Random();
		return (int) rnd.nextInt(posiciones);
	}
	
	// Numero aleatorio entre 2 y 4 (valores a sumar)
	public static int asignaNroRandom() {
		int nro=2;
		Random rnd=new Random();
		return (int) Math.pow(nro,rnd.nextInt(2)+1);
	}
}
