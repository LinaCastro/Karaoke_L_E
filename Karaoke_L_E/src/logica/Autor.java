package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Autor implements Serializable{

	private String nombre;
	private ArrayList<Cancion> listaCanciones;
	
	public Autor() {
		listaCanciones = new ArrayList<Cancion>();
	}
		
	public Autor(String nombre) {
		super();
		this.nombre = nombre;
		this.listaCanciones = listaCanciones;
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
	
	public void agregarCancion(String nombre, int duracion){
		Cancion cancion = new Cancion(nombre,duracion);
		listaCanciones.add(cancion);
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
