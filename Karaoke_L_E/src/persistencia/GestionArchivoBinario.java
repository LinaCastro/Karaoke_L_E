package persistencia;

import java.io.*;

import javax.swing.JOptionPane;

import logica.Cancion;
import logica.Karaoke;

public class GestionArchivoBinario {

	public GestionArchivoBinario() {
		
	}
	public void crearArchivoKaraoke(Karaoke karaoke, String ruta){
		File archivo = new File(ruta);
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null ;
		try {
			fileOutputStream = new FileOutputStream(archivo);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(karaoke);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al Guardar el Archivo");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al Guardar el Archivo");
			e.printStackTrace();
		}
		
		try {
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al Cerrar el Archivo");
			e.printStackTrace();
		}
	}
	public Karaoke leerArchivoKaraoke(String ruta) {
		File archivo = new File(ruta);
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(archivo);
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Error al Leer el Archivo");
			e1.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al Leer el Archivo");
			e.printStackTrace();
		}
		try {
			return (Karaoke) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Clase no");
			e.printStackTrace();
		}
			try {
				fileInputStream.close();
				objectInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		archivoBinario.crearArchivoKaraoke(new Karaoke(), "./files/objeto/karaoke.kle");
		Karaoke karaoke = (Karaoke)archivoBinario.leerArchivoKaraoke("./files/objeto/karaoke.kle");
		System.out.println(karaoke.getListaArtista().get(0).getNombre());
	}
}
