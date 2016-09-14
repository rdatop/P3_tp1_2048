package modelo;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DAOPuntajes {

	//variables de instancia
	private Gson _gson;
	private String _nombreArchivo;
	private ArrayList<Puntaje> _listaPuntajes;
	
	// Constructor
	public DAOPuntajes(String nombreArchivo)throws IOException{
		this._gson=new Gson();
		this._nombreArchivo=nombreArchivo;
		this._listaPuntajes=this.desserializaJson(this._nombreArchivo);
	}
	
	// Agrega un puntaje a la lista de puntajes y lo registra en un archivo json
	public boolean agregarPuntaje(Puntaje puntaje){
		try {
		
			this._listaPuntajes.add(puntaje);
			
			String puntajesJson=this._gson.toJson(this._listaPuntajes);
			
			ManejadorArchivos.escribirGuardarArchivo(this._nombreArchivo,puntajesJson);
			
			return true;
		}catch (Exception excepcion) {
			return false;
		}	
	}
	
	//devuelve lista de puntajes y los usuarios que los obtuvieron
	public ArrayList<Puntaje> obtenerPuntajes(){
		return this._listaPuntajes;
	}
	
	public ArrayList<Puntaje> desserializaJson(String nombreArchivo)throws IOException{
		String json=ManejadorArchivos.leerArchivo(nombreArchivo);
		
		Type collectionType=new TypeToken<ArrayList<Puntaje>>(){}.getType();
		
		ArrayList<Puntaje> listaPuntajes=_gson.fromJson(json,collectionType);
		
		if(listaPuntajes==null){//sí el archivo está vacio
			listaPuntajes=new ArrayList<Puntaje>();//hago una lista vacía
		}
		
		return listaPuntajes;
	}
}