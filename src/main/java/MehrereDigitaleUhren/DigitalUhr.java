package MehrereDigitaleUhren;

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

public class DigitalUhr extends DisplayMehrereDigitalUhr {

	private static final long serialVersionUID = 1L;
	public static JTextField timeF = new JTextField();
	public static JTextField timeF2 = new JTextField();
	public static JTextField timeF3 = new JTextField();
	public static JTextField timeF4 = new JTextField();
	public static JLabel labelEuropa = new JLabel("West Europa");
	public static JLabel labelNewYork = new JLabel("New York");
	public static JLabel labelTokyo = new JLabel("Tokyo");
	public static JLabel labelSydney = new JLabel("Sydney");
	public static boolean start = true;
	static Timer t;

	static Calendar jetztEuropa = Calendar.getInstance();
	static String textEuropa = String.format("%5tT", jetztEuropa);
	static Calendar jetztNewYork = Calendar.getInstance();
	static String textNewYork = String.format("%5tT", jetztNewYork);
	static Calendar jetztTokyo = Calendar.getInstance();
	static String textTokyo = String.format("%5tT", jetztTokyo);
	static Calendar jetztSydney = Calendar.getInstance();
	static String textSydney = String.format("%5tT", jetztSydney);

	static TimeZone tzEuropa = TimeZone.getTimeZone("Europe/Paris");
	static TimeZone tzNewYork = TimeZone.getTimeZone("America/New_York");
	static TimeZone tzTokyo = TimeZone.getTimeZone("Asia/Tokyo");
	static TimeZone tzSydney = TimeZone.getTimeZone("Australia/Sydney");

	public static void Uhr() {

		restore();
		frame.getContentPane().add(DigitalUhr.timeF);
		frame.getContentPane().add(DigitalUhr.timeF2);
		frame.getContentPane().add(DigitalUhr.timeF3);
		frame.getContentPane().add(DigitalUhr.timeF4);

		frame.add(labelEuropa);
		frame.add(labelNewYork);
		frame.add(labelTokyo);
		frame.add(labelSydney);

		timeF.setBounds(10, 30, 180, 60);
		timeF2.setBounds(200, 30, 180, 60);
		timeF3.setBounds(10, 130, 180, 60);
		timeF4.setBounds(200, 130, 180, 60);

		labelEuropa.setBounds(60, 0, 100, 30);
		labelEuropa.setForeground(new Color(0, 0, 0));
		labelNewYork.setBounds(260, 0, 100, 30);
		labelNewYork.setForeground(new Color(0, 0, 0));
		labelTokyo.setBounds(80, 100, 100, 30);
		labelTokyo.setForeground(new Color(0, 0, 0));
		labelSydney.setBounds(270, 100, 100, 30);
		labelSydney.setForeground(new Color(0, 0, 0));

		if (hintergrundFarbe != null) {

		} else {
			timeF.setBackground(hcolor);
			timeF2.setBackground(hcolor);
			timeF3.setBackground(hcolor);
			timeF4.setBackground(hcolor);
		}
		timeF.setBackground(hintergrundFarbe);
		timeF2.setBackground(hintergrundFarbe);
		timeF3.setBackground(hintergrundFarbe);
		timeF4.setBackground(hintergrundFarbe);

		if (schriftFarbe != null) {

			timeF.setForeground(schriftFarbe);
			timeF2.setForeground(schriftFarbe);
			timeF3.setForeground(schriftFarbe);
			timeF4.setForeground(schriftFarbe);
		} else {
			timeF.setForeground(scolor);
			timeF2.setForeground(scolor);
			timeF3.setForeground(scolor);
			timeF4.setForeground(scolor);

		}

		if (fnt != null) {

			timeF.setFont(fnt);
			timeF2.setFont(fnt);
			timeF3.setFont(fnt);
			timeF4.setFont(fnt);
		} else {
			timeF.setFont(schFont);
			timeF2.setFont(schFont);
			timeF3.setFont(schFont);
			timeF4.setFont(schFont);

		}

		timeF.setEditable(false);
		timeF2.setEditable(false);
		timeF3.setEditable(false);
		timeF4.setEditable(false);
		timeF.setHorizontalAlignment(JTextField.CENTER);
		timeF2.setHorizontalAlignment(JTextField.CENTER);
		timeF3.setHorizontalAlignment(JTextField.CENTER);
		timeF4.setHorizontalAlignment(JTextField.CENTER);
		timeF.setVisible(true);
		timeF2.setVisible(true);
		timeF3.setVisible(true);
		timeF4.setVisible(true);

	}

	public static void start() {

		t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jetztEuropa = Calendar.getInstance(tzEuropa);
				textEuropa = String.format("%5tT", jetztEuropa);
				jetztNewYork = Calendar.getInstance(tzNewYork);
				textNewYork = String.format("%5tT", jetztNewYork);
				jetztTokyo = Calendar.getInstance(tzTokyo);
				textTokyo = String.format("%5tT", jetztTokyo);
				jetztSydney = Calendar.getInstance(tzSydney);
				textSydney = String.format("%5tT", jetztSydney);
				timeF.setText(textEuropa);
				timeF2.setText(textNewYork);
				timeF3.setText(textTokyo);
				timeF4.setText(textSydney);

			}
		});
		t.start();
	}

	public static void stop() {
		timeF = new JTextField(10);
		timeF.setEditable(false);
		timeF2 = new JTextField(10);
		timeF2.setEditable(false);
		timeF3 = new JTextField(10);
		timeF3.setEditable(false);
		timeF4 = new JTextField(10);
		timeF4.setEditable(false);

		Timer t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jetztEuropa = Calendar.getInstance(tzEuropa);
				textEuropa = String.format("%5tT", jetztEuropa);
				jetztNewYork = Calendar.getInstance(tzNewYork);
				textNewYork = String.format("%5tT", jetztNewYork);
				jetztTokyo = Calendar.getInstance(tzTokyo);
				textTokyo = String.format("%5tT", jetztTokyo);
				jetztSydney = Calendar.getInstance(tzSydney);
				textSydney = String.format("%5tT", jetztSydney);
				// int stunde = jetzt.get(Calendar.HOUR_OF_DAY);
				// int min = jetzt.get(Calendar.MINUTE);
				// int sec = jetzt.get(Calendar.SECOND);
				// timeF.setText(+stunde + ":" + min + ":" + sec);

				timeF.setText(textEuropa);
				timeF2.setText(textNewYork);
				timeF3.setText(textTokyo);
				timeF4.setText(textSydney);

			}
		});
		t.stop();
	}

}