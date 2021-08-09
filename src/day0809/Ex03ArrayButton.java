package day0809;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex03ArrayButton extends JFrame{
	JButton[] btn = new JButton[6];
	
	Color[] colors = {Color.red, Color.blue, Color.green, Color.orange, new Color(173,157,238), Color.pink};
	
	public Ex03ArrayButton(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //각종 컴포넌트 부착 및 이벤트 설정 코드
		this.setVisible(true);
	}
	
	public void setDesign() {
		//레이아웃 없애기
		this.setLayout(null); //null값이 레이아웃 없애는 것
		//시작위치지정
		int top = 20;
		//버튼에 들어갈 텍스트 라벨
		String[] text = {"빨강", "파랑", "초록", "주황", "연보라", "분홍"};
		for(int i = 0; i<btn.length; i++) {
			btn[i] = new JButton(text[i]); //각각의 버튼 생성
			btn[i].setBounds(20, top, 90, 30); //위치 및 크기
			top += 35;
			//배열의 색상대로 버튼 배경색 변경
//			btn[i].setBackground(colors[i]);
			//배열의 색상대로 버튼 글자색 변경
			btn[i].setForeground(colors[i]);
			this.add(btn[i]); //프레임에 추가
			btn[i].addActionListener(new MyButton()); //버튼 이벤트 발생
		}
		
	}
	//내부클래스
	class MyButton implements ActionListener{ //MyButton에서 자동 오버라이드 만들기

		@Override
		public void actionPerformed(ActionEvent e) {
			Object ob = e.getSource(); //이벤트가 발생한 버튼의 위치값을 반환. 버튼이 여러개일 때 자주 쓰임
			for(int i = 0; i<btn.length;i++) {
				if(ob==btn[i]){
					Ex03ArrayButton.this.getContentPane().setBackground(colors[i]);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new Ex03ArrayButton("배열버튼");

	}

}
