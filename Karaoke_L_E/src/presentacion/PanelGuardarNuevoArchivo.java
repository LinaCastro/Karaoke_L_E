package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import logica.Artista;
import logica.Genero;

public class PanelGuardarNuevoArchivo extends JPanel{

	public final static String COMANDO_GUARDAR_CANCION_REPRODUCCION = "ABRIR_GUARDAR_CANCION_REPRODUCCION";
	public final static String COMANDO_NUEVO_ARTIST = "ABRIR_NUEVO_ARTISTA";
	public final static String COMANDO_NUEVO_GENERO = "ABRIR_NUEVO_GENERO";
	public final static String COMANDO_BOX_NUEVO_GENERO = "ABRIR_BOX_NUEVO_GENERO";
	private JTextField txtNombreCancion;
	private JComboBox<String> boxArtistaNombre;
	private JComboBox<Genero> boxGenero;
	private JTextArea txtLetraCancion;
	private JButton btnGuardar;
	private JButton btnNuevoArtista;
	private JButton btnNuevoGenero;
	
	public PanelGuardarNuevoArchivo(GestionEventos gestionEventos) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setSize(500, 500);
		
		txtNombreCancion = new JTextField();
		txtNombreCancion.setBorder(BorderFactory.createTitledBorder("Nombre De La Cancion"));
		
		boxArtistaNombre = new JComboBox<>();
		boxArtistaNombre.setBorder(BorderFactory.createTitledBorder("Autor"));
		
		boxGenero = new JComboBox<>(Genero.values());
		boxGenero.setBorder(BorderFactory.createTitledBorder("Genero"));
		boxGenero.setActionCommand(COMANDO_BOX_NUEVO_GENERO);
		boxGenero.addActionListener(gestionEventos);
		
		txtLetraCancion = new JTextArea();
		txtLetraCancion.setBorder(BorderFactory.createTitledBorder("Letra"));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand(COMANDO_GUARDAR_CANCION_REPRODUCCION);
		btnGuardar.addActionListener(gestionEventos);
		
		btnNuevoArtista = new JButton("Nuevo Artista");
		btnNuevoArtista.setActionCommand(COMANDO_NUEVO_ARTIST);
		btnNuevoArtista.addActionListener(gestionEventos);
		
		btnNuevoGenero = new JButton("Nuevo Genero");
		btnNuevoGenero.setActionCommand(COMANDO_NUEVO_GENERO);
		btnNuevoGenero.addActionListener(gestionEventos);
		
		JPanel panelNort = new JPanel(new GridLayout(2,1));
		panelNort.add(boxGenero);
		panelNort.add(btnNuevoGenero);
		JPanel panelWest = new JPanel(new GridLayout(3,1));
		panelWest.setPreferredSize(new Dimension(200,200));
		panelWest.add(boxArtistaNombre);
		panelWest.add(btnNuevoArtista);
		panelWest.add(txtNombreCancion);
		
		add(panelNort, BorderLayout.NORTH);
		add(panelWest, BorderLayout.WEST);
		add(txtLetraCancion, BorderLayout.CENTER);
		add(btnGuardar, BorderLayout.SOUTH);
	}
	public void actualizaComboBoxArtista(ArrayList<Artista> nuevaListaArtista){
		boxArtistaNombre.removeAllItems();
		for (Artista artistaNombre : nuevaListaArtista) {
			boxArtistaNombre.addItem(artistaNombre.getNombre());
		}
	}
	public JTextField getTxtNombreCancion() {
		return txtNombreCancion;
	}
	public void setTxtNombreCancion(JTextField txtNombreCancion) {
		this.txtNombreCancion = txtNombreCancion;
	}
	public JComboBox<Genero> getBoxGenero() {
		return boxGenero;
	}
	public void setBoxGenero(JComboBox<Genero> boxGenero) {
		this.boxGenero = boxGenero;
	}
	public JTextArea getTxtLetraCancion() {
		return txtLetraCancion;
	}
	public void setTxtLetraCancion(JTextArea txtLetraCancion) {
		this.txtLetraCancion = txtLetraCancion;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
}
