package Uhr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.util.Calendar;


public class Clock extends JFrameUhr {
	public Clock() {
	}

	private static final long serialVersionUID = 1L;

	JPanel panel;

	public static void clock() {

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
		t.start();
	}
}