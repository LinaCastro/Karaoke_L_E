package logica;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import persistencia.GestionArchivoPlano;

public class Artista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Genero genero;
	private String rutaImagen;
	private ArrayList<Cancion> listaCanciones;
	
	public Artista(String nombre, Genero genero, String rutaImagen) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.rutaImagen = rutaImagen;
		listaCanciones = new ArrayList<Cancion>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}
	public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	public void agregarCancion(String nombre, int duracionSegundos, String rutaLetra){
		Cancion cancion = new Cancion(nombre,duracionSegundos,rutaLetra);
		listaCanciones.add(cancion);
	}
	
	public void guardarNuevaLetraCancion(String letra, Cancion nuevaCancion, String ruta) {
		try {
			GestionArchivoPlano.crearArchivoLetra(letra, ruta + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		listaCanciones.add(nuevaCancion);
	}
	@Override
	public String toString() {
		return nombre;
	}
}
