package de.paettyb.visualizer;

import javax.swing.JFrame;

public class Display extends JFrame {

	private static final long serialVersionUID = 1L;

	public static int WIDTH = 1280, HEIGHT = 720;
	public static String TITLE = "Visualizer";
	
	public Display() {
		super(TITLE);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

}
