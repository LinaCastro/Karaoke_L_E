package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Autor implements Serializable{

	private String nombre;
	private Genero genero;
	private ArrayList<Cancion> listaCanciones;
	
	public Autor() {
		listaCanciones = new ArrayList<Cancion>();
	}
		
	public Autor(String nombre, Genero genero) {
		super();
		this.nombre = nombre;
		this.genero = genero;
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
	public void agregarCancion(String nombre, int duracionSegundos, String rutaLetra){
		Cancion cancion = new Cancion(nombre,duracionSegundos,rutaLetra);
		listaCanciones.add(cancion);
	}
	@Override
	public String toString() {
		return nombre;
	}
}
