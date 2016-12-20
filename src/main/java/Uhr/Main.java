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
			    
			    Dialog myWindow = new Dialog(frame);
			    myWindow.create();
			    			    
			    MemoryFarben myMemory = new MemoryFarben(frame);
			    myMemory.event();
			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}

}
