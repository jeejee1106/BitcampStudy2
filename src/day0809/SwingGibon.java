package day0809;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGibon extends JFrame{
	
	public SwingGibon(String title) {
		super(title);
		
		//시작위치(왼쪽 위 모서리의 좌표x,y), 너비, 높이
		this.setBounds(500,100,300,300);
		
		//종료 방법#1
		//프로그램을 전체 종료해주는 메서드를 만들어보자(다른 종료 메서드도 있음)
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//종료방법#2
		//종료시 처리할 코드가 있을 경우에는 이벤트 핸들러를 만들어준다.
		//이벤트 핸들러? 이벤트 발생 시 호출되는 메서드
		//익명 내부클래스 형식으로 이벤트 핸들러를 만들어보자
//		this.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				//외부클래스의 this를 첫번째 인자로 보낸다.(JFrame 상속받는 클래스)
//				JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다.");
//			}
//		});
		
		//종료방법#3
		//종료시 호출되는 이벤트를 내부클래스로 만들어보자
		this.addWindowListener(new FrameExit());
		
		//배경색 바꾸기
		//배경색은 프레임 위의 컨테이너를 얻은 후 변경해야 한다.
		this.getContentPane().setBackground(Color.green); //static상수를 이용한 색 변경
		//원하는 색으로 제조해서 변경하기
		this.getContentPane().setBackground(new Color(191,240,207));
		
		//프레임 보이게 하기
		this.setVisible(true);
	}
	
	class FrameExit extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	

	public static void main(String[] args) {
		
		new SwingGibon("기본");
		
	}

}
