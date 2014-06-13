package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logica.Autor;
import logica.Cancion;

public class PanelArtista extends JPanel{
	
	private DefaultListModel listModelArtista;
	private JList<Autor> listaArtista;

	public PanelArtista() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 500));
		this.setBorder(new TitledBorder(BorderFactory.createTitledBorder("ARTISTAS")));
		listModelArtista = new DefaultListModel<>();
		listaArtista = new JList<>(listModelArtista);
		
		this.add(listaArtista, BorderLayout.CENTER);
	}
}
