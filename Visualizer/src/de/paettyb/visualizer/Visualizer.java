package de.paettyb.visualizer;

public class Visualizer {

	private SelectionWindow selector;
	private Window window;

	public static int WIDTH = 1280, HEIGHT = 720;
	public static String TITLE = "Visualizer";

	public Visualizer() {

		selector = new SelectionWindow(this);
	}

	public static void main(String[] args) {
		new Visualizer();
	}

	public void switchStage(String path) {
		window = new Window(this, path);
		selector.dispose();
		selector = null;
	}

}
