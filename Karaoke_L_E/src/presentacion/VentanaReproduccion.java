package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JWindow;

public class VentanaReproduccion extends JWindow{

	public final static String COMANDO_CERRAR_REPRODUCCION = "CERRAR_REPRODUCCION";
	private JButton botonCerrar;
	
	public VentanaReproduccion(GestionEventos gestionEventos) {
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.decode("#51C1F5"));
		this.setFocusable(true);
		
		botonCerrar = new JButton("Cerrar");
		botonCerrar.setActionCommand(COMANDO_CERRAR_REPRODUCCION);
		botonCerrar.addActionListener(gestionEventos);
		
		this.add(botonCerrar, BorderLayout.SOUTH);
	}
}
