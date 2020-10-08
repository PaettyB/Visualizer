package de.paettyb.visualizer.display;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import de.paettyb.visualizer.Main;

public class SelectorPane extends JPanel implements ActionListener {

	private Main v;
	private JFileChooser fc;

	private static final long serialVersionUID = 1450035610820399971L;

	private JButton button;

	public SelectorPane(Main v) {
		this.v = v;
		button = new JButton("Select File");
		button.addActionListener(this);
		add(button);
	}

	public void paintComponent(Graphics g) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File("F:\\NCS Musik\\NCS"));
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			String s = fc.getSelectedFile().getAbsolutePath();
			v.switchStage(s);
		}

	}
}
