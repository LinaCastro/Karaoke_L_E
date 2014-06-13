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

	public PanelGenero() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 500));
		this.setBorder(new TitledBorder(BorderFactory.createTitledBorder("GENERO MUSICAL")));
		listModelGenero = new DefaultListModel<>();
		listaGenero = new JList<>(listModelGenero);
		
		
		this.add(listaGenero, BorderLayout.CENTER);
	}
	public PanelGenero(Genero generoP) {
	}
}
