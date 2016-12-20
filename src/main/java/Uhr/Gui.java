package Uhr;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	public Gui() {

		// Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("The Watch");
		getContentPane().setLayout(null);
		setResizable(false);


		// Menu Einstellungen
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu konfig = new JMenu("Einstellungen");
		menuBar.add(konfig);

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
						digital.Main.main(null);
						digital.StartStopp.timeF2.setVisible(false);
						digital.StartStopp.timeF.setBounds(100, 70, 180, 60);
						
					}
					});
				
				JMenuItem zweiUhren = new JMenuItem("Zwei Uhren");
				digitalUhren.add(zweiUhren);
				zweiUhren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						digital.Main.main(null);
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
		Dialog.hintergrundFarbe = Dialog.hcolor;
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
		Dialog.schriftFarbe = Dialog.scolor;

	}
}
