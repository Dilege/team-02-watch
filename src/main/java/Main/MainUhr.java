package Main;
import AnalogUhr.SetUp;





import DigitalUhr.DisplayDigitalUhr;
import MehrereDigitaleUhren.DisplayMehrereDigitalUhr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MainUhr {
static JFrame frame;
static JMenuBar menu;
static JMenu analogUhr;
static JMenuItem analoguhr;
static JMenu digitalUhr;
static JMenuItem digitaluhr;
static JMenuItem mehrereDigitaleuhren;
static JMenu mehrereDigitaleUhren;
static JMenuItem digitalUhrZeit;


public static void menu(){
	menu= new JMenuBar();
	analogUhr=new JMenu("Analog Uhr");
	analoguhr=new JMenuItem("Analog Uhr");
	digitalUhr=new JMenu("Digital Uhr");
	digitaluhr=new JMenuItem("Digital Uhr");
	mehrereDigitaleUhren=new JMenu("Mehrere Digitale Uhren");
	mehrereDigitaleuhren=new JMenuItem("Mehrere Digitale Uhren");
	
	
	frame.setJMenuBar(menu);
	menu.add(analogUhr);
	menu.add(digitalUhr);
	menu.add(mehrereDigitaleUhren);
	analogUhr.add(analoguhr);
	mehrereDigitaleUhren.add(mehrereDigitaleuhren);
	digitalUhr.add(digitaluhr);
}
public static void bild(){
	frame.getContentPane().setLayout(null);
	JPanel jp=new JPanel();
	JLabel jl=new JLabel();
	jl.setBounds(10, -10, 180,180 );
	jl.setIcon(new ImageIcon("Trinat.png"));
	jp.add(jl);
	
	frame.add(jl);
}
public static void fenster(){			
		frame=new JFrame("InterFace Watch  IFW");
		frame.setBounds(100, 100, 600, 400);
		frame.getContentPane().setBackground(new Color(50,130,190));
		JLabel text=new JLabel("Hallo Willkommen zu unserer ");
		JLabel text2=new JLabel("Uhr Interface !!");
		JLabel text3=new JLabel("Sie keonnen die Uhren in der Menubar ausweahlen. ");	
		text.setBounds(180, 50, 450, 30);
		text2.setBounds(270, 90, 450, 30);
		text3.setBounds(100, 250, 450, 30);
		text.setFont(new Font("Candara",1,30));
		text2.setFont(new Font("Candara",1,30));
		text3.setFont(new Font("Candara",1,20));
		frame.add(text);
		frame.add(text2);
		frame.add(text3);
}
public static void ListenerDigitalUhr(){
	
digitaluhr.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		DisplayDigitalUhr frame = new DisplayDigitalUhr();
	}
});

}
public static void ListenerAnalogUhr(){
	
analoguhr.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		SetUp set = new SetUp("Analog Watch", 400);
	       set.start();
	}
});

}
public static void ListenerMehrereDigitaleUhren(){
	
	mehrereDigitaleuhren.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		DisplayMehrereDigitalUhr frame = new DisplayMehrereDigitalUhr();
	}
});

}

	public static void main(String[] args) {

		fenster();
		menu();
		bild();
		ListenerDigitalUhr();
		ListenerAnalogUhr();
		ListenerMehrereDigitaleUhren();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
