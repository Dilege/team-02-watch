package DigitalUhr;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SetUhrZeiten extends Memory {
	 public static void ListenderZeitEuropa(){
	    	frm=DisplayDigitalUhr.frame;
	    	DisplayDigitalUhr.europa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					timeZone=1;
					SetUpMemory.store();
					DigitalUhr.Uhr();
				}
				
			});
			timeZone=Memory.timeZoneRe;
		}
	 public static void ListenderZeitNewYork(){
		 frm=DisplayDigitalUhr.frame;
		 DisplayDigitalUhr.newYork.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					timeZone=2;
					SetUpMemory.store();
					DigitalUhr.Uhr();
				}
				
			});
			timeZone=Memory.timeZoneRe;
		}
	 public static void ListenderZeitTokyo(){
		 frm=DisplayDigitalUhr.frame;
		 DisplayDigitalUhr.tokyo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					timeZone=3;
					SetUpMemory.store();
					DigitalUhr.Uhr();
				}
				
			});
			timeZone=Memory.timeZoneRe;
		}
	 public static void ListenderZeitSydney(){
		 frm=DisplayDigitalUhr.frame;
		 DisplayDigitalUhr.sydney.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					timeZone=4;
					SetUpMemory.store();
					DigitalUhr.Uhr();
				}
				
			});
			timeZone=Memory.timeZoneRe;
		}
	 public static void ListenderZeitRio(){
		 frm=DisplayDigitalUhr.frame;
		 DisplayDigitalUhr.rio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					timeZone=5;
					SetUpMemory.store();
					DigitalUhr.Uhr();
				}
				
			});
			timeZone=Memory.timeZoneRe;
		}
	    
}
