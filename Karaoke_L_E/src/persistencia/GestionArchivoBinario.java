package persistencia;

import java.io.*;

import logica.Cancion;
import logica.Karaoke;

public class GestionArchivoBinario {

	public GestionArchivoBinario() {
		
	}
	public void crearArchivoKaraoke(Karaoke karaoke, String ruta) throws IOException{
		File archivo = new File(ruta);
		FileOutputStream fileOutputStream = new FileOutputStream(archivo);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(karaoke);
		
		fileOutputStream.close();
		objectOutputStream.close();
	}
	public Karaoke leerArchivoKaraoke(String ruta) throws IOException {
		File archivo = new File(ruta);
		FileInputStream	fileInputStream = new FileInputStream(archivo);
		ObjectInputStream	objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			return (Karaoke) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Clase no");
			e.printStackTrace();
		}
			fileInputStream.close();
			objectInputStream.close();
		return null;
	}
	
	public void crearArchivoCancion(Cancion cancion, String ruta) throws IOException{
		File archivo = new File(ruta);
		FileOutputStream fileOutputStream = new FileOutputStream(archivo);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(cancion);
		
		fileOutputStream.close();
		objectOutputStream.close();
	}
	
	public Cancion leerArchivoCancion(String ruta) throws IOException {
		File archivo = new File("./files/cancion.cxf");
		FileInputStream	fileInputStream = new FileInputStream(archivo);
		ObjectInputStream	objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			return (Cancion) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Clase no");
			e.printStackTrace();
		}
		
			fileInputStream.close();
			objectInputStream.close();
		return null;
	}
	
	public void guardarArchivoKaraoke(Karaoke karaoke){
		
	}
	
	public static void main(String[] args) {
		GestionArchivoBinario archivoBinario = new GestionArchivoBinario();
		try {
			archivoBinario.crearArchivoKaraoke(new Karaoke(), "./files/letraCanciones/karaoke.xxx");
			Karaoke karaoke = (Karaoke)archivoBinario.leerArchivoKaraoke("./files/letraCanciones/karaoke.xxx");
			System.out.println(karaoke.getListaAutor().get(0).getNombre());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
