package logica_negocio;

public class Matriz {

	// Variables de instancia
	private static int [][] _MatrizActual;
	public static int [][] _MatrizAnterior;
	
	// Constructor
	public Matriz() {
		_MatrizActual=new int[4][4];
	}
	
	// Inicializa toda la matriz en cero
	public void iniciarMatriz() {
		for (int fila = 0; fila < _MatrizActual.length; fila++) {//por cada filas
			for (int columna = 0; columna < _MatrizActual.length; columna++) {//todas las columnas
				pisarElemAnterior(fila, columna, 0);
			}
		}
	}
	
	// Entrega una version segura de la Matriz para deshacer
	public static int[][] getMatrizActual(){
		return _MatrizActual;
	}
	// Deshacer al juego anterios  
	public void regresarAtras() {
		_MatrizActual=_MatrizAnterior;
	}
	
	// Obtener elemento segun coordenada
	public static int obtenerElem(int fila, int columna) {
		return _MatrizActual[fila][columna];
	}
		
	// Pisar elemento segun coordenada
	public static void pisarElemAnterior(int fila, int columna, int elemento) {
		_MatrizActual[fila][columna] = elemento;
	}
		
	/** Desplazamientos de la Matriz: Izq / Der
	 * suma y desplaza los elem(s) de la Matriz 
	 * hacia Izq/Der.
	 * Particularmente todo de apoya en el movimiento a la Izquierda,
	 * luego espeja la Matriz generando el movimiento a la Derecha*/
	
	// Apila los elementos desiguales a la Izq y suma si son ==
	public void moverElementosIzq() {
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		for (int fila = 0; fila < _MatrizActual.length; fila++) {
			int[] FilaRedimensionada = redimensionaFilaHaciaIzq(_MatrizActual[fila]);
			for (int columna = 0; columna < _MatrizActual.length; columna++) {
				if (columna < FilaRedimensionada.length) {//si es menos que cant elem redimencionados
					MatrizAux[fila][columna] = FilaRedimensionada[columna];//mueve a la izq elementos
				}
			}
		}
		_MatrizActual=MatrizAux;
	}
	
	//Entrega un arreglo redimensionado con la suma hacia la Izq
	public int[] redimensionaFilaHaciaIzq(int[] fila) {
		int[] filaRedimencionada = obtenerFilaMovible(fila);
		if (filaRedimencionada.length >= 2){//si la fila tiene 2 o mas elementos
			for (int i = 0; i < filaRedimencionada.length - 1; i++) {//recorro hacia -->
				if (filaRedimencionada[i] == filaRedimencionada[i + 1]) {
					filaRedimencionada[i] = filaRedimencionada[i] * 2;//suma
					filaRedimencionada[i + 1] = 0;//pone en cero por Der
				}
			}
		}
		filaRedimencionada = obtenerFilaMovible(filaRedimencionada);//redimenciona si no queda lugar libre
		return filaRedimencionada;
	}
	
	// Entrega un arreglo por fila de la matriz con elem para ser desplazados
	public int[] obtenerFilaMovible(int[] fila){
		int Elemento = 0;
		int[] BloqueMovible = new int[tamanoBloqueMovible(fila)];
		for (int j = 0; j < fila.length; j++) {//for copiado de elem
			if (fila[j] != 0) {
				BloqueMovible[Elemento] = fila[j];
				Elemento++;
			}
		}
		return BloqueMovible;
	}
		
	// Entrega el tamano del arreglo Bloque de elementos a desplazar
	public int tamanoBloqueMovible(int[] fila){
		int BloqueTamano = 0;
		for (int i = 0; i < fila.length; i++) {//for tamaño del arreglo
			if (fila[i] != 0) {
				BloqueTamano++;
			}
		}
		return BloqueTamano;
	}
	
	// Apila los elementos desiguales a la Der y suma si son ==
	public void moverElementosDer() {
		matrizEspejada();
		moverElementosIzq();
		matrizEspejada();
	}
	
	// Espeja la matriz por fila invirtiendo las columnas
	public void matrizEspejada() {
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		for (int fila = 0; fila < _MatrizActual.length; fila++) {
			int columnaAux=0;
			for (int columna = _MatrizActual.length-1; columna>=0; columna--) {
				MatrizAux[fila][columnaAux] = _MatrizActual[fila][columna]; //rellenamos cambiando el orden de los índices
				columnaAux++;
			}
        }
		_MatrizActual=MatrizAux;
    }

	/** Desplazamientos de la Matriz: Abajo / Arriba
	 * suma y desplaza los elem(s) de la Matriz hacia Arriba/Abajo.
	 * La idea en este punto es rotar la matriz 90 grados a la derecha
	 * por lo que el movimiento Abajo esta relacionado directamente con
	 * movimiendo hacia la Derecha y el movimiento Arriba esta relacionado 
	 * directamente con movimiendo hacia la Izquierda, luego se restablece
	 * la matriz a su posicion original esperando algun otro movimiento*/

	// Apila los elementos hacia abajo y suma (elem ==) bolteando la matriz 90 grados
	public void moverElementosAbajo() {
		bolteaMatriz_90_Der();//bolteo matriz
		moverElementosDer();//equivalente a mover hacia abajo
		bolteaMatriz_90_Der();//regreso matriz
	}

	// Apila los elementos hacia arriba y suma (elem ==) bolteando la matriz 90 grados	
	public void moverElementosArriba() {
		bolteaMatriz_90_Der();//bolteo matriz
		moverElementosIzq();//equivalente a mover hacia arriba
		bolteaMatriz_90_Der();//regreso matriz
	}
		
	// Boltea la matriz 90 grados a la derecha
	private void bolteaMatriz_90_Der() {
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		for (int fila = 0; fila <_MatrizActual.length; fila++) {
			int[] FilaActual = obtenerBloque(fila);
			for (int columna = 0; columna < _MatrizActual.length; columna++) {
				if (columna < FilaActual.length) {//si la iteracion es < a la cant de elementos de la fila
					MatrizAux[columna][fila] = FilaActual[columna];//rota 
				}
			}
		}
		_MatrizActual=MatrizAux;
	}

	// Obtener un bloque de la matriz (fila) y colocarla en un arreglo (movimiento en bloques)
	public int[] obtenerBloque(int indice) {
		int[] bloqueAux = new int[_MatrizActual.length];
		for (int j = 0; j < _MatrizActual.length; j++) {//pos de acuerdo a la matriz 4/8/16
			bloqueAux[j] = obtenerElem(indice,j);
		}
		return bloqueAux;
	}
}
