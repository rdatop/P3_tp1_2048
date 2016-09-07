package logica_negocio;

import java.util.Random;

import logica_negocio.Matriz;

public class GeneradorRandom {
	
	// Asigna posiciones aleatorias para llenado (coordenadas) y Nro(s) de llenado
	public static void AsignaPosRandom() {
		int fila = PosicionesRandom();
		int columna = PosicionesRandom();
		    
		while (Matriz.ObtenerElem(fila, columna)!=0) {
			fila = PosicionesRandom();
			columna = PosicionesRandom();
		}
		Matriz.PisarElemAnterior(fila, columna, AsignaNroRandom());
	}
	
	// Numero aleatorio entre 0 y 3 (coordenadas de la matriz)
	public static int PosicionesRandom() {
		int posiciones=4;
		Random rnd=new Random();
		return (int) rnd.nextInt(posiciones);
	}
	
	// Numero aleatorio entre 2 y 4 (valores a sumar)
	public static int AsignaNroRandom() {
		int nro=2;
		Random rnd=new Random();
		return (int) Math.pow(nro,rnd.nextInt(2)+1);
	}
		
	
		
	
}
