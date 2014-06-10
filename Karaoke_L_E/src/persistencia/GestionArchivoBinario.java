package persistencia;

import java.io.*;

import logica.karaoke;

public class GestionArchivoBinario {


	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private File file;
	
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	
	
	public GestionArchivoBinario() {
		
	}
	
	public void leer() throws IOException, ClassNotFoundException {
		file = new File("./files/person");
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		
		karaoke karaoke  = (karaoke)objectInputStream.readObject();
	}
	public void  escribir()  throws IOException {
		file = new File("./files/person");
		fileOutputStream = new FileOutputStream(file);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		karaoke karaoke = new karaoke();
		objectOutputStream.writeObject(karaoke);//Guardar el objeto
		objectOutputStream.close();
	}
}
