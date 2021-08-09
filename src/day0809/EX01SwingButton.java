package day0809;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class EX01SwingButton extends JFrame implements ActionListener{
	
	JButton btn1, btn2, btn3, btn4;
	static final String ICON1 = "C:\\Users\\PC\\Desktop\\study\\image\\f1.png";
	static final String ICON2 = "C:\\Users\\PC\\Desktop\\study\\image\\f2.png";
	static final String ICON3 = "C:\\Users\\PC\\Desktop\\study\\image\\f3.png";
	
	public EX01SwingButton(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //각종 컴포넌트 부착 및 이벤트 설정 코드
		this.setVisible(true);
	}
	
	public void setDesign() {
		
		//Frame의 기본 레이아웃은 BorderLayout으로 동서남북으로만 배치가 가능한 구조.
		//레이아웃을 아예 없애고 직접 배치를 해보자
		 
		this.setLayout(null); //레이아웃 없애기
		//버튼1 생성
		btn1 = new JButton("Hello");
		//크기 및 위치 지정
		btn1.setBounds(10,20,80,30); //x,y,width,height
		//프레임에 추가
		this.add(btn1);
		
		//버튼2 생성
		btn2 = new JButton("겸둥이", new ImageIcon(ICON2));
		btn2.setBounds(10,60,100,150);
		this.add(btn2);
		
		//버튼3생성
		btn3 = new JButton(new ImageIcon(ICON1));
		btn3.setBounds(130,20,150,150);
		btn3.setPressedIcon(new ImageIcon(ICON3));
		this.add(btn3);
		
		//버튼에 액션이벤트 추가
		btn1.addActionListener(this); //이벤트 메서드를 가지고 있는 클래스의 인스턴스
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new EX01SwingButton("버튼생성");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); //이벤트가 발생한 오브젝트
//		JButton ob = (JButton)e.getSource();// 버튼으로 형변환 해도됌
		if(ob==btn1) {
			JOptionPane.showMessageDialog(this,  "버튼1번 Hello를 클릭했어요");
		} else if(ob==btn2) {
			JOptionPane.showMessageDialog(this, "버튼2번 겸둥이를 클릭했어요");
		} else if(ob==btn3) {
			JOptionPane.showMessageDialog(this, "오른쪽으로 가세요");
		}
	}

}
