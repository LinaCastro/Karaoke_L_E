package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Autor implements Serializable{

	private String nombre;
	private ArrayList<Cancion> listaCanciones;
	
	public Autor() {

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
	
}
