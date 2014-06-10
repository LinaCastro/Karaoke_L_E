package persistencia;

import java.io.*;

import javax.swing.JFileChooser;

public class GestionArchivoPlano {
	private File file;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	public void crearArchivoPlano() {
		JFileChooser fileChooser =  new JFileChooser("src/files");
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChooser.getSelectedFile().getPath());
		}
	}
	public void leerPlano() throws IOException{
		JFileChooser fileChooser =  new JFileChooser("src/files");
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChooser.getSelectedFile().getPath());
		}
		fileReader = new FileReader(file);
		while (fileReader.read() != -1) {
			System.out.println((char)fileReader.read());
		}
	}
	public void escribirArchivoPlano() throws IOException {
		fileWriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("");
		bufferedWriter.close();
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
