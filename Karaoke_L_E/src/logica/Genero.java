package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Genero implements Serializable{
	
	private String nombre;
	private ArrayList<Autor> listaAutores;
	private String imagenGenero;
	
	public Genero(String nombre, ArrayList<Autor> listaAutores,
			String imagenGenero) {
		super();
		this.nombre = nombre;
		this.listaAutores = listaAutores;
		this.imagenGenero = imagenGenero;
	}
	 public Genero() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}
	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}
	public String getImagenGenero() {
		return imagenGenero;
	}
	public void setImagenGenero(String imagenGenero) {
		this.imagenGenero = imagenGenero;
	}
	
	 
}
