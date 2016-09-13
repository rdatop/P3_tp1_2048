package vistas;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class VentanaPuntajes extends JFrame {
	public VentanaPuntajes() {
		
		Object[] newRow={"Juano",3054};
				
		//array de String's con los títulos de las columnas
		String[] columnNames = {"Nombre usuario","Puntaje"};
		
		//creamos el Modelo de la tabla con los datos anteriores
		DefaultTableModel dtm= new DefaultTableModel(new Object[0][0] , columnNames);
		dtm.addRow(newRow);
		//se crea la Tabla con el modelo DefaultTableModel
		final JTable table = new JTable(dtm);
		//se define el tamaño
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		//manejamos la salida
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		VentanaPuntajes frame = new VentanaPuntajes();
		frame.pack();
		frame.setVisible(true);
	}
}