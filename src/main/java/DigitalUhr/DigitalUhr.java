package DigitalUhr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JSpinner;

public class DigitalUhr extends DisplayDigitalUhr {

	private static final long serialVersionUID = 1L;
	public static JTextField timeF = new JTextField();
	// public static JTextField timeF2 = new JTextField();
	public static boolean start = true;
	static Timer t;
	static Calendar jetzt = Calendar.getInstance();
	static Calendar hi = Calendar.getInstance();
	static String text = String.format("%5tT", jetzt);
	static TimeZone tz;

	public static void Uhr() {

		restore();
		timeZone();
		frame.getContentPane().add(DigitalUhr.timeF);
		// frame.getContentPane().add(DigitalUhr.timeF2);

		timeF.setBounds(110, 80, 180, 60);
		// timeF2.setBounds(200, 10, 180, 60);

		if (hintergrundFarbe != null) {

		} else {
			timeF.setBackground(hcolor);
			// timeF2.setBackground(hcolor);
		}
		timeF.setBackground(hintergrundFarbe);
		// timeF2.setBackground(hintergrundFarbe);

		if (schriftFarbe != null) {

			timeF.setForeground(schriftFarbe);
			// timeF2.setForeground(schriftFarbe);
		} else {
			timeF.setForeground(scolor);
			// timeF2.setForeground(scolor);

		}

		if (fnt != null) {

			timeF.setFont(fnt);
			// timeF2.setFont(fnt);
		} else {
			timeF.setFont(schFont);
			// timeF2.setFont(schFont);

		}

		timeF.setEditable(false);
		// timeF2.setEditable(false);
		timeF.setHorizontalAlignment(JTextField.CENTER);
		// timeF2.setHorizontalAlignment(JTextField.CENTER);
		timeF.setVisible(true);
		// timeF2.setVisible(true);

	}

	public static void start() {

		t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jetzt = Calendar.getInstance(tz);
				text = String.format("%5tT", jetzt);
				timeF.setText(text);
				// timeF2.setText(text);

			}
		});
		t.start();
	}

	public static void stop() {
		timeF = new JTextField(10);
		timeF.setEditable(false);
		// timeF2 = new JTextField(10);
		// timeF2.setEditable(false);

		Timer t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jetzt = Calendar.getInstance(tz);
				text = String.format("%5tT", jetzt);
				// int stunde = jetzt.get(Calendar.HOUR_OF_DAY);
				// int min = jetzt.get(Calendar.MINUTE);
				// int sec = jetzt.get(Calendar.SECOND);
				// timeF.setText(+stunde + ":" + min + ":" + sec);

				timeF.setText(text);
				// timeF2.setText(text);

			}
		});
		t.stop();
	}

	public static void timeZone() {
		if (Memory.timeZone == 1) {
			tz = TimeZone.getTimeZone("Europe/Paris");
		} else if (Memory.timeZone == 2) {
			tz = TimeZone.getTimeZone("America/New_York");
		} else if (Memory.timeZone == 3) {
			tz = TimeZone.getTimeZone("Asia/Tokyo");
		} else if (Memory.timeZone == 4) {
			tz = TimeZone.getTimeZone("Australia/Sydney");
		} else if (Memory.timeZone == 5) {
			tz = TimeZone.getTimeZone("America/Rio_Branco");
		}
		start();
	}
}