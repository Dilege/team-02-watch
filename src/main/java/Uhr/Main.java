package Uhr;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				Gui frame = new Gui();
			    frame.setVisible(true);
			    MemoryWindow.frm =frame;
			    MemoryWindow.event();
			    
			    
			    MemoryFarben.frm =frame;
			    Farben.lab = Gui.timeF; 
			    Farben.event();
			    new Farben();
			        
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}

}
