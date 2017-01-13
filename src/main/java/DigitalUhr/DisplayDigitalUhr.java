package DigitalUhr;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Timer;

public class DisplayDigitalUhr extends SetUpMemory {
	static JFrame frame = new JFrame();
	static Color ausgewaehlteFarbe;
	static Timer timer;
	static Font font;
	JMenuItem menuHintergrund = new JMenuItem("Hintergrundfarbe");
	static JMenuItem menuSchrift = new JMenuItem("Schriftfarbe");
	static JMenuItem menuSchriftEinstellungen = new JMenuItem(
			"SchriftEinstellungen");
	static JMenuItem europa = new JMenuItem("Zeit West Europa");
	static JMenuItem newYork = new JMenuItem("Zeit New York");
	static JMenuItem tokyo = new JMenuItem("Zeit Tokyo");
	static JMenuItem sydney = new JMenuItem("Zeit Sydney");
	static JMenuItem rio = new JMenuItem("Zeit Rio");

	public DisplayDigitalUhr() {
		Fenster();
	}

	// Frame
	public void Fenster() {

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frm = frame;
		positionEinstellungen();

		SetUhrZeiten.ListenderZeitEuropa();
		SetUhrZeiten.ListenderZeitNewYork();
		SetUhrZeiten.ListenderZeitTokyo();
		SetUhrZeiten.ListenderZeitSydney();
		SetUhrZeiten.ListenderZeitRio();

		frame.setTitle("The Watch");
		DigitalUhr.start();
		button();
		frame.getContentPane().setBackground(hcolor);
		// setLocationRelativeTo(null);
		menuEinstellungen();
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void schriftEinstellungen() {
		frm = frame;
		SetSchrift.f = frame;
		final SetSchrift fc = new SetSchrift(frame);
		menuSchriftEinstellungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fc.setVisible(true);
				font = fc.getSelectedFont();
				fnt = font;
				System.out.println("You chose " + font);
				fc.dispose();
				store();
				DigitalUhr.Uhr();
			}
		});
		fnt = schFont;

	}

	public void chooseColorHinterground() {
		SetFarben.chooseColor();
		hintergrundFarbe = SetFarben.ausgewaehlteFarbe;
		frame.getContentPane().setBackground(hintergrundFarbe);
	}

	public static void chooseColorSchrift() {
		SetFarben.chooseColor();
		schriftFarbe = SetFarben.ausgewaehlteFarbe;
	}

	public void positionEinstellungen() {
		frm = frame;
		restore();
		frame.setBounds(bnd);
		store();
	}

	// Menu Einstellungen
	public void menuEinstellungen() {
		frm = frame;
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu einstellungen = new JMenu("Einstellungen");
		JMenu uhrZeiten = new JMenu("Uhr Zeiten");
		menuBar.add(einstellungen);
		menuBar.add(uhrZeiten);

		einstellungen.add(menuHintergrund);
		einstellungen.add(menuSchrift);
		einstellungen.add(menuSchriftEinstellungen);

		uhrZeiten.add(europa);
		uhrZeiten.add(newYork);
		uhrZeiten.add(tokyo);
		uhrZeiten.add(sydney);
		uhrZeiten.add(rio);

		menuHintergrund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frm = frame;
				chooseColorHinterground();
				DigitalUhr.Uhr();
				store();
			}

		});
		hintergrundFarbe = hcolor;

		menuSchrift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetFarben.chooseColor();
				schriftFarbe = SetFarben.ausgewaehlteFarbe;
				DigitalUhr.Uhr();
				store();
			}
		});
		schriftFarbe = scolor;
		schriftEinstellungen();
	}

	// START- STOPP Buttons
	public void button() {
		frm = frame;
		DigitalUhr.Uhr();
		DigitalUhr.t = timer;
		final JButton startButton = new JButton("START");
		final JButton stoppButton = new JButton("STOP");

		// START Button
		startButton.setBounds(65, 200, 100, 40);
		frame.getContentPane().add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setText("Go!");
				stoppButton.setText("STOP");
				frm = frame;
				DigitalUhr.Uhr();
				// StartStopp.Color();
				DigitalUhr.start();

			}
		});

		// STOPP Button
		stoppButton.setBounds(230, 200, 100, 40);
		frame.getContentPane().add(stoppButton);
		stoppButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setText("START");
				stoppButton.setText("Stop!");
				frm = frame;
				// StartStopp.Color();
				DigitalUhr.stop();
			}

		});
	}

}
