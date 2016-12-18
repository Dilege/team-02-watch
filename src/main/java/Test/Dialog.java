package Test;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
// Import-Anweisung f�r unser JLabel 
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dialog extends Memory {

	Color ausgewaehlteFarbe;
	JLabel lab = new JLabel("Beispiel JLabel");
	//JFrame f = new JFrame();
	JButton hinterground = new JButton();
	JButton schrift = new JButton();

	public static void main(String[] args) {
		new Dialog();
	}
	
	public Dialog() {

		//frm = f;
		//frm.setTitle("Mein JDialog Beispiel");
		//f.setBounds(200, 200, 400, 300);
		try {
			restoreFile(frm);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Color farbeH =hcolor;
		frm.getContentPane().setBackground(farbeH);
		lab.setBounds(100, 100, 100, 40);
		lab.setForeground(scolor);
		frm.add(lab);
		//f.setLayout(null);
		settingButton();
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setVisible(true);
	}

	public void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		hintergrundFarbe = c;
		frm.getContentPane().setBackground(c);
	}

	public void chooseColorSchrift() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		schriftFarbe = c;
		lab.setForeground(c);

	}

	public void settingButton() {
		hinterground.setBounds(320, 10, 20, 20);
		Container contentPane = frm.getContentPane();
		contentPane.add(hinterground);
		frm.add(hinterground);
		schrift.setBounds(350, 10, 20, 20);
		contentPane.add(schrift);
		frm.add(schrift);
		ListenderHinterground();
		ListenderSchrift();
		
	}
	public void ListenderHinterground(){
		hinterground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorHinterground();
				event();

			}
		});
		
		hintergrundFarbe=hcolor;
		
	}
	public void ListenderSchrift(){
		schrift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorSchrift();
				event();

			}
		});
		schriftFarbe=scolor;
	}
}
