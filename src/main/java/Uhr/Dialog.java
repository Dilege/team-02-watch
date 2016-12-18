package Uhr;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextField;

public class Dialog extends Memory {

	static Color ausgewaehlteFarbe;
	static JTextField lab;
	
	public Dialog() {

		try {
			restoreFile(frm);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Color farbeH =hcolor;
		frm.getContentPane().setBackground(farbeH);
	}

	public static void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		hintergrundFarbe = c;
		frm.getContentPane().setBackground(c);
	}

	public static void chooseColorSchrift() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		schriftFarbe = c;
		lab.setForeground(c);

	}
}
