package day0809;
//자주 쓰일 것들 미리 작성해놓고 복붙하기 위해 만듦.
import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon2 extends JFrame{
	
	public SwingGibon2(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //각종 컴포넌트 부착 및 이벤트 설정 코드
		this.setVisible(true);
	}
	
	public void setDesign() {
		
	}
	public static void main(String[] args) {
		new SwingGibon("기본2");
	}

}
