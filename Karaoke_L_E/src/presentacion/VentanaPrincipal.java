package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import persistencia.GestionArchivoBinario;
import logica.Artista;
import logica.Cancion;
import logica.Genero;
import logica.Karaoke;

public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String COMANDO_ABRIR_REPRODUCCION = "ABRIR_REPRODUCCION";
	private static final String RUTA_KARAOKE = "./files/objeto/karaoke.kle";
	private Karaoke karaoke;
	private GestionEventos gestionEventos;
	private GestionEventosJlist gestionEventosJlist;
	private VentanaReproduccion ventanaReproduccion;
	private PanelGenero panelGenero;
	private PanelArtista panelArtista;
	private PanelCancion panelCancion;
	private PanelGuardarNuevoArchivo panelGuardarNuevoArchivo;
	private JButton botonAbrirReproduccion;
	private JTabbedPane jTabbedPane;
	public VentanaPrincipal() {
		super("Karaoke");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.decode("#51C1F5"));
		this.setFocusable(true);
		this.setIconImage(new ImageIcon(getClass().getResource(
				"/img/logo.png")).getImage());
		
		karaoke = (Karaoke)GestionArchivoBinario.leerArchivoKaraoke(RUTA_KARAOKE);
		if (karaoke == null) {
			karaoke = new Karaoke();
		}
		gestionEventos = new GestionEventos(this);
		gestionEventosJlist = new GestionEventosJlist(this);
		ventanaReproduccion = new VentanaReproduccion(gestionEventos);
		ventanaReproduccion.setVisible(false);
		
		jTabbedPane = new JTabbedPane();	
		
		panelCancion = new PanelCancion();
		panelGenero = new PanelGenero(gestionEventosJlist);
		panelArtista = new PanelArtista(gestionEventosJlist);

		botonAbrirReproduccion = new JButton("REPRODUCIR");
		botonAbrirReproduccion.setActionCommand(COMANDO_ABRIR_REPRODUCCION);
		botonAbrirReproduccion.addActionListener(gestionEventos);
		
		JPanel panelOrganizador = new JPanel(new BorderLayout());
		panelOrganizador.add(panelCancion, BorderLayout.EAST);
		panelOrganizador.add(panelGenero, BorderLayout.WEST);
		panelOrganizador.add(panelArtista, BorderLayout.CENTER);
		panelOrganizador.add(botonAbrirReproduccion, BorderLayout.SOUTH);
		jTabbedPane.addTab("Reproducir", createImageIcon("./files/img/karaoke.kle",""),panelOrganizador);
		
		panelGuardarNuevoArchivo = new PanelGuardarNuevoArchivo(gestionEventos);
		jTabbedPane.addTab("Nueva Cancion", panelGuardarNuevoArchivo);
		this.add(jTabbedPane, BorderLayout.CENTER);

	}
	public void actualizaJlistArtista(Genero genero){
		panelArtista.actualizarListaArtistas(karaoke.listaArtistasPorGenero(genero));
	}
	public void actualizaJlistCancion(String artista){
		panelCancion.actualizarListaCancion(karaoke.listaCancionesPorArtista(artista));
	}
	public void actualizaBoxAutores(Genero genero){
		panelGuardarNuevoArchivo.actualizaComboBoxArtista(karaoke.listaArtistasPorGenero(genero));
	}
	public void crearArtistaOCancion(char artistaOCancion){
		switch (artistaOCancion) {
		case 'a':
			String nuevoArtista = JOptionPane.showInputDialog(null, "Ingrese El Nombre Del Nuevo Artista");
			if (nuevoArtista != null && !nuevoArtista.isEmpty()) {
				karaoke.agregarArtista(nuevoArtista, 
						(Genero) panelGuardarNuevoArchivo.getBoxGenero().getSelectedItem());;
			}else 
				JOptionPane.showMessageDialog(null, "Error al Ingresar el Nombre");
			break;
		case 'c':
			this.guardarCancion();
			break;
		default:
			break;
		}
	}
	public void manejoVentanaReproduccion(char abrirCerrar){
		switch (abrirCerrar) {
		case 'a':
			ventanaReproduccion.setVisible(true);
//			System.out.println(panelArtista.getListaArtista().getSelectedIndex());
//			System.out.println(panelCancion.getListaCancion().getSelectedIndex());
//			for (String stringValue : (karaoke.getListaArtista().get(panelArtista.getListaArtista().getSelectedIndex()).getListaCanciones().get(panelCancion.getListaCancion().getSelectedIndex()-1).getLetraCancion())) {
//				System.out.print(stringValue + "    ok++");
//			}
			karaoke.letraCancionAReproducir((String) panelArtista.getListaArtista().getSelectedValue(), panelCancion.getListaCancion().getSelectedIndex());
			ventanaReproduccion.asignarLetraCancionJpanel(karaoke.getCancionActual());
			ventanaReproduccion.reproducir();
			break;
		case 'c':
			ventanaReproduccion.detenerReproduccion();
			ventanaReproduccion.setVisible(false);
			break;
		default:
			break;
		}
	}
	public void guardarCancion(){
		JFileChooser jFileChooser = new JFileChooser("./files/letraCanciones/");
		int opcion = jFileChooser.showSaveDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			Cancion cancion =  new Cancion(panelGuardarNuevoArchivo.getTxtNombreCancion().getText(),
					Integer.parseInt(panelGuardarNuevoArchivo.getTxtDuracionCancion().getText()),
					jFileChooser.getSelectedFile().getPath());
			cancion.guardarLetra(panelGuardarNuevoArchivo.getTxtLetraCancion().getText());
			System.out.println(jFileChooser.getSelectedFile().getPath());
			karaoke.agregarCancion((String) panelGuardarNuevoArchivo.getBoxArtistaNombre().getSelectedItem(), cancion);
			karaoke.guardarLetraCancion(panelGuardarNuevoArchivo.getTxtLetraCancion().getText(), cancion.getRutaLetra());
			karaoke.guardarKaraoke(RUTA_KARAOKE);
			//			ventanaReproduccion.agregarCancion(((String)panelGuardarNuevoArchivo.getBoxArtistaNombre().getSelectedItem()), cancion, 
//			panelGuardarNuevoArchivo.getTxtLetraCancion().getText());
		}
	}
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Error ImageIcon" + path);
			return null;
		}
	}
	public Karaoke getKaraoke() {
		return karaoke;
	}
	public void setKaraoke(Karaoke karaoke) {
		this.karaoke = karaoke;
	}
	public VentanaReproduccion getVentanaReproduccion() {
		return ventanaReproduccion;
	}
	public void setVentanaReproduccion(VentanaReproduccion ventanaReproduccion) {
		this.ventanaReproduccion = ventanaReproduccion;
	}
	public PanelGenero getPanelGenero() {
		return panelGenero;
	}
	public void setPanelGenero(PanelGenero panelGenero) {
		this.panelGenero = panelGenero;
	}
	public PanelArtista getPanelArtista() {
		return panelArtista;
	}
	public void setPanelArtista(PanelArtista panelArtista) {
		this.panelArtista = panelArtista;
	}
	public PanelCancion getPanelCancion() {
		return panelCancion;
	}
	public void setPanelCancion(PanelCancion panelCancion) {
		this.panelCancion = panelCancion;
	}
	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
	}
}
