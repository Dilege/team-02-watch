package digital;
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

public class Gui extends SetUpMemory {
	static JFrame frame = new JFrame();
	static Color ausgewaehlteFarbe;
	static Timer timer;
	static Font font;
	JMenuItem menuHintergrund=new JMenuItem("Hintergrundfarbe");
	static JMenuItem menuSchrift=new JMenuItem("Schriftfarbe");
	static JMenuItem menuSchriftGreosse=new JMenuItem("Schriftgreosse");

	public Gui() {
		Fenster();
				
	}
	public void position(){
		frm=frame;
		store();
		restore();
	}

	// Frame
	public void Fenster() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//.DISPOSE_ON_CLOSE
		
		frame.setBounds(100, 100, 400, 400);
		frame.setTitle("The Watch");
		button();
		restore();
		//position();
		frame.getContentPane().setBackground(hcolor);
		// setLocationRelativeTo(null);
		menuEinstellungen();
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		hintergrundFarbe= ausgewaehlteFarbe;
		frame.getContentPane().setBackground(hintergrundFarbe);
		StartStopp.farbeHintergrung=hintergrundFarbe;
	}
	public void schriftgroesse(){
		Schriftgroesse.f=frame;
		final Schriftgroesse fc = new Schriftgroesse(frame);
		menuSchriftGreosse.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        fc.setVisible(true);
		        font = fc.getSelectedFont();
		        System.out.println("You chose " + font);
		        
		        fc.dispose();
		      }
		    });
	}

	// Menu Einstellungen
	public void menuEinstellungen() {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu einstellungen = new JMenu("Einstellungen");
		menuBar.add(einstellungen);
		
		einstellungen.add(menuHintergrund);
		einstellungen.add(menuSchrift);
		einstellungen.add(menuSchriftGreosse);
		
	    	frm=frame;
			menuHintergrund.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chooseColorHinterground();
					store();
				}
				
			});
			hintergrundFarbe = hcolor;
			StartStopp.Einlesen();
			schriftgroesse();
	}
	

	// START- STOPP Buttons
	public void button() {
		StartStopp.Uhr();
		//StartStopp.Color();
		StartStopp.t=timer;
		final JButton startButton = new JButton("START");
		final JButton stoppButton = new JButton("STOP");

		// START Button
		startButton.setBounds(65, 200, 100, 40);
		frame.getContentPane().add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setText("Go!");
				stoppButton.setText("STOP");
				StartStopp.Uhr();
				//StartStopp.Color();
		        StartStopp.start();
		        
				
			}
		});
                
		// STOPP Button
		stoppButton.setBounds(230, 200, 100, 40);
		frame.getContentPane().add(stoppButton);
		stoppButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setText("START");
				stoppButton.setText("Stop!");
				//StartStopp.Color();
				StartStopp.stop();
			}
			
		});
	}

}
