package AnalogUhr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUhrZeiten extends Memory {
	public static void ListenderZeitEuropa() {
		frm = Display.getFrame();
		Display.europa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeZone = 1;
				SetUpMemory.store();
			}

		});
		timeZone = Memory.time1;
	}

	public static void ListenderZeitNewYork() {
		frm = Display.getFrame();
		Display.newYork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeZone = 7;
				SetUpMemory.store();
			}

		});
		timeZone = Memory.time1;
	}

	public static void ListenderZeitTokyo() {
		frm = Display.getFrame();
		Display.tokyo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeZone = 9;
				SetUpMemory.store();
			}

		});
		timeZone = Memory.time1;
	}

	public static void ListenderZeitSydney() {
		frm = Display.getFrame();
		Display.sydney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeZone = 11;
				SetUpMemory.store();
			}

		});
		timeZone = Memory.time1;
	}

	public static void ListenderZeitRio() {
		frm = Display.getFrame();
		Display.rio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeZone = 10;
				SetUpMemory.store();
			}

		});
		timeZone = Memory.time1;
	}

}
