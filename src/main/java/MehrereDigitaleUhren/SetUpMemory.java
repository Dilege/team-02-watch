package MehrereDigitaleUhren;

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
		File colorFile = new File("MemoryMehrereDigital.txt");
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
		// Default Schrift Einstellungen
		String sch = "Arial";
		int art = 1;
		int size = 30;
		// Default Position Einstellungen
		int x = 100;
		int y = 100;
		int b = 400;
		int h = 400;
		// Default TimeZonen Einstellungen
		int timeZ = 1;
		// Die ganzen Variablen in den "Properties p " speichern
		p.setProperty("hr", "" + hr);
		p.setProperty("hg", "" + hg);
		p.setProperty("hb", "" + hb);
		p.setProperty("sr", "" + sr);
		p.setProperty("sg", "" + sg);
		p.setProperty("sb", "" + sb);
		p.setProperty("sch", "" + sch);
		p.setProperty("art", "" + art);
		p.setProperty("size", "" + size);
		p.setProperty("x", "" + x);
		p.setProperty("y", "" + y);
		p.setProperty("b", "" + b);
		p.setProperty("h", "" + h);
		p.setProperty("timeZ", "" + timeZ);
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
