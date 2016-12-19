package Uhr;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class SetUp extends Memory implements Runnable {

	private String title;
	private int size;
	private Display display;
	private Thread thread;

	private BufferStrategy buffer;
	private Graphics2D g;

	public SetUp(String title, int size) {
		this.title = title;
		this.size = size;
	}
	public void init() {
		display = new Display(title, size);
	}
	public void draw() {
		

		buffer = display.canvas.getBufferStrategy();
		if (buffer == null) {
			display.canvas.createBufferStrategy(3);
			return;
		}
		int center = size / 2;
		g = (Graphics2D) buffer.getDrawGraphics();
		g.clearRect(0, 0, size, size);

		// Zeichnet einen Schwarzen Kreis im Fenster und Zeichnet einen Weissen
		// Kreis im Schwarzen Kreis
		g.setColor(Color.black);
		g.fillOval(10, 10, size - 20, size - 20);
		g.setColor(Color.white);
		g.fillOval(20, 20, size - 40, size - 40);

		// Configuration der Zahlen und minuten Striche
		int angleX, angleY;
		int radius;
		double position;
		double time = System.currentTimeMillis();
		
		// Zeichnet die Zahlen der Stunden im Zeissen Kreis
		for (int i = 1; i <= 12; i++) {
			position = i / 12.0 * Math.PI * 2;
			radius = center - 60;
			angleX = (int) ((center) + (Math.sin(position) * radius));
			angleY = (int) ((center) - (Math.cos(position) * radius));
			g.setColor(Color.blue);
			g.setFont(new Font("arial", Font.BOLD, 25));
			String a = Integer.toString(i);
			g.drawString(a, angleX, angleY);
		}
		// Zeichnet fur jede minute einen Strich in den Weissen Kreis
		// Die 15min Striche werden dann auch greosser gemacht
		for (int i = 1; i <= 60; i++) {
			position = i / 60.0 * Math.PI * 2;
			radius = center - 20;
			angleX = (int) ((center) + (Math.sin(position) * radius));
			angleY = (int) ((center) - (Math.cos(position) * radius));
			if (i == 15 || i == 30 || i == 45 || i == 60) {
				radius = center - 40;
			} else {
				radius = center - 30;
			}
			int angleW = (int) ((center) + (Math.sin(position) * radius));
			int angleZ = (int) ((center) - (Math.cos(position) * radius));
			g.setColor(Color.black);
			g.drawLine(angleW, angleZ, angleX, angleY);
		}

		// Configuration des Stunden Zeigers

		radius = center - 140;// radius bzw leange
		time = System.currentTimeMillis() / (60.0 * 12 * 60 * 1000.0) * Math.PI* 2;
		angleX = (int) ((center) + (Math.sin(time) * radius));
		angleY = (int) ((center) - (Math.cos(time) * radius));
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(8));
		g.drawLine(center, center, angleX, angleY);
		g.setStroke(new BasicStroke(0));

		// Configuration des Minuten Zeigers

		radius = center - 90;// radius bzw leange
		time = System.currentTimeMillis() / (60.0 * 60 * 1000.0) * Math.PI * 2;
		angleX = (int) ((center) + (Math.sin(time) * radius));
		angleY = (int) ((center) - (Math.cos(time) * radius));
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(5));
		g.drawLine(center, center, angleX, angleY);
		g.setStroke(new BasicStroke(0));

		// Configuration des Sekunden Zeigers
		radius = center - 50;// radius bzw leange
		time = System.currentTimeMillis() / (60.0 * 1000.0) * Math.PI * 2;
		angleX = (int) ((center) + (Math.sin(time) * radius));
		angleY = (int) ((center) - (Math.cos(time) * radius));
		g.setColor(Color.red);
		g.drawLine(center, center, angleX, angleY);

		// Centrale Punkt
		g.setColor(Color.blue);
		g.fillOval(center - 7, center - 7, 14, 14);

		// Anzeigen der Uhr
		buffer.show();
		g.dispose();
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		init();
		while (true) {
			draw();
		}
	}
}