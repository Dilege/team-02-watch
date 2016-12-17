package Uhr;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JFrameUhr frame = new JFrameUhr();
					frame.setVisible(true);
			        
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
