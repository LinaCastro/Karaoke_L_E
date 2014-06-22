package presentacion;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import logica.Artista;
import logica.Genero;

public class PanelGuardarNuevoArchivo extends JPanel{

	public final static String COMANDO_GUARDAR_CANCION = "ABRIR_GUARDAR_CANCION_REPRODUCCION";
	public final static String COMANDO_NUEVO_ARTIST = "ABRIR_NUEVO_ARTISTA";
	public final static String COMANDO_BOX_GENERO = "ABRIR_BOX_GENERO";
	private JTextField txtNombreCancion;
	private JTextField txtDuracionCancion;
	private JComboBox boxArtistaNombre;
	private JComboBox boxGenero;
	private JTextArea txtLetraCancion;
	private JButton btnGuardar;
	private JButton btnNuevoArtista;
	
	public PanelGuardarNuevoArchivo(GestionEventos gestionEventos) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setSize(500, 500);
		
		boxGenero = new JComboBox(Genero.values());
		boxGenero.setBorder(BorderFactory.createTitledBorder("Seleccione el Genero Musical"));
		boxGenero.setActionCommand(COMANDO_BOX_GENERO);
		boxGenero.addActionListener(gestionEventos);
		
		boxArtistaNombre = new JComboBox();
		boxArtistaNombre.setBorder(BorderFactory.createTitledBorder("Autor"));
		boxArtistaNombre.setEnabled(false);
		
		btnNuevoArtista = new JButton("Nuevo Artista");
		btnNuevoArtista.setActionCommand(COMANDO_NUEVO_ARTIST);
		btnNuevoArtista.addActionListener(gestionEventos);
		btnNuevoArtista.setEnabled(false);
		
		txtNombreCancion = new JTextField();
		txtNombreCancion.setBorder(BorderFactory.createTitledBorder("Nombre De La Cancion"));
		txtNombreCancion.setEnabled(false);
		txtDuracionCancion = new JTextField();
		txtDuracionCancion.setBorder(BorderFactory.createTitledBorder("Duracion (Segundos)"));
		txtDuracionCancion.setEnabled(false);
		
		txtLetraCancion = new JTextArea();
		txtLetraCancion.setBorder(BorderFactory.createTitledBorder("Letra"));
		txtLetraCancion.setEnabled(false);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand(COMANDO_GUARDAR_CANCION);
		btnGuardar.addActionListener(gestionEventos);
		btnGuardar.setEnabled(false);
		
		JPanel panelWest = new JPanel(new GridLayout(4,1));
		panelWest.setPreferredSize(new Dimension(200,200));
		panelWest.add(boxArtistaNombre);
		panelWest.add(btnNuevoArtista);
		panelWest.add(txtNombreCancion);
		panelWest.add(txtDuracionCancion);
		
		add(boxGenero, BorderLayout.NORTH);
		add(panelWest, BorderLayout.WEST);
		add(txtLetraCancion, BorderLayout.CENTER);
		add(btnGuardar, BorderLayout.SOUTH);
	}
	public void actualizaComboBoxArtista(ArrayList<Artista> nuevaListaArtista){
		btnGuardar.setEnabled(true);
		txtLetraCancion.setEnabled(true);
		txtNombreCancion.setEnabled(true);
		txtDuracionCancion.setEnabled(true);
		boxArtistaNombre.setEnabled(true);
		btnNuevoArtista.setEnabled(true);
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
	public JComboBox getBoxGenero() {
		return boxGenero;
	}
	public void setBoxGenero(JComboBox boxGenero) {
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
	public JComboBox getBoxArtistaNombre() {
		return boxArtistaNombre;
	}
	public void setBoxArtistaNombre(JComboBox boxArtistaNombre) {
		this.boxArtistaNombre = boxArtistaNombre;
	}
	public JTextField getTxtDuracionCancion() {
		return txtDuracionCancion;
	}
	public void setTxtDuracionCancion(JTextField txtDuracionCancion) {
		this.txtDuracionCancion = txtDuracionCancion;
	}
}
