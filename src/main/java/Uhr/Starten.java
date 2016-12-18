package Uhr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.Timer;

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
        Timer t = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//final JavaDialogHintergrundfarbe JavaDialogHintergrundfarbe = new JavaDialogHintergrundfarbe();
				//getContentPane().add(JavaDialogHintergrundfarbe);
				
				Calendar jetzt = Calendar.getInstance();
				int stunde = jetzt.get(Calendar.HOUR_OF_DAY);
				int min = jetzt.get(Calendar.MINUTE);
				int sec = jetzt.get(Calendar.SECOND);
				timeF.setText(+stunde + ":" + min + ":" + sec);
				timeF.setHorizontalAlignment(JTextField.CENTER);
				//timeF.setBackground(Color.red);
				timeF.setBackground(Uhr.JavaDialogHintergrundfarbe.tcc.getColor());
				
			}

		});
		t.start();
	}

}