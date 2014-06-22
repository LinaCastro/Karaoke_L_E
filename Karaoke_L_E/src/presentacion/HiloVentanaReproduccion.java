package presentacion;

import logica.Cancion;

public class HiloVentanaReproduccion extends Thread{

	private VentanaReproduccion ventanaReproduccion;
	private boolean ejecution;
	private boolean pause;
	
	public HiloVentanaReproduccion(VentanaReproduccion reproduccion) {
		ventanaReproduccion = reproduccion;
		ventanaReproduccion.setVisible(true);
	}
	public void iniciar(){
		ejecution = true;
		if (!this.isAlive()) {
			this.start();
		}else
			reanudar();
	}
	public void detener(){
		ejecution = false;
	}
	public void pausar(){
		pause = true;
	}
	public void reanudar(){
		pause = false;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (ejecution) {
			ventanaReproduccion.terminoTablero();
			try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ventanaReproduccion.pintarLetraCancion();
			try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ventanaReproduccion.aumentarposicionCaracter();
			while (pause) {
				System.out.println("pausa");
			}
		}
	}
}
