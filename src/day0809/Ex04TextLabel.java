package day0809;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Ex04TextLabel extends JFrame{ //1.JFrame 상속 받으면서 임포트넣기
	JTextField text1, text2; //2.JTextField 임포트 넣기
	JLabel label1, label2, label3, label4, label5;// 3.JLable 임포트 넣기
	Icon icon1 = new ImageIcon("C:\\Users\\PC\\Desktop\\study\\image\\01.png"); //4. Icon, ImageIcon 임포트 넣기
	Icon icon2 = new ImageIcon("C:\\Users\\PC\\Desktop\\study\\image\\02.png");
	
	public Ex04TextLabel(String title) {
		super(title);
		this.setBounds(800,100,600,600);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //각종 컴포넌트 부착 및 이벤트 설정 코드
		this.setVisible(true);
	}
	
	public void setDesign() {
		this.setLayout(null); //레이아웃 없애기!
		
		text1 = new JTextField();
		text1.setBounds(10,20,80,30);
		this.add(text1);
		
		text2 = new JTextField("Have a Nice Day");
		text2.setBounds(10,60,150,30);
		this.add(text2);
		
		label1 = new JLabel("안녕하세요", JLabel.CENTER); //내가 원하는 곳에 글자를 나타낼 수 있다.(왼쪽정렬, 오른쪽정렬, 가운데 정렬 등)
		label1.setBounds(10,100,200,30);
		label1.setBackground(Color.orange);
		label1.setOpaque(true); //라벨은 기본 배경색이 false(투명)으로 되어있기 때문에 true(불투명)으로 해놔야 내가 지정한 배경색이 나타난다
		this.add(label1);
		
		label2 = new JLabel("happy Day", icon1, JLabel.RIGHT);
		label2.setBounds(10,150,200,30);
		label2.setBorder(new LineBorder(Color.green)); //Border 인터페이스를 구현한 LineBorder, TitleBorder를 많이 사용한다.
		this.add(label2);
		
		label3 = new JLabel("자바 스윙 공부하기", icon2, JLabel.CENTER);
		label3.setBounds(10,210,300,80);
		label3.setBorder(new TitledBorder("이것이 타이틀 보더"));
		this.add(label3);
		
		label4 = new JLabel("내 맘대로 라벨 꾸미기", icon1, JLabel.CENTER);
		label4.setBounds(10, 300, 400, 100);
		label4.setBorder(new LineBorder(Color.blue));
		label4.setBorder(new TitledBorder("복습중!"));
		label4.setBackground(Color.green);
		label4.setOpaque(true);
		this.add(label4);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		label5 = new JLabel(sdf.format(new Date()), icon2, JLabel.CENTER);
		label5.setBounds(10, 450, 400, 80);
		label5.setBorder(new LineBorder(Color.pink, 10));
		this.add(label5);
		
	}

	public static void main(String[] args) {
		new Ex04TextLabel("Text & Label");

	}

}
