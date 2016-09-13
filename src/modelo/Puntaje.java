package modelo;

public class Puntaje {

	//variables de instancia
	private String nombreUsuario;
	private int puntaje;
	
	// Constructor
	public Puntaje(String nombreUsuario,int puntaje)
	{
		this.nombreUsuario=nombreUsuario;
		this.puntaje=puntaje;
	}
	
	// Getter y Setter
	public String getNombreUsuario()
	{
		return this.nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario)
	{
		this.nombreUsuario = nombreUsuario;
	}
	public int getPuntaje() 
	{
		return this.puntaje;
	}
	public void setPuntaje(int puntaje)
	{
		this.puntaje = puntaje;
	}
}