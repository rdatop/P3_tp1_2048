package logica_negocio;

public class Matriz {

	//variables de instancia
	private static int [][] _MatrizActual;
	private int [][] _MatrizAnterior;
	public int [][] _MatrizBackup;

	//constructor
	public Matriz() {
		_MatrizActual=new int[4][4];
	}
	
	//inicializa toda la matriz en cero
	public void iniciarMatriz() {
		for (int fila = 0; fila < _MatrizActual.length; fila++) {//por cada filas
			for (int columna = 0; columna < _MatrizActual.length; columna++) {//todas las columnas
				pisarElemAnterior(fila, columna, 0);
			}
		}
	}
	
	//deshacer al juego anterios  ////problemas con este metodo arriba abajo
	public void regresarAtras() {
		_MatrizBackup=_MatrizActual;
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
		
	/** Desplazamientos de la Matriz:
	 * suma y desplaza los elem(s) de la Matriz 
	 * hacia Izq/Der/Arriba/Abajo*/
	
	// Apila los elementos desiguales a la Izq y suma si son ==
	public void moverElementosIzq() {
		_MatrizAnterior=_MatrizActual;
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		for (int fila = 0; fila < _MatrizActual.length; fila++) {
			int[] FilaRedimensionada = redimensionaFilaHaciaIzq(_MatrizActual[fila]);//valores
			for (int columna = 0; columna < _MatrizActual.length; columna++) {
				if (columna < FilaRedimensionada.length) {//si es menos que cant elem redimencionados
					MatrizAux[fila][columna] = FilaRedimensionada[columna];//mueve a la izq elementos
				}
			}
		}
		_MatrizActual=MatrizAux;//sobreescribe matriz
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
	
	
//	//--------------ACA PABLIN 
//	public void moverElementosDer() {
//		_MatrizAnterior=_MatrizActual;
//		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
//		for (int fila = 0; fila < _MatrizActual.length; fila++) {
//			int[] FilaRedimencionada = SumaFilaHaciaDer(_MatrizActual[fila]);
//			int columnaAux = 0;
//			for (int columna = _MatrizActual.length-1; columna>0; columna--) {
//				if (columna>=_MatrizActual.length -FilaRedimencionada.length) {// 
//					MatrizAux[fila][columna] =FilaRedimencionada[columnaAux];//posicion ;
//					columnaAux++;
//				} 
//			}
//		}
//		_MatrizActual=MatrizAux;
//	}
	
	// Apila los elementos desiguales a la Der y suma si son ==
	public void moverElementosDer() {
		_MatrizAnterior=_MatrizActual;
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		for (int fila = 0; fila < _MatrizActual.length; fila++) {
			int[] FilaRedimencionada = redimensionaFilaHaciaDer(_MatrizActual[fila]);
			int columnaAux = 0;
			for (int columna = 0; columna<_MatrizActual.length; columna++) {
				if (columna <_MatrizActual.length - FilaRedimencionada.length) {
					MatrizAux[fila][columna] = 0;
				} else {
					MatrizAux[fila][columna] = FilaRedimencionada[columnaAux];//posicion
					columnaAux++;
				}
			}
		}
		_MatrizActual=MatrizAux;
	}
	
	//Entrega un arreglo redimensionado con la suma hacia la Der
	public int[] redimensionaFilaHaciaDer(int[] fila) {
		int[] filaRedimencionada = obtenerFilaMovible(fila);
		if (filaRedimencionada.length >= 2){//si la fila tiene 2 o mas elementos
			for (int i = filaRedimencionada.length - 1; i > 0; i--) {//recorro hacia <--
				if (filaRedimencionada[i] == filaRedimencionada[i - 1]) {//compara
					filaRedimencionada[i] = filaRedimencionada[i] * 2;//suma los elem
					filaRedimencionada[i - 1] = 0;//pone en cero pos Izq
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

	/** la idea en este punto es rotar la matriz 90 grados a la derecha
	 * por lo que el movimiento Abajo esta relacionado directamente con
	 * movimiendo hacia la Derecha y el movimiento Arriba esta relacionado 
	 * directamente con movimiendo hacia la Izquierda, luego se restablece
	 * la matriz a su posicion original esperando algun otro movimiento*/
	
	// Apila los elementos hacia abajo y suma (elem ==) bolteando la matriz 90 grados
	public void moverElementosAbajo() {
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		bolteaMatriz_90_Der(MatrizAux);//boltea de lado la matriz
		_MatrizActual=bolteaMatriz_90_Der(MatrizAux);
		moverElementosDer();//equivalente a mover hacia abajo
		int[][] MatrizAux1 = new int[_MatrizActual.length][_MatrizActual.length];
		bolteaMatriz_90_Der(MatrizAux1);//normaliza la matriz
		_MatrizActual=bolteaMatriz_90_Der(MatrizAux1);
	}

	// Apila los elementos hacia arriba y suma (elem ==) bolteando la matriz 90 grados	
	public void moverElementosArriba() {
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		bolteaMatriz_90_Der(MatrizAux);//boltea la matriz
		_MatrizActual=bolteaMatriz_90_Der(MatrizAux);
		moverElementosIzq();//equivalente a mover hacia arriba
		int[][] MatrizAux1 = new int[_MatrizActual.length][_MatrizActual.length];
		bolteaMatriz_90_Der(MatrizAux1);//normaliza la matriz
		_MatrizActual=bolteaMatriz_90_Der(MatrizAux1);
	}
	
	//boltea la matriz 90 grados a la derecha
	private int[][] bolteaMatriz_90_Der(int[][] MatrizAux) {
		for (int fila = 0; fila <_MatrizActual.length; fila++) {
			int[] FilaActual = obtenerBloque(fila);
			for (int columna = 0; columna < _MatrizActual.length; columna++) {
				if (columna < FilaActual.length) {//si la iteracion es < a la cant de elementos de la fila
					MatrizAux[columna][fila] = FilaActual[columna];//rota 
				}
			}
		}
		return MatrizAux;
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
