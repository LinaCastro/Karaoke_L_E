package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JWindow;

public class VentanaReproduccion extends JWindow{

	private JButton botonCerrar;
	
	
	public VentanaReproduccion() {
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.decode("#51C1F5"));
		this.setFocusable(true);
		
		botonCerrar = new JButton();
		
	}
}
