package Puntuacion_Jugadores;

/**
 * Otra clase de ejemplo con varios atributos.
 */
public class Jugador implements Exportable
{
	/* variables de instancia */
	private String nombre;
	private String puntos;
	
	/* constructor */
	public Jugador(String nombre, String puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	/* getter de nombre */
	public String getNombre() {
		return nombre;
	}

	/* getter puntos */
	public String getCuil() {
		return puntos;
	}

	/* metodo creado debido a contrato con Exportable (interfaz)*/
	@Override
	public Atributos extraerAtributos() {
		Atributos extraidos = new Atributos();
		extraidos.put("Puntos", getCuil());
		extraidos.put("Nombre", getNombre());
		return extraidos;
	}
}
