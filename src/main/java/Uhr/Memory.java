package Uhr;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Memory {
	// Variable declaration
	static Color hintergrundFarbe;
	static Color schriftFarbe;
	static Color hcolor;
	static Color scolor;
	static File file = new File("setAnalog.txt");
	static Properties p = new Properties();
	static JFrame frm;

	public static void storeFile(JFrame f1) throws IOException {
        //Hintergroundfarben in den Variablen hr,hg und hb speichern
		int hr = hintergrundFarbe.getRed();
		int hg = hintergrundFarbe.getGreen();
		int hb = hintergrundFarbe.getBlue();
		//Schriftfarben in den Variablen sr,sg und sb speichern
		int sr = schriftFarbe.getRed();
		int sg = schriftFarbe.getGreen();
		int sb = schriftFarbe.getBlue();
		//Die ganzen Variablen in den "Properties p " speichern
		p.setProperty("hr", "" + hr);
		p.setProperty("hg", "" + hg);
		p.setProperty("hb", "" + hb);
		p.setProperty("sr", "" + sr);
		p.setProperty("sg", "" + sg);
		p.setProperty("sb", "" + sb);
		//Die Properties in den file Color.txt schreiben
		BufferedWriter color = new BufferedWriter(new FileWriter(file));
		p.store(color, "FarbEigenschaften");
	}

	public static void restoreFile(JFrame f2) throws IOException {
		//Einlesen der Properties
		BufferedReader color = new BufferedReader(new FileReader(file));
		p.load(color);

		// Schreibt die eingelesenen Properties in den Variablen hr,hg,hb,sr,sg und sb
		int hr = Integer.parseInt(p.getProperty("hr"));
		int hg = Integer.parseInt(p.getProperty("hg"));
		int hb = Integer.parseInt(p.getProperty("hb"));
		int sr = Integer.parseInt(p.getProperty("sr"));
		int sg = Integer.parseInt(p.getProperty("sg"));
		int sb = Integer.parseInt(p.getProperty("sb"));
		//Mit dem Variablen zwei Color Objekt schreiben
		hcolor = new Color(hr, hg, hb);
		scolor = new Color(sr, sg, sb);

	}

	
}
