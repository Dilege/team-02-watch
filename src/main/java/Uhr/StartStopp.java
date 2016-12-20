package Uhr;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.Timer;

public class StartStopp extends Gui {

	private static final long serialVersionUID = 1L;
	static JTextField timeF = new JTextField();

	public static void start() {

		// UhrText Einstellungen
		timeF = new JTextField(10);
		//timeF.setVisible(true);
		timeF.setBounds(74, 61, 290, 80);
		//timeF.setForeground(MemoryFarben.schriftFarbe);
		// timeF.setFont(new Font("Arial", Font.HANGING_BASELINE, 48));
		timeF.setFont(new Font("Arial", Font.HANGING_BASELINE, 48));
		timeF.setEditable(false);
		timeF.setHorizontalAlignment(JTextField.CENTER);
		// timeF.setBackground(Farben.ausgewaehlteFarbe);
		// timeF.setForeground(Farben.hcolor);

		Timer t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar jetzt = Calendar.getInstance();
				String text = String.format("%5tT", jetzt);
				timeF.setText(text);

			}
		});
		t.start();
	}

	/*
	 * public static void stopp(){
	 * 
	 * timeF = new JTextField(10); timeF.setEditable(false);
	 * 
	 * Timer t = new Timer(1000, new ActionListener() { public void
	 * actionPerformed(ActionEvent e) { // Calendar jetzt =
	 * Calendar.getInstance(); // //int stunde =
	 * jetzt.get(Calendar.HOUR_OF_DAY); // //int min =
	 * jetzt.get(Calendar.MINUTE); // //int sec = jetzt.get(Calendar.SECOND); //
	 * //timeF.setText(+stunde + ":" + min + ":" + sec); // String text =
	 * String.format("%5tT", jetzt); // timeF.setText(text); } }); t.stop(); }
	 */
}