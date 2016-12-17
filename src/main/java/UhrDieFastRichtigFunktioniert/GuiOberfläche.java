package UhrDieFastRichtigFunktioniert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class GuiOberfläche extends Uhrzeit {
	
	private  JFrame frame;
	
	public GuiOberfläche()  {
		createFrame();
	}

private void createFrame()   { //Fenster erzeugen
		
		frame =new JFrame("Uhr");
		createMenuBar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String x=null;
		
		//Inhalte des Fenster
		
		Container contentPane = frame.getContentPane();
		/*JLabel label= new JLabel ("Ich ein Label");
		contentPane.add(label);*/
		JButton button1 = new JButton("Start");
		contentPane.add(button1);
		JButton button2 = new JButton("Stop");
		button2.addActionListener(actionEvent-> button2.setText("Schließen"));		
		contentPane.add(button2);
		
		
       /* JLabel text = new JLabel(x);
        
		text.setBounds(74, 85, 285, 68);
		contentPane.add(text);
		*/
		frame.getContentPane().add(BorderLayout.SOUTH, button2);
		frame.getContentPane().add(BorderLayout.NORTH, button1);
		
		boolean on;
		on = true;
		while(on){
	    
	    JLabel text = new JLabel( "Zeit: " + Uhrzeit.getZeit());
        text.setBounds(0, 0, 200, 100);
        Font schrift=new Font("Arial", Font.BOLD+Font.ITALIC, 30);
        text.setFont(schrift);
		frame.getContentPane().add(BorderLayout.CENTER, text);
	
		frame.pack();
		
		frame.setVisible(true); 
		
		SwingUtilities.updateComponentTreeUI(text);
		
        //text.invalidate();
        //text.validate();
		//text.repaint();
		
		}
	   	}
	
	private  void createMenuBar() {
		//Hauptmenu
		JMenuBar bar= new JMenuBar();
		frame.setJMenuBar(bar);
		//Inhalt
		JMenu dateiMenu  = new JMenu("Datei");
		bar.add(dateiMenu);
		JMenu einstellungenMenu  = new JMenu("Einstellungen");
		bar.add(einstellungenMenu);
		JMenu hilfeMenu  = new JMenu("Hilfe");
		bar.add(hilfeMenu);
		
		//Untermenu
		JMenuItem oeffnenItem= new JMenuItem("Öffnen");
		oeffnenItem.addActionListener(actionEvent-> {
			System.out.println("Öffnen  geklickt");
		});		
		dateiMenu.add(oeffnenItem);
		
		JMenuItem beendenItem= new JMenuItem("Beenden");
		 beendenItem.addActionListener(new ActionListener() {//anonyme innere Klasse
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });		
		 dateiMenu.add(beendenItem);
		 JMenuItem uberItem=new JMenuItem("Über");
		 hilfeMenu.add(uberItem);
		 
		 JMenuItem Hfarbe=new JMenuItem("Hintergrundsfarbe");
		 einstellungenMenu.add(Hfarbe);
		 
		 JMenuItem Sfarbe=new JMenuItem("Schriftfarbe");
		 einstellungenMenu.add(Sfarbe);
		
		 JMenuItem größe=new JMenuItem("Schriftgröße");
		 einstellungenMenu.add(größe);

		
	}
	
	
	

}