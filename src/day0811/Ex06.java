package day0811;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//Ex05 문제에 대한 강사님 코드
public class Ex06 extends JFrame {

	JComboBox<String> box;
	String[] shapes = {"선", "원", "사각형", "문자열", "이미지"};
	ComboDraw cbDraw;
	static final String IMAGENAME = "D:\\bitjava0719\\image\\c2.png";
	int idx = 4; //이미지를 기본값으로


	public Ex06() {
		super("랜덤으로 추출하기");
		this.setBounds(800, 100, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setDesign();
		this.setVisible(true);
	}

	private void setDesign() {
		this.setLayout(null);

		box = new JComboBox<String>(shapes);
		box.setBounds(40, 20, 100, 30);
		box.setSelectedIndex(idx); //콤보박스의 초기값 지정
		this.add(box);
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				idx = box.getSelectedIndex(); //내가 선택한 콤보박스를  idx(숫자)에 넣어준다.
				cbDraw.repaint(); //내부 클래스의 paint 메서드 호출
			}
		});

		cbDraw = new ComboDraw();
		cbDraw.setBounds(10, 70, 580, 600);
		this.add(cbDraw);




	}

	//컬러 랜덤으로 구하기(메서드로 만들어서 필요한 곳에 호출)
	public Color getRandomColor() {
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		return new Color(r,g,b);
	}

	class ComboDraw extends Canvas{
		@Override
		public void paint(Graphics g) {

			super.paint(g);

			Image image = null;
			Color co = null;
			int x = 0, y=0, x1=0, y1=0;

			switch(idx) {
			case 0:{
				for(int i = 1; i<=20; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*600)+1;
					y = (int)(Math.random()*600)+1;
					x1 = (int)(Math.random()*600)+1;
					y1 = (int)(Math.random()*600)+1;
					g.drawLine(x,y,x1,y1);
				}
				break;
			}
			case 1:{
				for(int i = 1; i<=20; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*500)+1;
					y = (int)(Math.random()*500)+1;
					g.fillOval(x, y, 30, 30);
				}
				break;
			}
			case 2:{
				for(int i = 1; i<=20; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*500)+1;
					y = (int)(Math.random()*500)+1;
					g.fillRect(x, y, 30, 30);
				}
				break;
			}
			case 3:{
				g.setFont(new Font("Arial", Font.BOLD, 23));
				for(int i = 1; i<=10; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*500)+1;
					y = (int)(Math.random()*500)+1;
					g.drawString("Happy Java!!", x, y);
				}
				break;
			}
			case 4:{
				image = new ImageIcon(IMAGENAME).getImage();
				g.drawImage(image, 100, 100, this);
				break;
			}

			}
		}
	}

	public static void main(String[] args) {

		new Ex06();

	}

}
