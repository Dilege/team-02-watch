package Uhr;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class JFrameUhr extends JFrame {
	public static JTextField timeF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameUhr frame = new JFrameUhr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameUhr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("The Watch");
		setLocationRelativeTo(null);

		// Menuezeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfuegen
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Menue (konfig) erzeugen und in die Menuezeile (JMenuBar) einfuegen
		JMenu konfig = new JMenu("Einstellungen");
		menuBar.add(konfig);

		// Menueeintraege (BackgroundColorItem) erzeugen und dem Menue (JMenu)
		// "Konfiguration" hinzufuegen
		JMenuItem BackgroundColorItem = new JMenuItem("Hintergrundfarbe");
		BackgroundColorItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Hintergrundfarbe auswaehlen");
			}
		});
		konfig.add(BackgroundColorItem);

		// Menüeinträge (writingColorItem) erzeugen und dem Menü (JMenu)
		// "Schriftfarbe" hinzufügen
		JMenuItem writingColorItem = new JMenuItem("Schriftfarbe");
		writingColorItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Schriftfarbe auswaehlen");
			}
		});
		konfig.add(writingColorItem);

		// Menüeinträge (writingSize) erzeugen und dem Menü (JMenu)
		// "Schriftfarbe" hinzufügen
		JMenuItem writingSize = new JMenuItem("Schriftgroesse");
		writingSize.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Schriftgroesse auswaehlen");
			}
		});
		konfig.add(writingSize);
		getContentPane().setLayout(null);

		final JButton startButton = new JButton("START");
		final JButton stoppButton = new JButton("STOPP");
		
		startButton.setBounds(10, 206, 202, 23);
		getContentPane().add(startButton);
		
		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startButton.setText("Go!");
				stoppButton.setText("STOPP");
				Starten start = new Starten();
				start.start();
				getContentPane().add(timeF);
				
				
				
				
			}
		});

		
		stoppButton.setBounds(229, 206, 195, 23);
		getContentPane().add(stoppButton);
		stoppButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startButton.setText("START");
				stoppButton.setText("finish");
				Stoppen.stopp(); 
				
			}
		});
		
		
		
		

	}
	/*public void start(){
	timeF = new JTextField(10);
	timeF.setBounds(74, 61, 290, 80);
	timeF.setFont(new Font("Arial", Font.HANGING_BASELINE, 48));
	
	timeF.setEditable(false);
	Clock.clock();
	}*/
}
