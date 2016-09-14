package modelo;

public class Puntaje {

	//variables de instancia
	private String _nombreUsuario;
	private int _puntaje;
	
	// Constructor
	public Puntaje(String nombreUsuario,int puntaje){
		this._nombreUsuario=nombreUsuario;
		this._puntaje=puntaje;
	}
	
	// Getter y Setter
	public String getNombreUsuario(){
		return this._nombreUsuario;
	}
	public void set_nombreUsuario(String nombreUsuario){
		this._nombreUsuario = nombreUsuario;
	}
	public int getPuntaje(){
		return this._puntaje;
	}
	public void set_puntaje(int puntaje){
		this._puntaje = puntaje;
	}
}