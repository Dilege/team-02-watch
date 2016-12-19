package Uhr;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	final Integer[] schriftgroesse = { 20, 24, 28, 32, 36, 40 };
	int groesse = 18;
	
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
		JMenu analogue = new JMenu("AnalogUhr");
		menuBar.add(analogue);

		// Unter-Menu Hintergrundfarbe
		JMenuItem BackgroundColorItem = new JMenuItem("Hintergrundfarbe");
		BackgroundColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hintergrundfarbe auswaehlen");
				Farben.chooseColorHinterground();
				MemoryFarben memory = new MemoryFarben(new JFrame());
				memory.event();
				
		            }
		        });
		konfig.add(BackgroundColorItem);
		Farben.hintergrundFarbe=Farben.hcolor;
	
		
		// Unter-Menu Schriftfarbe
		JMenuItem writingColorItem = new JMenuItem("Schriftfarbe");
		writingColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Farben.chooseColorSchrift();
				MemoryFarben memory = new MemoryFarben(new JFrame());
				memory.event();
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
		
	/*	int[] liste = new int[10];
		
		liste[0]=50;
		liste[1]=45;
		liste[2]=40;
		liste[3]=35;
		liste[4]=30;
		liste[5]=25;
		liste[6]=20;
		liste[7]=15;
		liste[8]=10;
		liste[9]=5;
		}
		
	     JComboBox l=new JComboBox();
		
		comboBox.setBounds(342,0,102,20);
		getContentPane().add(l);*/
	}
}
