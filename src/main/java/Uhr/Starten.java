package Uhr;

import java.awt.Font;

import javax.swing.JTextField;


public class Starten extends JFrameUhr{
	
	JFrameUhr frame;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Starten (){

}

	public void start() {

	timeF = new JTextField(10);
	timeF.setVisible(true);
		timeF.setBounds(74, 61, 290, 80);
		timeF.setFont(new Font("Arial", Font.HANGING_BASELINE, 48));
		
		timeF.setEditable(false);	
		
		Clock.clock();
		
		/*try {
			while (on) {
				java.util.Date now = new java.util.Date();
				java.text.SimpleDateFormat sfd = new java.text.SimpleDateFormat("HH:mm:ss");
				String ausgabe = sfd.format(now);
				System.out.println(ausgabe);
				Thread.sleep(1000);

			}
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}*/
	}

}