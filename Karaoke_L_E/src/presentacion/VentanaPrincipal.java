package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Properties;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{

	private PanelReproduccion panelReproduccion;
	private PanelGenero panelGenero;
	private PanelArtista panelArtista;
	private PanelCancion panelCancion;
	
	
	public VentanaPrincipal() {
		super("Karaoke");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.decode("#51C1F5"));
		this.setUndecorated(true);
		this.setFocusable(true);
		
		panelReproduccion = new PanelReproduccion();
		panelCancion = new PanelCancion();
		panelGenero = new PanelGenero();
		panelArtista = new PanelArtista();
		
		this.add(panelReproduccion);
		this.add(panelCancion);
		this.add(panelGenero);
		this.add(panelArtista);

	}
}
