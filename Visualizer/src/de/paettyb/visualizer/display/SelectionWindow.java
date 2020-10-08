package de.paettyb.visualizer;

public class SelectionWindow extends Display {

	private static final long serialVersionUID = 2L;

	public SelectionWindow(Visualizer v) {
		super("Select File", 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new SelectorPane(v));

	}

}
