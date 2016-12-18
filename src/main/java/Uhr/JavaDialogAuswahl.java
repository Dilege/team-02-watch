package Uhr;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

main
public class JavaDialogAuswahl extends JPanel {

	/**
	 * Create the panel.
	 */
	public JavaDialogAuswahl() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 493, 379);
		add(tabbedPane);
		
		JavaDialogSchriftfarbe javaDialogSchriftfarbe = new JavaDialogSchriftfarbe();
		tabbedPane.addTab("Schriftfarbe", null, javaDialogSchriftfarbe, null);
		
		JavaDialogHintergrundfarbe javaDialogHintergrundfarbe = new JavaDialogHintergrundfarbe();
		tabbedPane.addTab("Hintergrundfarbe", null, javaDialogHintergrundfarbe, null);
		
		Gui gTheWatch = new Gui();
		gTheWatch.setVisible(true);
		tabbedPane.addTab("New tab", null, gTheWatch, null);
		
		
		

	}

}
