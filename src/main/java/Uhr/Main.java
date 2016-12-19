package Uhr;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				Gui frame = new Gui();
			    frame.setVisible(true);
			    frame.pack();
			    MemoryWindow.frm =frame;
			    MemoryWindow.event();
			    
			    Dialog myWindow = new Dialog(frame);
			    myWindow.create();
			    			    
			    MemoryFarben myMemory = new MemoryFarben(frame);
			    myMemory.event();
			    
			    new Farben();
			 
			   
			
			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}

}
