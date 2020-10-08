package de.paettyb.visualizer.display;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Control;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import de.paettyb.visualizer.Main;
import de.paettyb.visualizer.Visualizer;

public class Window extends Display {

	private static final long serialVersionUID = -3963991986921068781L;

	private Main main;
	private String path;
	
	private Visualizer v;

	public Window(Main main, String path) {
		super(Main.TITLE, Main.WIDTH, Main.HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new DrawPane());

		
		this.main = main;
		this.path = path;
		
		v = new Visualizer(main);
	}

	public void openAudio() {
		try {

			File file = new File(path);
			//AdvancedPlayer ap = new AdvancedPlayer(AudioSystem.getAudioInputStream(file));
			//ap.play();

			AudioInputStream in = AudioSystem.getAudioInputStream(file);
			AudioInputStream din = null;
			AudioFormat baseFormat = in.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			din = AudioSystem.getAudioInputStream(decodedFormat, in); // Play now

			rawplay(decodedFormat, din); in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void rawplay(AudioFormat targetFormat, AudioInputStream din) throws IOException, LineUnavailableException {
		byte[] data = new byte[4096];
		SourceDataLine line = getLine(targetFormat);

		FloatControl fc = (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
		fc.setValue(-40.0f);

		if (line != null) {
			// Start
			line.start();
			int nBytesRead = 0, nBytesWritten = 0;
			while (nBytesRead != -1) {
				nBytesRead = din.read(data, 0, data.length);
				if (nBytesRead != -1)
					
					
					
					nBytesWritten = line.write(data, 0, nBytesRead);
			}
			// Stop
			line.drain();
			line.stop();
			line.close();
			din.close();
		}
	}

	private SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException {
		SourceDataLine res = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		res = (SourceDataLine) AudioSystem.getLine(info);
		res.open(audioFormat);
		return res;
	}

}
