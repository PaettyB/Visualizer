package de.paettyb.visualizer;

import javax.swing.JFrame;

public class Display extends JFrame {

	private static final long serialVersionUID = 1L;	
	
	public Display(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
