package AnalogUhr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUhrArten extends Memory {
	public static void ListenderArtRund() {
		frm = Display.getFrame();
		Display.rund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				form1 = 1;
				form2 = 0;
				form3 = 0;
				form4 = 0;
				SetUpMemory.store();
			}

		});
		form1 = Memory.rund;
		form2 = Memory.rechteckig;
		form3 = Memory.ohneRand;
		form4 = Memory.rechteckigRund;
	}

	public static void ListenderArtRechteckig() {
		frm = Display.getFrame();
		Display.rechteckig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				form1 = 0;
				form2 = 1;
				form3 = 0;
				form4 = 0;
				SetUpMemory.store();
			}

		});
		form1 = Memory.rund;
		form2 = Memory.rechteckig;
		form3 = Memory.ohneRand;
		form4 = Memory.rechteckigRund;
	}

	public static void ListenderArtOhneRand() {
		frm = Display.getFrame();
		Display.ohneRand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				form1 = 0;
				form2 = 0;
				form3 = 1;
				form4 = 0;
				SetUpMemory.store();
			}

		});
		form1 = Memory.rund;
		form2 = Memory.rechteckig;
		form3 = Memory.ohneRand;
		form4 = Memory.rechteckigRund;
	}

	public static void ListenderArtRechteckigRund() {
		frm = Display.getFrame();
		Display.rechteckigRund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				form1 = 0;
				form2 = 0;
				form3 = 0;
				form4 = 1;
				SetUpMemory.store();
			}

		});
		form1 = Memory.rund;
		form2 = Memory.rechteckig;
		form3 = Memory.ohneRand;
		form4 = Memory.rechteckigRund;

	}
}
