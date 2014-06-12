package presentacion;

import javax.swing.JPanel;

import logica.Cancion;

public class PanelCancion extends JPanel{

	private Cancion cancion;
	
	public PanelCancion(Cancion cancionP) {
		cancion = cancionP;
	}
}
