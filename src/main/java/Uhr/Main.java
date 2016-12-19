package Uhr;

import java.awt.EventQueue;

import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				Gui frame = new Gui();
								
				//SetUp set = new SetUp("Analog Watch", 400);
			    //set.start();
			    frame.setVisible(true);
			    MemoryWindow.frm =frame;
			    MemoryWindow.event();
			    
			    
			    Farben.lab = StartStopp.timeF; 
			    MemoryFarben.frm =frame;   
			   
			    MemoryFarben.event();
			    new Farben();
			 
			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}

}
