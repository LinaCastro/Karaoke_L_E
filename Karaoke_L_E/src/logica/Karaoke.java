package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Karaoke implements Serializable{
	
	private ArrayList<Autor> listaAutor;
	private Cancion cancionActual;
	
	public Karaoke() {
		super();
		listaAutor = new ArrayList<Autor>();
		listaAutor.add(new Autor("Pipe Pelaes", Genero.VALLENATO));
		listaAutor.add(new Autor("Mago de Oz", Genero.ROCK));
		listaAutor.add(new Autor("Alkilados", Genero.POP));
		listaAutor.add(new Autor("Nicky Jam", Genero.REGGAETON));
		listaAutor.get(0).agregarCancion("Cuando quieras quiero", 190, "./files/letraCanciones/letra.txt");
		listaAutor.get(1).agregarCancion("Mujer Amante", 190, "");
		listaAutor.get(2).agregarCancion("Mona Lisa", 190, "");
		listaAutor.get(3).agregarCancion("Voy a Beber", 190, "");
	}

	public Cancion getCancionActual() {
		return cancionActual;
	}
	public void setCancionActual(Cancion cancionActual) {
		this.cancionActual = cancionActual;
	}
	
	public ArrayList<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(ArrayList<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public void agregarAutor(String nombre, Genero genero){
		Autor autor = new Autor(nombre, genero);
		listaAutor.add(autor);
	}
	
}
