package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logica.Artista;
import logica.Cancion;

public class PanelCancion extends JPanel{

	private DefaultListModel listModelCancion;
	private JList<Cancion> listaCancion;
	
	public PanelCancion() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 500));
		this.setBorder(new TitledBorder(BorderFactory.createTitledBorder("CANCIONES")));
		listModelCancion = new DefaultListModel<>();
		listaCancion = new JList<>(listModelCancion);
		
		this.add(listaCancion, BorderLayout.CENTER);
	}
	public void actualizarListaCancion(ArrayList<Cancion> listaCancionNuevos){
		listModelCancion.clear();
		for (Cancion cancion : listaCancionNuevos) {
			listModelCancion.addElement(cancion.getNombre());
		}
	}
	public DefaultListModel getListModelCancion() {
		return listModelCancion;
	}
	public void setListModelCancion(DefaultListModel listModelCancion) {
		this.listModelCancion = listModelCancion;
	}
	public JList<Cancion> getListaCancion() {
		return listaCancion;
	}
	public void setListaCancion(JList<Cancion> listaCancion) {
		this.listaCancion = listaCancion;
	}
	
}
