package presentacion;

import java.awt.*;

import javax.swing.*;

public class Splash extends JWindow implements Runnable {

	private Thread t;
	private JProgressBar jProgressBarMain;
	private JPanelSplash jPanelInformation;
	private VentanaPrincipal ventanaPrincipal;

	public Splash() {
		// TODO Auto-generated constructor stub
		super();
		// El tamaño(size) ajustado a un porcentaje por eso el 0.3 % de la
		// pantalla
		this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth() * 0.3), (int) (Toolkit.getDefaultToolkit()
				.getScreenSize().getHeight() * 0.5));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		// Establece que esta ventana este por encima de otras
		this.setAlwaysOnTop(true);
		this.setBackground(Color.BLUE);
		ventanaPrincipal = new VentanaPrincipal();
		jProgressBarMain = new JProgressBar();
		jProgressBarMain.setIndeterminate(true);
		jProgressBarMain.setBackground(Color.decode("#DB7E04"));
		jProgressBarMain.setForeground(Color.decode("#000000"));
		jPanelInformation = new JPanelSplash();
		jPanelInformation.setBackgroundImage(jPanelInformation.createImage(
				"/img/splash.png").getImage());
		jPanelInformation.setBackground(Color.blue);
		this.add(jPanelInformation, BorderLayout.CENTER);
		this.add(jProgressBarMain, BorderLayout.SOUTH);
		// instancia del hilo
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		this.setVisible(true);
		try {
			// Tiempo que se demora en desaparecer el splash definido en
			// milisegundos
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// elimina la ventana splash
		this.dispose();
		//instancia el framematrix
		
		ventanaPrincipal.setVisible(true);
	}
	public static void main(String[] args) {
		Splash splashKaraoke = new Splash();
		splashKaraoke.setVisible(true);
	}
}
