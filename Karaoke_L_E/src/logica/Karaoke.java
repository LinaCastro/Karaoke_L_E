package logica;

import java.io.Serializable;
import java.util.ArrayList;

import persistencia.GestionArchivoPlano;


public class Karaoke implements Serializable{
	
	private ArrayList<Artista> listaArtista;
	private Cancion cancionActual;
	
	public Karaoke() {
		super();
		listaArtista = new ArrayList<Artista>();
		listaArtista.add(new Artista("Pipe Pelaes", Genero.VALLENATO));
		listaArtista.add(new Artista("Mago de Oz", Genero.ROCK));
		listaArtista.add(new Artista("Alkilados", Genero.POP));
		listaArtista.add(new Artista("Nicky Jam", Genero.REGGAETON));
		listaArtista.get(0).agregarCancion("Cuando quieras quiero", 190, "./files/letraCanciones/letra.txt");
		listaArtista.get(1).agregarCancion("Mujer Amante", 190, "");
		listaArtista.get(2).agregarCancion("Mona Lisa", 190, "");
		listaArtista.get(3).agregarCancion("Voy a Beber", 190, "");
		listaArtista.add(new Artista("Silvestre Dangon", Genero.VALLENATO));
	}

	public Cancion getCancionActual() {
		return cancionActual;
	}
	public void setCancionActual(Cancion cancionActual) {
		this.cancionActual = cancionActual;
	}
	
	public ArrayList<Artista> getListaArtista() {
		return listaArtista;
	}

	public void setListaArtista(ArrayList<Artista> listaArtista) {
		this.listaArtista = listaArtista;
	}

	public void agregarArtista(String nombre, Genero genero){
		Artista artista = new Artista(nombre, genero);
		listaArtista.add(artista);
	}
	public ArrayList<Artista> listaArtistasPorGenero(Genero genero) {
		ArrayList<Artista> listaartistasPorGenero = new ArrayList<>();
		for (Artista artista : this.listaArtista) {
			if (artista.getGenero().equals(genero)) {
				listaartistasPorGenero.add(artista);
			}
		}
		return listaartistasPorGenero;
	}

	public ArrayList<Cancion> listaCancionesPorArtista(String artistaP) {
		ArrayList<Cancion> listaCancionPorArtista = new ArrayList<>();
		for (Artista artista : this.listaArtista) {
			if (artista.getNombre().equals(artistaP)) {
				System.out.println(artista.getNombre());
				for (Cancion cancion : artista.getListaCanciones()) {
					System.err.println(cancion.getNombre());
					listaCancionPorArtista.add(cancion);
				}
			}
		}
		return listaCancionPorArtista;
	}

}
