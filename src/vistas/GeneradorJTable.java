package vistas;

import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAOPuntajes;
import modelo.Puntaje;

public class GeneradorJTable {

	public JTable generaJTable(){
		//creamos el Modelo de la tabla con los datos anteriores
		DefaultTableModel dtm= new DefaultTableModel(new Object[0][0],nombreDeColumnas());
		JTable tablaPuntajes=new JTable(dtm);
		populaTableModel(dtm);
		return tablaPuntajes; 
	}
	
	public void populaTableModel(DefaultTableModel dtm){
		try{
			DAOPuntajes dao=new DAOPuntajes("puntajes.json");
			
			for(Puntaje punt:dao.obtenerPuntajes()){
				Object[] nuevaFila={punt.getNombreUsuario(),punt.getPuntaje()};
				dtm.addRow(nuevaFila);
			}
		}catch(IOException excepcion){
			excepcion.printStackTrace();
		}
	}
	
	public String[] nombreDeColumnas(){//array de nombres de columnas
		String[] columnas={"Nombre usuario","Puntaje"};
		return columnas;
	}	
}