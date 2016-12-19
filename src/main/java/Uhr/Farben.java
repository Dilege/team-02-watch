package Uhr;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Farben extends MemoryFarben {

	static Color ausgewaehlteFarbe;
	static JTextField lab = StartStopp.timeF;
	 

	public Farben() {

		try {
			restoreFile(frm);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Color farbeH =hcolor;
		frm.getContentPane().setBackground(farbeH);
		//lab.setBounds(100, 100, 100, 40);
		lab.setForeground(scolor);
		lab.setBackground(hintergrundFarbe);
		frm.add(lab);
		frm.setLayout(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		hintergrundFarbe=hcolor;
		schriftFarbe=scolor;
	}

	public static void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		//chooser.setPreviewPanel(new JPanel());
		Color c = ausgewaehlteFarbe;
		hintergrundFarbe = c;
		frm.getContentPane().setBackground(c);
	}

	public static  void chooseColorSchrift() { 
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		//chooser.setPreviewPanel(new JPanel());
		Color c = ausgewaehlteFarbe;
		schriftFarbe = c;
		lab.setForeground(c);

	}
	
}
