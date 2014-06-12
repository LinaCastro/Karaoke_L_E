package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Properties;

import javax.swing.JFrame;

import logica.Karaoke;

public class VentanaPrincipal extends JFrame{

	private Karaoke karaoke;
	private VentanaReproduccion ventanaReproduccion;
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
		
		karaoke = new Karaoke();
		
		ventanaReproduccion = new VentanaReproduccion();
		//panelCancion = new PanelCancion();
		panelGenero = new PanelGenero();
		panelArtista = new PanelArtista();
		
		this.add(panelCancion, BorderLayout.EAST);
		this.add(panelGenero, BorderLayout.WEST);
		this.add(panelArtista, BorderLayout.CENTER);

	}
	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		
	}
}
