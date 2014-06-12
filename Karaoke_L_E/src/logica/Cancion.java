package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Cancion implements Serializable{

	private String nombre;
	private int duracion;
	private ArrayList<String> letraCancion;
	
	public Cancion(){
		letraCancion = new ArrayList<String>();
	}
	
	public Cancion(String nombre, int duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		letraCancion = new ArrayList<String>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public ArrayList<String> getLetraCancion() {
		return letraCancion;
	}

	public void setLetraCancion(ArrayList<String> letraCancion) {
		this.letraCancion = letraCancion;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	public void guardarLetra(String letra){
		for (int i = 0; i < letra.length(); i++) {
			letraCancion.add(letra.charAt(i)+"");
		}
	}
	
	public void tiempo(){
		
	}
	
	public void tiempoActual(){
		
	}
	public static void main(String[] args) {
		Cancion c = new Cancion();
		c.guardarLetra("We are one hu hu hu !!!!");
		for (int i = 0; i < c.getLetraCancion().size(); i++) {
			System.out.println(c.getLetraCancion().get(i));
			System.err.println(c.getLetraCancion().get(i));
		}

	}
}
