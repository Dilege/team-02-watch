package digital;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JMenuItem menuHintergrund=new JMenuItem("Hintergrundfarbe");
	static JMenuItem menuSchrift=new JMenuItem("Schriftfarbe");

	public Gui() {
		Fenster();
				
	}

	// Frame
	public void Fenster() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		frame.setTitle("The Watch");
		button();
		restore();
		
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

	// Menu Einstellungen
	public void menuEinstellungen() {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu einstellungen = new JMenu("Einstellungen");
		menuBar.add(einstellungen);
		
		einstellungen.add(menuHintergrund);
		einstellungen.add(menuSchrift);
	    	frm=frame;
			menuHintergrund.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chooseColorHinterground();
					store();
				}
				
			});
			hintergrundFarbe = hcolor;
			StartStopp.Einlesen();
	}
	

	// START- STOPP Buttons
	public void button() {
		StartStopp.Uhr();
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
				StartStopp.stop();
			}
			
		});
	}

}
