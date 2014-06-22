package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import logica.Cancion;

public class VentanaReproduccion extends JWindow{

	public final static String COMANDO_CERRAR_REPRODUCCION = "CERRAR_REPRODUCCION";
	private Cancion cancionReproductor;
	private HiloVentanaReproduccion hiloVentanaReproduccion;
	private JButton botonCerrar;
	private JPanel panelLabels;
	private JLabel[] listaLabelsCaracter;
	private int posicionCaracter;
	private int posicionCaracterLetra;
	
	public VentanaReproduccion(GestionEventos gestionEventos) {
		this.setSize(800, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.decode("#51C1F5"));
		this.setFocusable(false);
		
		cancionReproductor =  new Cancion();
		hiloVentanaReproduccion = new HiloVentanaReproduccion(this);
		posicionCaracter = 0 ;
		
		panelLabels = new JPanel(new GridLayout(5,20));
		panelLabels.setBounds(20, 100, this.getWidth()-40, this.getHeight()-200);
		panelLabels.setOpaque(true);
		panelLabels.setBackground(new Color(0,0,0,0));
		listaLabelsCaracter = new JLabel[100];
		for (int i = 0; i < listaLabelsCaracter.length; i++) {
			listaLabelsCaracter[i] = new JLabel();
			listaLabelsCaracter[i].setOpaque(false);
			listaLabelsCaracter[i].setFont(new Font("Arial", Font.BOLD, 35));
			panelLabels.add(listaLabelsCaracter[i]);
		}
		this.add(panelLabels);
		
		botonCerrar = new JButton("Cerrar");
		botonCerrar.setBounds((this.getWidth()/2)-50, this.getHeight()-50, 100, 50);
		botonCerrar.setActionCommand(COMANDO_CERRAR_REPRODUCCION);
		botonCerrar.addActionListener(gestionEventos);
		
		this.add(botonCerrar);
	}
	public void asignarLetraCancionJpanel(Cancion cancion){
		cancionReproductor = cancion;
		posicionCaracterLetra = 0;
		for (int i = 0; posicionCaracterLetra < cancionReproductor.getLetraCancion().size() && i < listaLabelsCaracter.length; i++) {
			listaLabelsCaracter[i].setText(cancionReproductor.getLetraCancion().get(posicionCaracterLetra));
			posicionCaracterLetra++;
			repaint();
		}
		this.setVisible(false);
		this.setVisible(true);
	}
	public void terminoTablero(){
		if (listaLabelsCaracter[listaLabelsCaracter.length-1].getForeground().equals(Color.red)) {
			for (int i = 0; i < listaLabelsCaracter.length; i++) {
				listaLabelsCaracter[i].setForeground(Color.black);
			}
			repaint();
			posicionCaracter = 0;
			for (int i = 0; posicionCaracterLetra < cancionReproductor.getLetraCancion().size() && listaLabelsCaracter.length>i; i++) {
				listaLabelsCaracter[i].setText(cancionReproductor.getLetraCancion().get(posicionCaracterLetra));
				posicionCaracterLetra++;
				repaint();
			}
		}
	}
	public void aumentarposicionCaracter(){
		posicionCaracter++;
	}
	public void pintarLetraCancion(){
		listaLabelsCaracter[posicionCaracter].setForeground(Color.red);
		repaint();
	}
	public void reproducir(){
		hiloVentanaReproduccion.iniciar();
	}
	public void detenerReproduccion(){
		hiloVentanaReproduccion.pausar();
	}
	public Cancion getCancionReproductor() {
		return cancionReproductor;
	}
	public void setCancionReproductor(Cancion cancionReproductor) {
		this.cancionReproductor = cancionReproductor;
	}
	public HiloVentanaReproduccion getHiloVentanaReproduccion() {
		return hiloVentanaReproduccion;
	}
	public void setHiloVentanaReproduccion(
			HiloVentanaReproduccion hiloVentanaReproduccion) {
		this.hiloVentanaReproduccion = hiloVentanaReproduccion;
	}
//	public static void main(String[] args) {
//	VentanaReproduccion reproduccion = new VentanaReproduccion(null);
//	reproduccion.setVisible(true);
//	Cancion cancion = new Cancion();
//	ArrayList<String> arrayLetraCancion = new ArrayList<String>();
//	arrayLetraCancion.add("a"); 
//	arrayLetraCancion.add("b"); 
//	arrayLetraCancion.add("c"); 
//	arrayLetraCancion.add(" "); 
//	arrayLetraCancion.add("d"); 
//	arrayLetraCancion.add("e"); 
//	arrayLetraCancion.add("f"); 
//	cancion.setLetraCancion(arrayLetraCancion);
//	reproduccion.asignarLetraCancionJpanel(cancion);
//		reproduccion.getHiloVentanaReproduccion().iniciar();
//	
//	}
}
