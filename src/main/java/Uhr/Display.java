package Uhr;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Display extends Memory {
	Color ausgewaehlteFarbe;
    private String title;
    private int size;
    private JFrame frame;
    JMenuBar menu=new JMenuBar();
	JMenu einstellungen=new JMenu("Einstellungen");
	JMenuItem menuHintergrund=new JMenuItem("Hintergrundfarbe");
	JMenuItem menuSchrift=new JMenuItem("Schriftfarbe");
    public static Canvas canvas;
    
    public Display(String title, int size){
    	frm=frame;
       this.title = title ;
       this.size = size;
       fenster();
       
    }
   
    public void fenster(){
      
       frame = new JFrame(title);
       frame.setSize(size, size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
        frame.setVisible(true);
        eischtellunegenMenu();
         canvas = new Canvas();
         canvas.setPreferredSize(new Dimension(size, size));
         canvas.setBackground(hcolor);
         System.out.println(hcolor);
         frame.add(canvas);
         frame.pack();
    }
    public void eischtellunegenMenu(){
    	menu=new JMenuBar();
    	frame.setJMenuBar(menu);
    	einstellungen=new JMenu("Einstellungen");
    	menu.add(einstellungen);
    	menuHintergrund=new JMenuItem("hintergrundfarbe");
    	einstellungen.add(menuHintergrund);
    	einstellungen.add(menuSchrift);
    	ListenderHinterground();
    }
   public void chooseColorHinterground() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		hintergrundFarbe = c;
		canvas.setBackground(c);
	}

	/*public void chooseColorSchrift() {
		ausgewaehlteFarbe = JColorChooser.showDialog(null, "Farbauswahl", null);
		Color c = ausgewaehlteFarbe;
		schriftFarbe = c;
		lab.setForeground(c);

	}*/
    public void ListenderHinterground(){
		menuHintergrund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseColorHinterground();
				event();

			}
		});
		
		hintergrundFarbe=hcolor;
		
	}
    

}