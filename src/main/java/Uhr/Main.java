package Uhr;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				Gui frame = new Gui();
								
				//SetUp set = new SetUp("Analog Watch", 400);
			    //set.start();
			    frame.setVisible(true);
			    //frame.pack(); 
			   
			    MemoryWindow.frm =frame;
			    MemoryWindow.event();
			    
			    Dialog myWindow = new Dialog(frame);
			    myWindow.create();
			    			    
			    MemoryFarben myMemory = new MemoryFarben(frame);
			    myMemory.event();
			    
			   // new Farben();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}

}
