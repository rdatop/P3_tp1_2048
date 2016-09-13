package vistas;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class VentanaPuntajes extends JFrame {
	
	public VentanaPuntajes() {
		GeneradorJTable generador=new GeneradorJTable();
		//se crea la Tabla con el modelo DefaultTableModel
		final JTable table = generador.generaJTable();
		//se define el tamaño
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.NORTH);
		//manejamos la salida
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void instanciaPuntajes() {
		VentanaPuntajes frame = new VentanaPuntajes();
		frame.pack();
		frame.setVisible(true);
	}
}