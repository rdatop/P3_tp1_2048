package logica_negocio;

import java.util.Random;

public class Matriz {
	
	//variable de instancia
	private int[][] _MatrizActual;
		
	// Constructor
	public Matriz() {
		_MatrizActual = new int[4][4];
	}
	
	// Inicializa toda la matriz en cero
	public void IniciarMatriz() {
		for (int fila = 0; fila < _MatrizActual.length; fila++) {//por cada filas
			for (int columna = 0; columna < _MatrizActual.length; columna++) {//todas las columnas
				PisarElem(fila, columna, 0);//null
			}
		}
	}

	/**-------Generacion aleatoria de Nro(s) y Posiciones------*/
	// Numero aleatorio entre 2 y 4 (valores a sumar)
	public int NroRandom() {
		int nro=2;
		Random rnd=new Random();
		return (int) Math.pow(nro,rnd.nextInt(2)+1);
	}
	
	// Numero aleatorio entre 0 y 3 (coordenadas de la matriz)
	public int PosicionesRandom() {
		int posiciones=4;
		Random rnd=new Random();
		return (int) rnd.nextInt(posiciones);//Math.floor(Math.random() * 4);
	}
	
	// Asigna posiciones aleatorias para llenado (coordenadas)
	public void AsignaPosRandom() {
		int fila = PosicionesRandom();
	    int columna = PosicionesRandom();
	    
	    while (ObtenerElem(fila, columna)!=0) {
	      fila = PosicionesRandom();
	      columna = PosicionesRandom();
	    }
	    PisarElem(fila, columna, NroRandom());
	}
	/**--------------------------------------------------------*/
	
	// Obtener elemento segun coordenada
	public int ObtenerElem(int fila, int columna) {
		return _MatrizActual[fila][columna];
	}
		
	// Pisar elemento segun coordenada
	public void PisarElem(int fila, int columna, int elemento) {
		this._MatrizActual[fila][columna] = elemento;
	}
		
	// Obtener una fila de la matriz y colocarla en un arreglo (movimiento en bloques)
	public int[] ObtenerFila(int fila) {
		int[] filaAux = new int[4];
		for (int j = 0; j < 4; j++) {
			filaAux[j] = ObtenerElem(fila, j);
		}
		return filaAux;
	}
	
	// Entrega una fila de la matriz con un bloque de elementos para ser desplazados
	public int[] ObtenerFilaMovible(int[] fila){
		int ElemMovibles = 0;
		for (int i = 0; i < fila.length; i++) {
			if (fila[i] != 0) {
				ElemMovibles++;
			}
		}
		int TamañoDelBloque = 0;
		int[] BloqueMovible = new int[ElemMovibles];
		for (int i = 0; i < fila.length; i++) {
			if (fila[i] != 0) {
				BloqueMovible[TamañoDelBloque] = fila[i];
				TamañoDelBloque++;
			}
		}
		return BloqueMovible;
	}
	
	/**------Suma y desplaza elementos Izq/Der/Arriba/Abajo--------*/
	//Entrega un arreglo redimencionado con la suma hacia la Izq
	public int[] SumaFilaHaciaIzq(int[] fila) {
		int[] filaRedimencionada = ObtenerFilaMovible(fila);
		if (filaRedimencionada.length >= 2){//si la fila tiene 2 o mas elementos
			for (int i = 0; i < filaRedimencionada.length - 1; i++) {//recorro hacia -->
				if (filaRedimencionada[i] == filaRedimencionada[i + 1]) {
					filaRedimencionada[i] = filaRedimencionada[i] * 2;
					filaRedimencionada[i + 1] = 0;//null//i++;
				}
			}
		}
		filaRedimencionada = ObtenerFilaMovible(filaRedimencionada);//redimenciona si no queda lugar libre
		return filaRedimencionada;
	}
	
	//Entrega un arreglo redimencionado con la suma hacia la Der
	public int[] SumaFilaHaciaDer(int[] fila) {
		int[] filaRedimencionada = ObtenerFilaMovible(fila);
		if (filaRedimencionada.length >= 2){//si la fila tiene 2 o mas elementos
			for (int i = filaRedimencionada.length - 1; i > 0; i--) {//recorro hacia <--
				if (filaRedimencionada[i] == filaRedimencionada[i - 1]) {
					filaRedimencionada[i] = filaRedimencionada[i] * 2;
					filaRedimencionada[i - 1] = 0;//null//i--;
				}
			}
		}
		filaRedimencionada = ObtenerFilaMovible(filaRedimencionada);//redimenciona si no queda lugar libre
		return filaRedimencionada;
	}
	
	// Apila los elementos desiguales a la Izq
	public void MoverHaciaIzq() {
		//_MatrizAnterior = _MatrizActual;
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		for (int fila = 0; fila < _MatrizActual.length; fila++) {
			int[] FilaRedimencionada = SumaFilaHaciaIzq(this._MatrizActual[fila]);//valores
			for (int columna = 0; columna < _MatrizActual.length; columna++) {
				if (columna < FilaRedimencionada.length) {//si tiene valor
					MatrizAux[fila][columna] = FilaRedimencionada[columna];//mueve a la izq valores
				}
			}
		}
		this._MatrizActual = MatrizAux;
	}
	
