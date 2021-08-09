package day0809;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex02SwingButton extends JFrame{
	JButton btn1, btn2;
	
	public Ex02SwingButton(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //각종 컴포넌트 부착 및 이벤트 설정 코드
		this.setVisible(true);
	}
	
	public void setDesign() {
		//프레임의 기본 레이아웃은 BorderLayout인데, FlowLayout으로 변경하기
		this.setLayout(new FlowLayout());
		//버튼1생성 및 이벤트 주기(익명 내부클래스형식)
		btn1=new JButton("배경색을 핫핑크로 변경");
		this.add(btn1);
		btn1.addActionListener(new ActionListener() { //뉴액션에서 자동 오버라이드 생성해주기
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ex02SwingButton.this.getContentPane().setBackground(Color.magenta);
			}
		});
		
		
		//버튼2
		this.setLayout(new FlowLayout());
		btn2 = new JButton("배경색 그린으로 변경");
		this.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ex02SwingButton.this.getContentPane().setBackground(Color.GREEN);
			}
		});
		
	}

	public static void main(String[] args) {
		new Ex02SwingButton("버튼연습2");
	}

}
