package logica;

import java.io.Serializable;

public class Cancion implements Serializable{

	private String nombre;
	private int duracion;
	
	public Cancion(){

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
}
