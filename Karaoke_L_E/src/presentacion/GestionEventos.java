package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class GestionEventos implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;

	
	public GestionEventos(VentanaPrincipal principal) {
		super();
		this.ventanaPrincipal = principal;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(VentanaPrincipal.COMANDO_ABRIR_REPRODUCCION)) {
			ventanaPrincipal.manejoVentanaReproduccion('a');
		}else if (event.getActionCommand().equals(VentanaReproduccion.COMANDO_CERRAR_REPRODUCCION)) {
			ventanaPrincipal.manejoVentanaReproduccion('c');
		}
		
	}
}
