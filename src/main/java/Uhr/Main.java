package Uhr;

import java.awt.EventQueue;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

public class Main {

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Gui frame = new Gui();
					frame.setVisible(true);
			        
					JavaDialogSchriftfarbe javaDialogSchriftfarbe = new JavaDialogSchriftfarbe();	
					javaDialogSchriftfarbe.setVisible(true);
					//MemoryWindow.event();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaDialogSchriftfarbe frame = new JavaDialogSchriftfarbe();	
					frame.setVisible(true);
					//MemoryWindow.event();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
