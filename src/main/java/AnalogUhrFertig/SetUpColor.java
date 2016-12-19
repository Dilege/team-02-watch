package AnalogUhrFertig;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class SetUpColor extends Memory{
	static Color ausgewaehlteFarbe;
	static JMenuItem menuH;
	static JMenuItem menuS;
	public static Canvas canvas;
	public static void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		hintergrundFarbe = ausgewaehlteFarbe;
		canvas.setBackground(hintergrundFarbe);
	}

	public void chooseColorSchrift() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		schriftFarbe = ausgewaehlteFarbe;
		SetUp.farbe=schriftFarbe;

	}
    public static void ListenderHinterground(){
		menuH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorHinterground();
				SetUpMemory.store();
			}
			
		});
		hintergrundFarbe = hcolor;
		
	}
    public void ListenderSchrift(){
		menuS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorHinterground();
				SetUpMemory.store();
			}
			
		});
		hintergrundFarbe = hcolor;
		
	}
}
