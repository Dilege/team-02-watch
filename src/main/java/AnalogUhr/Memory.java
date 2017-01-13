package AnalogUhr;

import java.awt.Color;
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

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Memory {
	// Variable declaration
	static Color hintergrundFarbe;
	static Color schriftFarbe;
	static int rund;
	static int rechteckig;
	static int ohneRand;
	static int rechteckigRund;
	static int form1, form2, form3, form4;
	static int time1;
	static int timeZone;
	static Color hcolor;
	static Color scolor;
	static Rectangle bnd;
	static File file = new File("MemoryAnalog.txt");
	static Properties p = new Properties();
	static JFrame frm;

	public static void storeFile(Frame f) throws IOException {
		// Hintergroundfarben in den Variablen hr,hg und hb speichern
		int hr = hintergrundFarbe.getRed();
		int hg = hintergrundFarbe.getGreen();
		int hb = hintergrundFarbe.getBlue();
		// Schriftfarben in den Variablen sr,sg und sb speichern
		int sr = schriftFarbe.getRed();
		int sg = schriftFarbe.getGreen();
		int sb = schriftFarbe.getBlue();
		// Art der Uhr in den Variablen a,b,c und d speichern
		int a = form1;
		int b = form2;
		int c = form3;
		int d = form4;
		// ZeitZonen werden in der Variable time gespeichert
		int time = timeZone;
		// Speichert die letzte Position vom Fenster in den variablen x,y
		// Speichert die hohe und die breite vom Fenster in den variablen b,h
		f.setExtendedState(Frame.NORMAL);
		Rectangle r = f.getBounds();
		int x = (int) r.getX();
		int y = (int) r.getY();
		int br = (int) r.getWidth();
		int h = (int) r.getHeight();

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
		p.setProperty("br", "" + br);
		p.setProperty("h", "" + h);
		p.setProperty("time", "" + time);
		// Die Properties in den file Color.txt schreiben
		BufferedWriter color = new BufferedWriter(new FileWriter(file));
		p.store(color, "FarbEigenschaften");
	}

	public static void restoreFile(JFrame f2) throws IOException {
		// Einlesen der Properties
		BufferedReader color = new BufferedReader(new FileReader(file));
		p.load(color);

		// Schreibt die eingelesenen Properties in den Variablen hr,hg,hb,sr,sg
		// und sb
		int hr = Integer.parseInt(p.getProperty("hr"));
		int hg = Integer.parseInt(p.getProperty("hg"));
		int hb = Integer.parseInt(p.getProperty("hb"));
		int sr = Integer.parseInt(p.getProperty("sr"));
		int sg = Integer.parseInt(p.getProperty("sg"));
		int sb = Integer.parseInt(p.getProperty("sb"));
		int a = Integer.parseInt(p.getProperty("a"));
		int b = Integer.parseInt(p.getProperty("b"));
		int c = Integer.parseInt(p.getProperty("c"));
		int d = Integer.parseInt(p.getProperty("d"));
		int x = Integer.parseInt(p.getProperty("x"));
		int y = Integer.parseInt(p.getProperty("y"));
		int time = Integer.parseInt(p.getProperty("time"));
		int br = 400;
		int h = 400;
		// Mit dem Variablen zwei Color Objekt schreiben
		hcolor = new Color(hr, hg, hb);
		scolor = new Color(sr, sg, sb);
		rund = a;
		rechteckig = b;
		ohneRand = c;
		rechteckigRund = d;
		bnd = new Rectangle(x, y, br, h);
		time1 = time;

	}

}
