package Uhr;

import java.awt.Font;
import javax.swing.JTextField;

public class Starten extends Gui {

	private static final long serialVersionUID = 1L;
	Gui frame;

	public void start() {
        // UhrText Einstellungen
		timeF = new JTextField(10);
		timeF.setVisible(true);
		timeF.setBounds(74, 61, 290, 80);
		timeF.setFont(new Font("Arial", Font.HANGING_BASELINE, 48));
        timeF.setEditable(false);
        
        //Aufrufen der Zeit
		Clock.clock();
	}

}