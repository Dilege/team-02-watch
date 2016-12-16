package Uhr;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Uhr.Starten;
import Uhr.Stoppen;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JFrameUhr extends JFrame {
	private JTextField textField;

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

		// Menueeintraege (writingColorItem) erzeugen und dem Menue (JMenu)
		// "Schriftfarbe" hinzufuegen
		JMenuItem writingColorItem = new JMenuItem("Schriftfarbe");
		writingColorItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Schriftfarbe auswaehlen");
			}
		});
		konfig.add(writingColorItem);

		// Menueeinträge (writingSize) erzeugen und dem Menue (JMenu)
		// "Schriftfarbe" hinzufuegen
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
				startButton.setText("GO!");
				stoppButton.setText("STOPP");
				Starten.start();
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

		JLabel lblWatchOurWatch = new JLabel("Watch our Watch!");
		lblWatchOurWatch.setBounds(10, 11, 120, 23);
		getContentPane().add(lblWatchOurWatch);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(74, 85, 285, 68);
		getContentPane().add(lblNewLabel);

	}
}
