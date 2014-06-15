package persistencia;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class GestionArchivoPlano {

	public static void crearArchivoLetra(String letra, String ruta) throws IOException {
		File archivo = new File(ruta);
		FileWriter fileWriter = null;

		fileWriter = new FileWriter(archivo);
		fileWriter.write(letra);
		fileWriter.close();
	}
	
	public static ArrayList<String> leerArchivoLetra(String ruta) throws IOException {
		File archivo = new File(ruta);
		FileReader fileReader = null;
		
		ArrayList<String> letra = new ArrayList<String>();

		fileReader = new FileReader(archivo);

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linea = null;
		try {
			while ((linea = bufferedReader.readLine()) != null) {
				letra.add(linea);
			}
			return letra;
		} catch (IOException e) {
			e.printStackTrace();
		}
			fileReader.close();
		return null;
	}
	public GestionArchivoPlano() {

	}
	public static void main(String[] args) {
		try {
			GestionArchivoPlano.crearArchivoLetra("Yo no puedo creer que en poco tiempo \n"
					+ "añore ver tus ojos fijamente \n"
+ "me cuesta el aceptarlo, pero lo hago \n"
+ "improvisando hasta en mis sueños para verte \n"

+ "Lo juro me sorprende y me estremese \n"
+ "el dulce coquetear de tu sonrisa \n"
+ "mi vida se que no estoy en tus planes \n"
+ "aqui estare esperandote que algun dia \n"

+ "No te de miedo conocerme \n"
+ "depronto hasta quererme \n"
+ "sosobra no tendras jamas conmigo \n"
+ "un universo de ilusiones \n"
+ "un mundo de canciones \n"
+ "recibiras a cambio de un besito \n"
+ "un loco enamorado de la vida \n"
+ "y amante a la eternidad \n"

+ "Cuando quieras quiero \n"
+ "donde quieras quiero \n"
+ "yo dejo todo a un lado \n"
+ "{{ pa' sali' contigo }} \n"

+ "Que cuando quieras quiero \n"
+ "{{ una señal me basta }} \n"
+ "decirte lo de siempre \n"
+ "{{ aqui ya no hace falta }} \n"

+ "Me gusta me seduce tu insolencia \n"
+ "tan terca y caprichosa como nadie \n"
+ "sencillamente yo no sere tu amigo \n"
+ "te tengo ganas y eso tu muy bien lo sabes \n"

+ "Por eso cuando nadie se de cuenta \n"
+ "voy a robarme tu corazoncito \n"
+ "veras que en el silencio de una noche \n"
+ "podras sentir tu cuerpo al lado mio \n"

+ "Hoy mi verdad es que tu nombre \n"
+ "tan solo no me ignores \n"
+ "yo muevo cielo y tierra por tenerte \n"
+ "que hasta me olvido del pasado \n"
+ "si estas aqui a mi lado \n"
+ "ya casi me doy cuenta \n"
+ "mi locquita enamorada de la vida \n"
+ "y amante en la eternidad \n"

+ "Cuando quieras quiero \n"
+ "{{ donde quieras quiero }} \n"
+ "yo dejo todo a un lado \n"
+ "{{ pa' sali' contigo }} \n"

+ "Que cuando quieras quiero \n"
+ "{{ una señal me basta }} \n"
+ "decirte lo de siempre \n"
+ "{{ aqui ya no hace falta }} \n"

+ "Hay un loco enamorado de la vida \n"
+ "Y amante a la eternidad \n"
+ "Cuando quieras quiero", "./files/letraCanciones/letra.txt");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
