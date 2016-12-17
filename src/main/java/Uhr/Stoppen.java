package Uhr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.Timer;

public class Stoppen extends Gui{

	public static void stopp(){
		
		Timer t = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Calendar jetzt = Calendar.getInstance();
				int stunde = jetzt.get(Calendar.HOUR_OF_DAY);
				int min = jetzt.get(Calendar.MINUTE);
				int sec = jetzt.get(Calendar.SECOND);
				timeF.setText(+stunde + ":" + min + ":" + sec);
				timeF.setHorizontalAlignment(JTextField.CENTER);
			}

		});
		t.stop();
	}
		
}

