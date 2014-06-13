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
		listaGeneros.add(new Genero("Vallenato"));
		listaGeneros.add(new Genero("Rock"));
		listaGeneros.add(new Genero("Pop"));
		listaGeneros.add(new Genero("Reggaeton"));
	}

	public void initAutores(){
		listaGeneros.get(0).agregarAutor("Silvestre");
		listaGeneros.get(0).agregarAutor("Pipe Pelaez");
		listaGeneros.get(0).agregarAutor("Diomedes Diaz");
		listaGeneros.get(0).getListaAutores().get(0).agregarCancion("UN AMOR VERDADERO", 313);


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
