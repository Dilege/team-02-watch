package MehrereDigitaleUhren;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.TimeZone;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Memory {
	// Variable declaration
	static Color hintergrundFarbe;
	static Color schriftFarbe;
	static Font fnt;
	static Color hcolor;
	static Color scolor;
	static Font schFont;
	static Rectangle bnd;
	static File file = new File("MemoryMehrereDigital.txt");
	static Properties p = new Properties();
	static JFrame frm;
	static int timeZone, timeZoneRe;

	public static void storeFile(Frame f) throws IOException {
		// Hintergroundfarben in den Variablen hr,hg und hb speichern
		int hr = hintergrundFarbe.getRed();
		int hg = hintergrundFarbe.getGreen();
		int hb = hintergrundFarbe.getBlue();
		// Schriftfarben in den Variablen sr,sg und sb speichern
		int sr = schriftFarbe.getRed();
		int sg = schriftFarbe.getGreen();
		int sb = schriftFarbe.getBlue();
		// Schrifteigenschaften in den Variablen sch,art und size
		String sch = fnt.getFontName();
		int art = fnt.getStyle();
		int size = fnt.getSize();

		// Speichert die letzte Position vom Fenster in den variablen x,y
		// Speichert die hohe und die breite vom Fenster in den variablen b,h
		f.setExtendedState(Frame.NORMAL);
		Rectangle r = f.getBounds();
		int x = (int) r.getX();
		int y = (int) r.getY();
		int b = (int) r.getWidth();
		int h = (int) r.getHeight();

		// TimeZone wird in der variable timeZone gespeichert
		int timeZ = timeZone;
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
		// Die Properties in den file Color.txt schreiben
		BufferedWriter color = new BufferedWriter(new FileWriter(file));
		p.store(color, "FarbEigenschaften");
	}

	public static void restoreFile(Frame f) throws IOException {
		// Einlesen der Properties
		BufferedReader color = new BufferedReader(new FileReader(file));
		p.load(color);
		// Schreibt die eingelesenen Eigenschaften in den variablen sch,art und
		// size
		String sch = p.getProperty("sch");
		int art = Integer.parseInt(p.getProperty("art"));
		int size = Integer.parseInt(p.getProperty("size"));

		// Schreibt die eingelesenen Properties in den Variablen
		// hr,hg,hb,sr,sg,sb...
		int hr = Integer.parseInt(p.getProperty("hr"));
		int hg = Integer.parseInt(p.getProperty("hg"));
		int hb = Integer.parseInt(p.getProperty("hb"));
		int sr = Integer.parseInt(p.getProperty("sr"));
		int sg = Integer.parseInt(p.getProperty("sg"));
		int sb = Integer.parseInt(p.getProperty("sb"));
		int x = Integer.parseInt(p.getProperty("x"));
		int y = Integer.parseInt(p.getProperty("y"));
		int b = Integer.parseInt(p.getProperty("b"));
		int h = Integer.parseInt(p.getProperty("h"));
		int timeZ = Integer.parseInt(p.getProperty("timeZ"));

		// Mit dem Variablen zwei Color Objekt schreiben
		hcolor = new Color(hr, hg, hb);
		scolor = new Color(sr, sg, sb);
		schFont = new Font(sch, art, size);
		bnd = new Rectangle(x, y, b, h);
		timeZoneRe = timeZ;

	}

}
