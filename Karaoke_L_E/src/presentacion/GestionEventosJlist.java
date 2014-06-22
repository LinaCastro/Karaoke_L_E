package presentacion;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logica.Artista;
import logica.Cancion;
import logica.Genero;

public class GestionEventosJlist implements ListSelectionListener{
	
	private VentanaPrincipal ventanaPrincipal;

	public GestionEventosJlist(VentanaPrincipal principal) {
		super();
		this.ventanaPrincipal = principal;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource().equals(ventanaPrincipal.getPanelGenero().getListaGenero())) {
			ventanaPrincipal.actualizaJlistArtista((Genero) ((JList) e.getSource()).getSelectedValue());
		}
		if (e.getSource().equals(ventanaPrincipal.getPanelArtista().getListaArtista())) {
			ventanaPrincipal.actualizaJlistCancion((String) ((JList) e.getSource()).getSelectedValue());
		}
	}

}
