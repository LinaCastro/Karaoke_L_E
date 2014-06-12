package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Karaoke implements Serializable{
	
	private ArrayList<Genero> listaGeneros;
	private Cancion cancionActual;
	
	public Karaoke(ArrayList<Genero> listaGeneros, Cancion cancionActual) {
		super();
		this.listaGeneros = listaGeneros;
		this.cancionActual = cancionActual;
		listaGeneros = new ArrayList<Genero>();
	}

	public Karaoke() {
		listaGeneros = new ArrayList<Genero>();
	}
	
	public ArrayList<Genero> getListaGeneros() {
		return listaGeneros;
	}
	public void setListaGeneros(ArrayList<Genero> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}
	public Cancion getCancionActual() {
		return cancionActual;
	}
	public void setCancionActual(Cancion cancionActual) {
		this.cancionActual = cancionActual;
	}
	
	public void agregarGenero(String nombre){
		Genero genero = new Genero(nombre);
		listaGeneros.add(genero);
	}
	
}
