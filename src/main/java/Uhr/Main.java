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
			    
			    
			    Memory.frm =frame;
			    Dialog.lab = Gui.timeF.setText(t);; 
			    Dialog.event();
			    new Dialog();
			        
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}

}
