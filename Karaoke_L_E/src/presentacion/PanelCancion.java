package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logica.Cancion;
import logica.Genero;

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
}
