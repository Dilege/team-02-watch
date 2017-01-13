package AnalogUhr;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SetUpMemory extends Memory {

	public static void store() {
		frm.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent we) {

				try {
					storeFile(frm);
				} catch (Exception e) {

					e.printStackTrace();
				}

				// System.exit(0);
			}
		});

	}

	public static void restore() {
		File colorFile = new File("MemoryAnalog.txt");
		if (colorFile.exists()) {
			try {
				restoreFile(frm);
			} catch (Exception e) {

				e.printStackTrace();
			}

		} else {
			defaultFile();
		}
	}

	public static void defaultFile() {
		// Default HintergrundFarben
		int hr = 10;
		int hg = 60;
		int hb = 150;
		// Default SchriftFarben
		int sr = 150;
		int sg = 10;
		int sb = 60;
		// Default Art
		int a = 1;
		int b = 0;
		int c = 0;
		int d = 0;
		// Default Position Einstellungen
		int x = 400;
		int y = 400;
		// Default Time Einstellung
		int time = 1;
		// Die ganzen Variablen in den "Properties p " speichern
		p.setProperty("hr", "" + hr);
		p.setProperty("hg", "" + hg);
		p.setProperty("hb", "" + hb);
		p.setProperty("sr", "" + sr);
		p.setProperty("sg", "" + sg);
		p.setProperty("sb", "" + sb);
		p.setProperty("a", "" + a);
		p.setProperty("b", "" + b);
		p.setProperty("c", "" + c);
		p.setProperty("d", "" + d);
		p.setProperty("x", "" + x);
		p.setProperty("y", "" + y);
		p.setProperty("time", "" + time);
		BufferedWriter color;
		try {
			color = new BufferedWriter(new FileWriter(file));
			p.store(color, "FarbEigenschaften");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		restore();
	}
}
