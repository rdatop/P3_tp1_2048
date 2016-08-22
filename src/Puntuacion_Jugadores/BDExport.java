package Puntuacion_Jugadores;

import java.io.IOException;

public class BDExport
{
	public enum Formato {
		JSON,
	}

	/**
	 * Exporta una serie de objetos de la base de datos a un archivo.
	 *
	 * Recibe el nombre del archivo, el formato deseado (JSON), y
	 * la lista de objetos (Jugadores).
	 * @throws IOException */
	
	public static void export(Exportador exporter,
	                          Iterable<? extends Exportable> objetos)
	                        				  throws IOException {
		for (Exportable e : objetos) {// Para cada objeto, obtener y guardar sus atributos.
			Atributos atrs = e.extraerAtributos();
			exporter.guardarAtributos(atrs);
		}
		exporter.cerrarArchivo();
	}
}
