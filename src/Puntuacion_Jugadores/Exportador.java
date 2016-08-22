package Puntuacion_Jugadores;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Clase abstracta extiende al Exportadores JSON */
public abstract class Exportador
{ 
	/* variables de instancia */
	protected BufferedWriter file;
	protected PrintWriter printer;

	/* constructor */
	public Exportador(String archivo) throws IOException {
		file = Files.newBufferedWriter(Paths.get(archivo),
		                               StandardCharsets.UTF_8);
		printer = new PrintWriter(file);
	}

	/* cierra el archivo del formatos JSON */
	public void cerrarArchivo() throws IOException {
		file.close();
	}

	/* guarda los atributos */
	public abstract void guardarAtributos(Atributos atrs) throws IOException;
}
