package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

import logica.Artista;
import logica.Cancion;

public class PanelArtista extends JPanel{
	
	private DefaultListModel listModelArtista;
	private JList<Artista> listaArtista;

	public PanelArtista(GestionEventosJlist eventosJlist) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 500));
		this.setBorder(new TitledBorder(BorderFactory.createTitledBorder("ARTISTAS")));
		listModelArtista = new DefaultListModel<>();
		listaArtista = new JList<>(listModelArtista);
		listaArtista.addListSelectionListener(eventosJlist);
		this.add(listaArtista, BorderLayout.CENTER);
	}
	public void actualizarListaArtistas(ArrayList<Artista> listaArtistaNuevos){
		listModelArtista.clear();
		for (Artista artista : listaArtistaNuevos) {
			listModelArtista.addElement(artista.getNombre());
		}
	}
	public DefaultListModel getListModelArtista() {
		return listModelArtista;
	}
	public void setListModelArtista(DefaultListModel listModelArtista) {
		this.listModelArtista = listModelArtista;
	}
	public JList<Artista> getListaArtista() {
		return listaArtista;
	}
	public void setListaArtista(JList<Artista> listaArtista) {
		this.listaArtista = listaArtista;
	}
	
}
