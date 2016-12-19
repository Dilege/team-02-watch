package Uhr;

import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	 
	
	public Gui() {

		
		// Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("The Watch");
		//setLocationRelativeTo(null);
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
		
		JMenu ana=new JMenu("Analoguhr");
		menuBar.add(ana);
		JMenuItem analogue = new JMenuItem("Analoguhr starten");
		ana.add(analogue);
		analogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			    setVisible(false); 
				getContentPane().removeAll();
				//getContentPane().add(temporaryLostComponent, anchor, defaultCloseOperation);
				SetUp set = new SetUp("Analog Watch", 400);
			     set.start();
			     repaint();
			     setVisible(true); 
			     
			     
			
			       
			}

			

					
			
		});

		// Unter-Menu Hintergrundfarbe
		JMenuItem BackgroundColorItem = new JMenuItem("Hintergrundfarbe");
		BackgroundColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hintergrundfarbe auswaehlen");
				Farben.chooseColorHinterground();
				MemoryFarben.event();
				
		            }
		        });
		konfig.add(BackgroundColorItem);
		Farben.hintergrundFarbe=Farben.hcolor;
	
		
		// Unter-Menu Schriftfarbe
		JMenuItem writingColorItem = new JMenuItem("Schriftfarbe");
		writingColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Farben.chooseColorSchrift();
				MemoryFarben.event();
			}
		});
		konfig.add(writingColorItem);
		Farben.schriftFarbe=Farben.scolor;

		// Unter-Menu Schriftgroesse
		JMenuItem writingSize = new JMenuItem("Schriftgroesse");
		writingSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Schriftgroesse auswaehlen");
			}
		});
		konfig.add(writingSize);
		
		// Unter-Menu Zeitzone Europe
		JMenuItem europe = new JMenuItem("Europa/Paris");
		europe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Zeitzone Paris:");
			}
		});
		zz.add(europe);

		// Unter-Menu Zeitzone Europe
				JMenuItem amerika = new JMenuItem("Amerika/Boston");
				europe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Zeitzone Boston:");
					}
				});
				zz.add(amerika);
				
				
		// START- STOPP Buttons
		final JButton startButton = new JButton("START");
		final JButton stoppButton = new JButton("STOPP");

		// START Button
		startButton.setBounds(10, 206, 202, 23);
		getContentPane().add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setText("Go!");
				stoppButton.setText("STOPP");
				StartStopp.start();
				getContentPane().add(StartStopp.timeF);
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
		});
		
	

	}

}
