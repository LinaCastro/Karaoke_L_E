package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logica.Genero;

public class PanelGenero extends JPanel{

	private DefaultListModel listModelGenero;
	private JList<Genero> listaGenero;

	public PanelGenero(GestionEventosJlist eventosJlist) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 500));
		this.setBorder(new TitledBorder(BorderFactory.createTitledBorder("GENERO MUSICAL")));
		listModelGenero = new DefaultListModel<>();
		listaGenero = new JList<>(listModelGenero);
		listaGenero.addListSelectionListener(eventosJlist);
		for (Genero genero : Genero.values()) {
			listModelGenero.addElement(genero);
		}
		
		this.add(listaGenero, BorderLayout.CENTER);
	}
	public DefaultListModel getListModelGenero() {
		return listModelGenero;
	}
	public void setListModelGenero(DefaultListModel listModelGenero) {
		this.listModelGenero = listModelGenero;
	}
	public JList<Genero> getListaGenero() {
		return listaGenero;
	}
	public void setListaGenero(JList<Genero> listaGenero) {
		this.listaGenero = listaGenero;
	}
	
}
