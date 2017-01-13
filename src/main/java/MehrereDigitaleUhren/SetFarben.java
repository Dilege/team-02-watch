package MehrereDigitaleUhren;

import java.awt.Color;

import javax.swing.JColorChooser;

public class SetFarben {
	static Color ausgewaehlteFarbe;

	public static void chooseColor() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);

	}

}
