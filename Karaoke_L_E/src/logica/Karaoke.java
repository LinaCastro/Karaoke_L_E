package logica;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import persistencia.GestionArchivoBinario;
import persistencia.GestionArchivoPlano;


public class Karaoke implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Artista> listaArtista;
	private Cancion cancionActual;
	
	
	public Karaoke() {
		super();
		cancionActual =  new Cancion();
		listaArtista = new ArrayList<Artista>();
		listaArtista.add(new Artista("Pipe Pelaez", Genero.VALLENATO,"/img/Pipe_Pelaez.png"));
		listaArtista.add(new Artista("Mago de Oz", Genero.ROCK,"/img/Mago_De_Oz.png"));
		listaArtista.add(new Artista("Alkilados", Genero.POP,"/img/alkilados.png"));
		listaArtista.add(new Artista("Nicky Jam", Genero.REGGAETON,"/img/nicky_jam.png"));
		listaArtista.get(0).agregarCancion("Cuando quieras quiero", 190, "./files/letraCanciones/Cuando quieras quiero.kle");
		listaArtista.get(1).agregarCancion("Mujer Amante", 190, "./files/letraCanciones/Mujer Amante.kle");
		listaArtista.get(2).agregarCancion("Mona Lisa", 190, "./files/letraCanciones/Mona Lisa.kle");
		listaArtista.get(3).agregarCancion("Voy a Beber", 190, "./files/letraCanciones/Voy a Beber.kle");
//		this.guardarKaraoke("./files/objeto/karaoke.kle");
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

	public void agregarArtista(String nombre, Genero genero, String rutaImagen){
		Artista artista = new Artista(nombre, genero, rutaImagen);
		listaArtista.add(artista);
	}
	public void letraCancionAReproducir(String nombreArtista, int posicionCancion){
		cancionActual = new Cancion();
		String letra = "";
		for (Artista artistaArray : this.listaArtista) {
			if (artistaArray.getNombre().equals(nombreArtista)) {
				letra = (String)GestionArchivoPlano.leerArchivoLetra(artistaArray.getListaCanciones().get(posicionCancion).getRutaLetra());
				cancionActual.guardarLetra(letra);
				System.out.println(letra);
			}
		}
		
	}
	public void agregarCancion(String nombreArtista, Cancion cancionParaGuardar){
		for (Artista artistaArray : this.listaArtista) {
			if (artistaArray.getNombre().equals(nombreArtista)) {
				artistaArray.agregarCancion(cancionParaGuardar.getNombre(), cancionParaGuardar.getDuracion(), cancionParaGuardar.getRutaLetra()+".kle");
			}
		}
	}
	public void guardarLetraCancion(String letra, String ruta){
		try {
			GestionArchivoPlano.crearArchivoLetra(letra, ruta+".kle");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Artista> listaArtistasPorGenero(Genero genero) {
		ArrayList<Artista> listaartistasPorGenero = new ArrayList<Artista>();
		for (Artista artista : this.listaArtista) {
			if (artista.getGenero().equals(genero)) {
				listaartistasPorGenero.add(artista);
			}
		}
		return listaartistasPorGenero;
	}

	public ArrayList<Cancion> listaCancionesPorArtista(String artistaP) {
		ArrayList<Cancion> listaCancionPorArtista = new ArrayList<Cancion>();
		for (Artista artista : this.listaArtista) {
			if (artista.getNombre().equals(artistaP)) {
				for (Cancion cancion : artista.getListaCanciones()) {
					listaCancionPorArtista.add(cancion);
				}
			}
		}
		return listaCancionPorArtista;
	}
	public void guardarKaraoke(String rutaKaraoke ){
		GestionArchivoBinario.crearArchivoKaraoke(this, rutaKaraoke);
	}
}
