
package digital;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JSpinner;

public class StartStopp extends Gui {
	
		private static final long serialVersionUID = 1L;
		 static  JTextField timeF = new JTextField();
		 static  JTextField timeF2 = new JTextField();
		 static Color farbeSchrift;
		 static Color farbeHintergrung;
		 static Timer t ;
      public static void Einlesen(){
    	  menuSchrift.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chooseColorSchrift();
					store();

				}
			});
			schriftFarbe = scolor;
			
		}
      public static void chooseColorSchrift() {
  		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
  		 schriftFarbe = ausgewaehlteFarbe;
  		farbeSchrift=schriftFarbe;
  		timeF.setForeground(farbeSchrift);
		timeF2.setForeground(farbeSchrift);

  	}
    
      public static void Color(){
    	  timeF.setForeground(scolor);
		timeF2.setForeground(scolor);
      }
		 public static void Uhr(){
			 timeF.setBackground(farbeHintergrung);
				timeF2.setBackground(farbeHintergrung);
			   frame.getContentPane().add(StartStopp.timeF);
			   frame.getContentPane().add(StartStopp.timeF2);
				System.out.println(farbeSchrift);
				System.out.println(farbeHintergrung);
				start();
				restore();
				
				
				//timeF.setVisible(true);
				//timeF2.setVisible(true);
				timeF.setBounds(10, 10, 180, 60);
				timeF2.setBounds(200, 10, 180, 60);
				//timeF.setForeground(MemoryFarben.schriftFarbe);
				timeF.setFont(new Font("Arial", Font.HANGING_BASELINE, 30));
				timeF2.setFont(new Font("Arial", Font.HANGING_BASELINE, 30));
		        timeF.setEditable(false);
		        timeF2.setEditable(false);
		        timeF.setHorizontalAlignment(JTextField.CENTER);
		        timeF2.setHorizontalAlignment(JTextField.CENTER);
		        //timeF.setBackground(Farben.ausgewaehlteFarbe);
		        //timeF.setForeground(Farben.hcolor);
		        timeF.setVisible(true);
				timeF2.setVisible(true);
			       
		 }
		 public static void start(){
			  t = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Calendar jetzt = Calendar.getInstance();
						String text = String.format("%5tT", jetzt);
					    timeF.setText(text);
					    timeF2.setText(text);
			
					}
					}); 
			  t.start();
		 }
	
		public static void stop(){
			
			timeF = new JTextField(10);
	        timeF.setEditable(false);
	        timeF2 = new JTextField(10);
	        timeF2.setEditable(false);
	        
			Timer t = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Calendar jetzt = Calendar.getInstance();
//					//int stunde = jetzt.get(Calendar.HOUR_OF_DAY);
//					//int min = jetzt.get(Calendar.MINUTE);
//					//int sec = jetzt.get(Calendar.SECOND);
//					//timeF.setText(+stunde + ":" + min + ":" + sec);
				String text = String.format("%5tT", jetzt);
			    timeF.setText(text);
			    timeF2.setText(text);
				}
			});
			t.stop();
		}
}