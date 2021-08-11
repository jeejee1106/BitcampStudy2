package day0811;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Ex05Test extends JFrame {

	JComboBox<String> box;
	String[] shapes = {"선택하세요","선", "원", "사각형", "문자열", "이미지"};
	ComboDraw cbDraw;
	int idx = -1;


	public Ex05Test() {
		super("랜덤으로 추출하기");
		this.setBounds(800, 100, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setDesign();
		this.setVisible(true);
	}


	private void setDesign() {

		this.setLayout(null);

		cbDraw = new ComboDraw();
		cbDraw.setBounds(30, 70, 600, 600);
		this.add(cbDraw);

		box = new JComboBox<String>(shapes);
		box.setBounds(30, 30, 100, 30);
		this.add(box);

		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				idx = box.getSelectedIndex();
				cbDraw.repaint(); //이걸 호출을 안해줘서 캔버스가 작았던 거임????????
			}
		});

	}
	
	

	class ComboDraw extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			switch(idx) {
			case 1:{
				for(int i = 1; i<=20; i++) {
					int x = (int)(Math.random()*600)+1;
					int y = (int)(Math.random()*600)+1;
					int x1 = (int)(Math.random()*600)+1;
					int y1 = (int)(Math.random()*600)+1;
					g.drawLine(x,y,x1,y1);
				}
				break;
			}
			case 2:{
				for(int i = 1; i<=20; i++) {
					int x = (int)(Math.random()*500)+1;
					int y = (int)(Math.random()*500)+1;
					g.fillOval(x, y, 30, 30);
				}
				break;
			}
			case 3:{
				for(int i = 1; i<=20; i++) {
					int x = (int)(Math.random()*500)+1;
					int y = (int)(Math.random()*500)+1;
					g.fillRect(x, y, 30, 30);
				}
			}

			}


		}
	}


	public static void main(String[] args) {
		new Ex05Test();

	}

}
