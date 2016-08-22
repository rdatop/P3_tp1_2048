package Puntuacion_Jugadores;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main
{
	/**
	 * Ejemplo de uso de BDExport.export().
	 *
	 * Crea unos cuantos jugadores, y le pide a la clase
	 * BDExport que los exporte.
	 */
	/* con el try/catch el main se hace cargo de las excepciones */
	public static void main(String[] args) {
		try {
			Exportador json = new ExportadorJSON("Jugadores.json");
			BDExport.export(json, JugadoresFicticios());// lista de Jugadores harcodeados
		} catch (IOException e) {
			System.out.println("no se pudo realizar la copia, el archivo esta siendo usado");
		}
	}

	/*
	 * Metodos auxiliares para tener algo que guardar......harcodeado
	 */
	private static List<Jugador> JugadoresFicticios() {// listaEmpleados
		return Arrays.asList(new Jugador("agustin", "4000"),
		                     new Jugador("pablito", "4500"),
		                     new Jugador("Pepe", "888"));
	}
}
