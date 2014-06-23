package presentacion;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class JPanelSplash extends JPanel {

	private Image image;
	private JLabel jLabelCreditos;
	private JLabel jLabelName;
	private JLabel jLabelVersion;
	
	public JPanelSplash() {
		super();
		// Hacemos que el panel sea transparente
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,1));
		Font font = new Font("Algerian", Font.BOLD, 20);
		jLabelName = new JLabel("");
		jLabelName.setForeground(Color.white);
		jLabelName.setFont(new Font("Fixed Miriam Transparent",Font.BOLD,40));
		jLabelCreditos = new JLabel("UPTC");
		jLabelCreditos.setFont(font);
		jLabelCreditos.setForeground(Color.white);
		jLabelVersion = new JLabel("Versión 1.0");
		jLabelVersion.setFont(font);
		jLabelVersion.setForeground(Color.white);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(jLabelName);
		this.add(jLabelCreditos);
		this.add(jLabelVersion);
	}
	public void setBackgroundImage(Image bgImage) {
		this.image = bgImage;
	}
	public ImageIcon createImage(String path) {
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	@Override
	public void paint(Graphics g) {
		Dimension tamanio = this.getSize();
		// Pintamos la imagen de fondo...
		if (image != null) {
			g.drawImage(image, 0, 0, tamanio.width, tamanio.height, null);
		}
		// Y pintamos el resto de cosas que pueda tener el panel
		super.paint(g);

	}
}
