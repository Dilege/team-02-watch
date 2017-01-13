package AnalogUhr;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Display extends SetUpMemory {
	Color ausgewaehlteFarbe;
	private String title;
	private static int size;
	private static JFrame frame;

	JMenuItem menuHintergrund = new JMenuItem("Hintergrundfarbe");
	JMenuItem menuSchrift = new JMenuItem("Schriftfarbe");
	static JMenuItem rund = new JMenuItem("Rund");
	static JMenuItem rechteckig = new JMenuItem("Rechteckig");
	static JMenuItem ohneRand = new JMenuItem("Ohne Rand");
	static JMenuItem rechteckigRund = new JMenuItem("Rechteckig Rund");
	static JMenuItem europa = new JMenuItem("Zeit West Europa");
	static JMenuItem newYork = new JMenuItem("Zeit New York");
	static JMenuItem tokyo = new JMenuItem("Zeit Tokyo");
	static JMenuItem sydney = new JMenuItem("Zeit Sydney");
	static JMenuItem rio = new JMenuItem("Zeit Rio");
	public static Canvas canvas;

	public Display(String title, int size) {

		this.title = title;
		this.setSize(size);
		fenster();

	}

	public void fenster() {
		frm = getFrame();
		setFrame(new JFrame(title));
		getFrame().setSize(getSize(), getSize());
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().setResizable(false);
		restore();
		eischtellunegenMenu();
		canvas = new Canvas();
		// canvas.setPreferredSize(new Dimension(size, size));
		einstellungenPosition();

		canvas.setBackground(hcolor);
		SetUp.farbe = scolor;
		ListenderHinterground();
		ListenderSchrift();
		SetUhrArten.ListenderArtRund();
		SetUhrArten.ListenderArtRechteckig();
		SetUhrArten.ListenderArtOhneRand();
		SetUhrArten.ListenderArtRechteckigRund();
		SetUhrZeiten.ListenderZeitEuropa();
		SetUhrZeiten.ListenderZeitNewYork();
		SetUhrZeiten.ListenderZeitTokyo();
		SetUhrZeiten.ListenderZeitSydney();
		SetUhrZeiten.ListenderZeitRio();
		getFrame().add(canvas);
		getFrame().pack();
		store();
		getFrame().setVisible(true);
	}

	public void eischtellunegenMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu einstellungen = new JMenu("Einstellungen");
		JMenu auswahl = new JMenu("Uhr Arten");
		JMenu uhrZeiten = new JMenu("Uhr Zeiten");
		menu = new JMenuBar();
		getFrame().setJMenuBar(menu);
		menu.add(einstellungen);
		menu.add(auswahl);
		menu.add(uhrZeiten);
		einstellungen.add(menuHintergrund);
		einstellungen.add(menuSchrift);
		auswahl.add(rund);
		auswahl.add(rechteckig);
		auswahl.add(rechteckigRund);
		auswahl.add(ohneRand);
		uhrZeiten.add(europa);
		uhrZeiten.add(newYork);
		uhrZeiten.add(tokyo);
		uhrZeiten.add(sydney);
		uhrZeiten.add(rio);
	}

	public void einstellungenPosition() {
		frm = getFrame();
		canvas.setBounds(bnd);
		frame.setBounds(bnd);
	}

	public void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		hintergrundFarbe = ausgewaehlteFarbe;
		canvas.setBackground(hintergrundFarbe);
	}

	public void chooseColorSchrift() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		schriftFarbe = ausgewaehlteFarbe;
		SetUp.farbe = schriftFarbe;

	}

	public void ListenderHinterground() {
		frm = getFrame();
		menuHintergrund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorHinterground();
				store();
			}

		});
		hintergrundFarbe = hcolor;

	}

	public void ListenderSchrift() {
		frm = getFrame();
		menuSchrift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorSchrift();
				store();

			}
		});
		schriftFarbe = scolor;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		Display.frame = frame;
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Display.size = size;
	}

}