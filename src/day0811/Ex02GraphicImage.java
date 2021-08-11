package day0811;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex02GraphicImage extends JFrame {
	static final String imageName1 = "D:\\bitjava0719\\image\\c5.png";
	static final String imageName2 = "D:\\bitjava0719\\image\\c6.png";
	static final String imageName3 = "D:\\bitjava0719\\image\\snoopyAvata\\s1.JPG";
	
	public Ex02GraphicImage() {
		super("그래픽");
		this.setBounds(700, 100, 500, 500);
		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.green);
		g.drawLine(20,60,300,60); //선 그리기
		
		g.setColor(Color.pink);
		g.drawOval(20, 80, 50, 50); //테두리만 있는 원그리기
		g.fillOval(100, 80, 50, 50); //채우기색 있는 원 그리기
		
		g.setColor(Color.cyan);
		g.drawRect(180, 80, 50, 50); //테두리만 있는 네모 그리기
		g.fillRect(250, 80, 50, 50); //채우기색 있는 네모 그리기
		
		//이미지
		Image image1 = new ImageIcon(imageName1).getImage();
		g.drawImage(image1, 20, 150, this);
		
		Image image2 = new ImageIcon(imageName2).getImage();
		g.drawImage(image2, 250, 150, 100, 100, this);
		
		Image image3 = new ImageIcon(imageName3).getImage();
		g.drawImage(image3, 270, 270, 150, 150, this);
		
		//테스트용 버튼 만들기. 이미지와 같이 넣으면 지금과 같은 문제가 발생한다.(그래서 canvas를 따로 만들어 주는 것)
//		JButton btn = new JButton("Click!!");
//		btn.setBounds(200, 200, 80, 80);
//		this.add(btn);
	}
	
	private void setDesign() {
		
	}


	public static void main(String[] args) {
		new Ex02GraphicImage();
	}

}
