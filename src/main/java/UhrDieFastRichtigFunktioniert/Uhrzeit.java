package UhrDieFastRichtigFunktioniert;
import java.awt.Component;
import java.awt.Graphics;

public class Uhrzeit  {
	
	public static String getZeit() {
		boolean on;
		on = true;
		String ausgabe = null;
		
			
				java.util.Date now = new java.util.Date();
				java.text.SimpleDateFormat sfd = new java.text.SimpleDateFormat("HH:mm:ss");
				ausgabe = sfd.format(now);
				
				
		return ausgabe;
	}

	public void paint(Graphics g) {
		
		
	}
	
}
