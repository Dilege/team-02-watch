package Uhr;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import digital.StartStopp;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	public Gui() {

		// Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("The Watch");
		//setBackground(MemoryFarben.hcolor); 
		// setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setResizable(false);


		// Menu Einstellungen
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu konfig = new JMenu("Einstellungen");
		menuBar.add(konfig);
		// Menu ZeitZonen
		JMenu zz = new JMenu("ZeitZonen");
		menuBar.add(zz);
		// Menu Analogue Uhr

		JMenu ana = new JMenu("Analoguhr");
		menuBar.add(ana);
		JMenuItem analogue = new JMenuItem("Analoguhr starten");
		ana.add(analogue);
		analogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().removeAll();
				
				setTitle(null);
				repaint();
				SetUp set = new SetUp("Analog Watch", 400);
				set.start();
				repaint();
				setVisible(true);
			}
		});
		
		// Menu 2 Uhren

				JMenu digitalUhren = new JMenu("Digitale Uhren");
				menuBar.add(digitalUhren);
				
				JMenuItem einUhren = new JMenuItem("Eine Uhr");
				digitalUhren.add(einUhren);
			      einUhren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//setVisible(false);
						//getContentPane().removeAll();	
						//setTitle(null);
						//repaint();
						//digital.Gui version2 = new digital.Gui();	
						///Main.main(null);
						digital.Main.main(null);
						digital.StartStopp.timeF2.setVisible(false);
						digital.StartStopp.timeF.setBounds(100, 70, 180, 60);
						
					}
					});
				
				JMenuItem zweiUhren = new JMenuItem("Zwei Uhren");
				digitalUhren.add(zweiUhren);
				zweiUhren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//setVisible(false);
						//getContentPane().removeAll();	
						//setTitle(null);
						//repaint();
						//digital.Gui version2 = new digital.Gui();
						digital.Main.main(null);
						//SetUp set = new SetUp("Analog Watch", 400);
						//set.start();
						//repaint();
						//setVisible(true);
					}
				});

		// Unter-Menu Hintergrundfarbe
		JMenuItem BackgroundColorItem = new JMenuItem("Hintergrundfarbe");
		BackgroundColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hintergrundfarbe auswaehlen");
				Dialog.chooseColorHinterground();
				MemoryFarben memory = new MemoryFarben(new JFrame());
				memory.event();
	            

			}
		});
		Farben.hintergrundFarbe = Farben.hcolor;
		konfig.add(BackgroundColorItem);
	
		// Unter-Menu Schriftfarbe
		JMenuItem writingColorItem = new JMenuItem("Schriftfarbe");
		writingColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialog.chooseColorSchrift();
				MemoryFarben memory = new MemoryFarben(new JFrame());
				memory.event();
			
			}
		});
		konfig.add(writingColorItem);
			Farben.schriftFarbe = Farben.scolor;

		// Unter-Menu Schriftgroesse
		JMenuItem writingSize = new JMenuItem("Schriftgroesse");
		writingSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Schriftgroesse auswaehlen");

			}
		});
		konfig.add(writingSize);

		// START- STOPP Buttons
		final JButton startButton = new JButton("START");
		final JButton stoppButton = new JButton("STOPP");

		// START Button
		/*startButton.setBounds(10, 206, 202, 23);
		getContentPane().add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setText("Go!");
				stoppButton.setText("STOPP");
				StartStopp.start();
				getContentPane().add(StartStopp.timeF);
				StartStopp.timeF.setVisible(true);
				StartStopp.timeF.setForeground(Dialog.schriftFarbe); 
				StartStopp.timeF.setBackground(Dialog.hintergrundFarbe);
				
			}
		});

		// STOPP Button
		stoppButton.setBounds(229, 206, 195, 23);
		getContentPane().add(stoppButton);

		stoppButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setText("START");
				stoppButton.setText("STOPP");
				StartStopp.start();
			}
		});*/

	}
}
