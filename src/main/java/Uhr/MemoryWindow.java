package Uhr;

import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

import javax.swing.JFrame;

import java.io.*;

public class MemoryWindow {
	
// Pb ici: je veux qu'à la place de JFrame frm quelqonque ce soit le frame de Gui frame (cf main)
	protected static JFrame frm;
	
   // public static final String fileName = "Eigenschaften.txt";

	//Speichern von der Position und Groesse
    public static void storeOptions(Frame f) throws Exception {
        File file = new File("Eigenschaften.txt");
        Properties p = new Properties();
        
        // Speichert die letzte Position vom Fenster in den variablen x,y
        // Speichert die hohe und die breite vom Fenster in den variablen b,h
        f.setExtendedState(Frame.NORMAL);
        Rectangle r = f.getBounds();
        int x = (int)r.getX();
        int y = (int)r.getY();
        int b = (int)r.getWidth();
        int h = (int)r.getHeight();
        
        // Speichert die Eigenschaften in den "Properties"
        p.setProperty("x", "" + x);
        p.setProperty("y", "" + y);
        p.setProperty("b", "" + b);
        p.setProperty("h", "" + h);
        
        // Schreibt die Eigenschaften im file rein
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
        p.store(br, "Eigenschaften vom Frame");
    }

       //Wiedergabe von den gespeicherten Eigenschaften
    public static void restoreOptions(Frame f) throws IOException {
        File file = new File("Eigenschaften.txt");
        Properties p = new Properties();
        //Liest die Eingenschaften ein und ladet si in den "Properties" p
        BufferedReader br = new BufferedReader(new FileReader(file));
        p.load(br);
        
        // Schreibt die eingelesenen Eigenschaften in den variablen x,y,b und h
        int x = Integer.parseInt(p.getProperty("x"));
        int y = Integer.parseInt(p.getProperty("y"));
        int b = Integer.parseInt(p.getProperty("b"));
        int h = Integer.parseInt(p.getProperty("h"));
        
        //
        Rectangle r = new Rectangle(x,y,b,h);

        f.setBounds(r);
    }
   public static void event(){
	  
	   frm.addWindowListener( new WindowAdapter() {
          
        	public void windowClosing(WindowEvent we) {
                try {
                    storeOptions(frm);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            } 
        });
       
        File optionsFile = new File("Eigenschaften.txt");
        if (optionsFile.exists()) {
            try {
                restoreOptions( frm);
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
        	frm.setLocationByPlatform(true);
        }
   }
   
	
}