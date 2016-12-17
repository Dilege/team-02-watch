package Uhr;

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

	public JFrameUhr() {

		// Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("The Watch");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// Menu Einstellungen
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu konfig = new JMenu("Einstellungen");
		menuBar.add(konfig);

		// Unter-Menu Hintergrundfarbe
		JMenuItem BackgroundColorItem = new JMenuItem("Hintergrundfarbe");
		BackgroundColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hintergrundfarbe auswaehlen");
			}
		});
		konfig.add(BackgroundColorItem);

		// Unter-Menu Schriftfarbe
		JMenuItem writingColorItem = new JMenuItem("Schriftfarbe");
		writingColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Schriftfarbe auswaehlen");
			}
		});
		konfig.add(writingColorItem);

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

		// STOPP Button
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

}
