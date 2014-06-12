package persistencia;

import java.io.*;

import logica.Karaoke;

public class GestionArchivoBinario {


	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private File file;
	
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	
	
	public GestionArchivoBinario() {
		
	}
	
	public void guardarArchivoKaraoke(Karaoke karaoke){
		
	}
	
	public void leer() throws IOException, ClassNotFoundException {
		file = new File("./files/person");
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		
		Karaoke karaoke  = (Karaoke)objectInputStream.readObject();
	}
	public void  escribir()  throws IOException {
		file = new File("./files/person");
		fileOutputStream = new FileOutputStream(file);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		Karaoke karaoke = new Karaoke();
		objectOutputStream.writeObject(karaoke);//Guardar el objeto
		objectOutputStream.close();
	}
}
