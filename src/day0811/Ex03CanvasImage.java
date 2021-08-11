package day0811;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex03CanvasImage extends JFrame {
	Image image;
	JButton btnimg;
	MyCanvas myCan;
	
	public Ex03CanvasImage() {
		super("캔버스");
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(Color.white);
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void setDesign() {
		this.setLayout(null);
		
		//처음 나타낼 초기 이미지 지정
		image = new ImageIcon("D:\\bitjava0719\\image\\c5.png").getImage();
		myCan = new MyCanvas();
		myCan.setBounds(10, 70, 380, 300);
		this.add(myCan);
		
		btnimg = new JButton("이미지 불러오기");
		btnimg.setBounds(80,20,150,30);
		this.add(btnimg);
		btnimg.addActionListener(new ActionListener() { //버튼 이벤트를 익명내부클래스로 만들었당
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex03CanvasImage.this, "이미지 열기", FileDialog.LOAD); //프레임, 제목, 상태(?)
				dlg.setVisible(true);
				if(dlg.getDirectory()==null) {
					return;
				}
				String fileImageName = dlg.getDirectory()+dlg.getFile(); //파일경로를 String변수에 넣었다.
				//이미지 생성
				image = new ImageIcon(fileImageName).getImage();
				//캔버스 클래스의 paint메소드 호출
				myCan.repaint();
//				dlg.getDirectory();
//				dlg.getFile();
			}
		});
	}
	
	//canvas를 상속받는 내부 클래스
	class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			//이미지 출력
			g.drawImage(image, 30,30,this);
		}
	}
	
	public static void main(String[] args) {
		new Ex03CanvasImage();
	}

}
