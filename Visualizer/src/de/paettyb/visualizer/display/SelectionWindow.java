package de.paettyb.visualizer.display;

import de.paettyb.visualizer.Display;
import de.paettyb.visualizer.Main;

public class SelectionWindow extends Display {

	private static final long serialVersionUID = 2L;

	public SelectionWindow(Main v) {
		super("Select File", 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new SelectorPane(v));

	}

}
