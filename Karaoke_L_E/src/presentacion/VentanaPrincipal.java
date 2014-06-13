package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;

import logica.Karaoke;

public class VentanaPrincipal extends JFrame{

	public final static String COMANDO_ABRIR_REPRODUCCION = "ABRIR_REPRODUCCION";
	private Karaoke karaoke;
	private GestionEventos gestionEventos;
	private VentanaReproduccion ventanaReproduccion;
	private PanelGenero panelGenero;
	private PanelArtista panelArtista;
	private PanelCancion panelCancion;
	private JButton botonAbrirReproduccion;
	
	public VentanaPrincipal() {
		super("Karaoke");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.decode("#51C1F5"));
		this.setFocusable(true);
		
		karaoke = new Karaoke();
		gestionEventos = new GestionEventos(this);
		ventanaReproduccion = new VentanaReproduccion(gestionEventos);
		panelCancion = new PanelCancion();
		panelGenero = new PanelGenero();
		panelArtista = new PanelArtista();

		botonAbrirReproduccion = new JButton("REPRODUCIR");
		botonAbrirReproduccion.setActionCommand(COMANDO_ABRIR_REPRODUCCION);
		botonAbrirReproduccion.addActionListener(gestionEventos);
		
		this.add(botonAbrirReproduccion, BorderLayout.SOUTH);
		
		this.add(panelCancion, BorderLayout.EAST);
		this.add(panelGenero, BorderLayout.WEST);
		this.add(panelArtista, BorderLayout.CENTER);

	}
	public void manejoVentanaReproduccion(char abrirCerrar){
		switch (abrirCerrar) {
		case 'a':
			ventanaReproduccion.setVisible(true);
			break;
		case 'c':
			ventanaReproduccion.setVisible(false);
			break;
		default:
			break;
		}
	}
	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
	}
}
