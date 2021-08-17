package day0813;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex03multi extends JFrame {
	JButton btnpro, btnstop;
	Mydraw mydraw;
	
	
	public Ex03multi() {
		super("쓰레드연습");
		this.setBounds(800, 100, 500, 500);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	private void setDesign() {
		this.setLayout(null);
		
		btnpro = new JButton("RUN");
		btnpro.setBounds(30, 20, 100, 50);
		this.add(btnpro);
		
		
		btnstop = new JButton("STOP");
		btnstop.setBounds(150, 20, 100, 50);
		this.add(btnstop);
		
		mydraw = new Mydraw();
		mydraw.setBounds(850, 250, 450, 450);
		this.add(mydraw);
	}
	
	public Color getRandomColor() {
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		return new Color(r,g,b);
	}
	
	class Mydraw extends Canvas implements Runnable {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			int red, green, blue, x, y;
			while(true) {
				red = (int)(Math.random()*256);
				green = (int)(Math.random()*256);
				blue = (int)(Math.random()*256);
				x = (int)(Math.random()*500)+1;
				y = (int)(Math.random()*500)+1;
				g.fillOval(x, y, 30, 30);
				
				this.repaint();
			}
		}

		@Override
		public void run() {
			
			
		}
	}

	public static void main(String[] args) {
		new Ex03multi();
	}

}
