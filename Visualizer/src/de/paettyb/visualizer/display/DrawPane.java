package de.paettyb.visualizer;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPane extends JPanel {

	private static final long serialVersionUID = -7631924581219282673L;

	public void paintComponent(Graphics g) {
		g.fillRect(20, 20, 100, 200);
	}

}
