package de.paettyb.visualizer;

import de.paettyb.visualizer.display.SelectionWindow;
import de.paettyb.visualizer.display.Window;

public class Main {

	private SelectionWindow selector;
	private Window window;

	public static int WIDTH = 1280, HEIGHT = 720;
	public static String TITLE = "Audio Visualizer";
	
	private Thread thread;

	public Main() {

		selector = new SelectionWindow(this);
	}

	public static void main(String[] args) {
		new Main();
	}

	public void switchStage(String path) {
		window = new Window(this, path);
		selector.dispose();
		selector = null;
		thread = new Thread("PlayerThread") {
			@Override
			public void run() {
				window.openAudio();
			}
		};
		thread.start();
		
		
	}
	
	
	
}