	// Apila los elementos desiguales a la Izq-----no me gusta no lo puedo hacer de otra manera(refactorizar)
	public void MoverHaciaDer() {
		//_MatrizAnterior = _MatrizActual;
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		for (int fila = 0; fila < _MatrizActual.length; fila++) {
			int[] FilaRedimencionada = SumaFilaHaciaDer(_MatrizActual[fila]);
			int columnaAux = 0;
			for (int columna = 0; columna<_MatrizActual.length; columna++) {
				if (columna < _MatrizActual.length - FilaRedimencionada.length) {
					MatrizAux[fila][columna] = 0;
				} else {
					MatrizAux[fila][columna] = FilaRedimencionada[columnaAux];//posicion
					columnaAux++;
				}
			}
		}
		_MatrizActual = MatrizAux;
	}
	
	// Apila los elementos desiguales hacia abajo moviendo la matriz 90 grados (dos veces) y moviendo a la Derecha
	public void MoverHaciaAbajo() {
		//mueve 90 grados la primera vez
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		_MatrizActual.toString();
		for (int fila = 0; fila < _MatrizActual.length; fila++) {//recorre filas
			int[] FilaActual = ObtenerFila(fila);//guarda los elementos no nulos de la fila en un arreglo
			
			for (int columna = 0; columna < _MatrizActual.length; columna++) {//por cada fila recorre columnas
				if (columna < FilaActual.length) {//si la iteracion es < a la cant de elementos de la fila con valores
					MatrizAux[columna][fila] = FilaActual[columna];//rota 
				} else {
					MatrizAux[columna][fila] = 0;
				}
			}
		}
		MatrizAux.toString();
		_MatrizActual = MatrizAux;
		
		//una vez que la matriz esta bolteada mueve hacia la derecha
		MoverHaciaDer();
		
		//despues la coloca de forma normal
		int[][] MatrizAux1 = new int[_MatrizActual.length][_MatrizActual.length];
		_MatrizActual.toString();
		for (int fila = 0; fila < _MatrizActual.length; fila++) {//recorre filas
			int[] FilaActual = ObtenerFila(fila);//guarda los elementos no nulos de la fila en un arreglo
			
			for (int columna = 0; columna < _MatrizActual.length; columna++) {//por cada fila recorre columnas
				if (columna < FilaActual.length) {//si la iteracion es < a la cant de elementos de la fila con valores
					MatrizAux1[columna][fila] = FilaActual[columna];//rota 
				} else {
					MatrizAux1[columna][fila] = 0;
				}
			}
		}
		MatrizAux1.toString();
		_MatrizActual = MatrizAux1;
	}

	// Apila los elementos desiguales hacia abajo moviendo la matriz 90 grados (dos veces) y moviendo a la Derecha	
	public void MoverHaciaArriba() {
	//mueve 90 grados la primera vez
		int[][] MatrizAux = new int[_MatrizActual.length][_MatrizActual.length];
		_MatrizActual.toString();
		for (int fila = 0; fila < _MatrizActual.length; fila++) {//recorre filas
			int[] FilaActual = ObtenerFila(fila);//guarda los elementos no nulos de la fila en un arreglo
			
			for (int columna = 0; columna < _MatrizActual.length; columna++) {//por cada fila recorre columnas
				if (columna < FilaActual.length) {//si la iteracion es < a la cant de elementos de la fila con valores
					MatrizAux[columna][fila] = FilaActual[columna];//rota 
				} else {
					MatrizAux[columna][fila] = 0;
				}
			}
		}
		MatrizAux.toString();
		_MatrizActual = MatrizAux;
			
		//una vez que la matriz esta bolteada mueve hacia la derecha
		MoverHaciaIzq();
				
		//despues la coloca de forma normal
		int[][] MatrizAux1 = new int[_MatrizActual.length][_MatrizActual.length];
		_MatrizActual.toString();
		for (int fila = 0; fila < _MatrizActual.length; fila++) {//recorre filas
			int[] FilaActual = ObtenerFila(fila);//guarda los elementos no nulos de la fila en un arreglo
					
			for (int columna = 0; columna < _MatrizActual.length; columna++) {//por cada fila recorre columnas
				if (columna < FilaActual.length) {//si la iteracion es < a la cant de elementos de la fila con valores
					MatrizAux1[columna][fila] = FilaActual[columna];//rota 
				} else {
					MatrizAux1[columna][fila] = 0;
				}
			}
		}
		MatrizAux1.toString();
		_MatrizActual = MatrizAux1;
	}
	
	/**-------------------------------------------------------------------------------------*/
	
	//representacion de la matriz	
	  @Override
	  public String toString() {
		  String s = "";
		  
		  for (int i = 0; i < this._MatrizActual.length; i++) {
			  for (int j = 0; j < this._MatrizActual.length; j++) {
				  s += this._MatrizActual[i][j];
				  s += "\t";
			  }
			  
			  s += "\n";
		  }
		  
		  return s;
	  }
}
