package Puntuacion_Jugadores;

import java.io.IOException;

public class ExportadorJSON extends Exportador
{
	/* variables de instancia */
	boolean seenFirst;

	/* constructor */
	ExportadorJSON(String archivo) throws IOException {//
		super(archivo);
		seenFirst = false;// si bien esta inicializado, refuerza concepto
	}

	/* metodo creado debido a la herencia con Exportador */
	@Override
	public void guardarAtributos(Atributos atrs) {
		if (!seenFirst) {
			// apertura del arreglo.
			seenFirst = true;
			printer.print("[ ");
		}else{// Si no, la coma de separacion.
			printer.print(", ");
		}
		printer.print("{");
		for (String k : atrs.keySet()) {
			printer.print(" \"" + k + "\": \"" + atrs.get(k)
			              + ", ");
		}
		printer.println("} ]");
	}

	/* cierra el archivo */
	@Override
	public void cerrarArchivo() throws IOException {
		printer.println("]");
		super.cerrarArchivo();
	}
}
