package Uhr;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dialog extends MemoryFarben {

	Color ausgewaehlteFarbe;
	JTextField lab = new JTextField();
	
	//JFrame f = new JFrame();
	JButton hinterground = new JButton();
	JButton schrift = new JButton();
	JMenuBar menu=new JMenuBar();
	JMenu einstellungen=new JMenu("Einstellungen");
	JMenuItem menuHintergrund=new JMenuItem("Hintergrundfarbe");
	JMenuItem menuSchrift=new JMenuItem("Schriftfarbe");
	
	JFrame f;

	public Dialog(JFrame frame) {
		super(frame);
		this.f = frame;
	}

	public void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		hintergrundFarbe = c;
		f.getContentPane().setBackground(c);
	}

	public void chooseColorSchrift() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		schriftFarbe = c;
		lab.setForeground(c);

	}

	/*public void settingButton() {
		hinterground.setBounds(320, 10, 20, 20);
		Container contentPane = f.getContentPane();
		contentPane.add(hinterground);
		f.add(hinterground);
		schrift.setBounds(350, 10, 20, 20);
		contentPane.add(schrift);
		f.add(schrift);
		ListenderHinterground();
		ListenderSchrift();
		
	}*/
	public void ListenderHinterground(){
		menuHintergrund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorHinterground();
				event();

			}
		});
		
		hintergrundFarbe=hcolor;
		
	}
	public void ListenderSchrift(){
		menuSchrift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorSchrift();
				event();

			}
		});
		schriftFarbe=scolor;
	}
	public void menu(){
		f.setJMenuBar(menu);
		menu.add(einstellungen);
		einstellungen.add(menuHintergrund);
		einstellungen.add(menuSchrift);
		ListenderHinterground();
		ListenderSchrift();
	}


	public void create() {
		f.setTitle("Mein JDialog Beispiel");
		f.setBounds(200, 200, 400, 300);
		try {
			restoreFile(f);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Color farbeH =hcolor;
		f.getContentPane().setBackground(farbeH);
		lab.setBounds(100, 100, 100, 40);
		lab.setForeground(scolor);
		f.add(lab);
		f.setLayout(null);
		menu();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);		
	}
}
