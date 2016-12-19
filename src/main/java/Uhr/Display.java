package Uhr;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Display extends SetUpMemory {
	Color ausgewaehlteFarbe;
    private String title;
    private int size;
    private static JFrame frame;
    
	JMenuItem menuHintergrund=new JMenuItem("Hintergrundfarbe");
	JMenuItem menuSchrift=new JMenuItem("Schriftfarbe");
	static JMenuItem rund=new JMenuItem("Rund");
	JMenuItem rechteckig=new JMenuItem("Rechteckig");
    public static Canvas canvas;
    
    public Display(String title, int size){
    	
       this.title = title ;
       this.size = size;
       fenster();
       
    }
   
    public void fenster(){
      frm=frame;
       frame = new JFrame(title);
       frame.setSize(size, size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
       restore();
        eischtellunegenMenu();
         canvas = new Canvas();
         //canvas.setPreferredSize(new Dimension(size, size));
         canvas.setBounds(0, 0, size, size);
         canvas.setBackground(hcolor);
         SetUp.farbe=scolor;
         ListenderHinterground();
         ListenderSchrift();
         
         frame.add(canvas);
         frame.pack();
         frame.setVisible(true);
    }
    public void eischtellunegenMenu(){
    	JMenuBar menu=new JMenuBar();
	    JMenu einstellungen=new JMenu("Einstellungen");
	    JMenu auswahl=new JMenu("Auswahl");
	    
    	menu=new JMenuBar();
    	frame.setJMenuBar(menu);
    	menu.add(einstellungen);
    	menu.add(auswahl);
    	einstellungen.add(menuHintergrund);
    	einstellungen.add(menuSchrift);
    	auswahl.add(rund);
    	auswahl.add(rechteckig);
    }
   public void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		hintergrundFarbe= ausgewaehlteFarbe;
		canvas.setBackground(hintergrundFarbe);
	}

	public void chooseColorSchrift() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		 schriftFarbe = ausgewaehlteFarbe;
		SetUp.farbe=schriftFarbe;
		

	}
    public void ListenderHinterground(){
    	frm=frame;
		menuHintergrund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorHinterground();
				store();
			}
			
		});
		hintergrundFarbe = hcolor;
		
	}
    public void ListenderSchrift(){
    	frm=frame;
		menuSchrift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorSchrift();
				store();

			}
		});
		schriftFarbe=scolor;
	}

}