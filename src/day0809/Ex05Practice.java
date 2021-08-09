package day0809;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ex05Practice extends JFrame{
	Scanner sc = new Scanner(System.in);
	JTextField text1, text2;
	JButton btn1;
	JLabel label1, label2, label3;
	Font font1 = new Font(null, 0, 20);
	
	public Ex05Practice(String title) {
		super(title);
		this.setBounds(800,100,600,600);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //각종 컴포넌트 부착 및 이벤트 설정 코드
		this.setVisible(true);
	}
	
	public void setDesign() {
		this.setLayout(null);
		
		text1 = new JTextField();
		text1.setBounds(70, 20, 60, 60);
		text1.setFont(font1);
		this.add(text1);
		
		
		text2 = new JTextField();
		text2.setBounds(270,20,60,60);
		text2.setFont(font1);
		this.add(text2);
		
		btn1 = new JButton("계산하기");
		btn1.setBounds(10,100,100,50);
		this.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(text1.getText());
				int num2 = Integer.parseInt(text2.getText());
				int result = num1+num2;
				
				try {
				label3.setText(num1 + "+" + num2 + "=" + result);
				} catch(NumberFormatException e2) {
					System.out.println("문자가 섞여있어여.");
				}
			}
		});
		
		label1 = new JLabel("숫자1");
		label1.setBounds(10,20,60,60);
		label1.setFont(font1);
		this.add(label1);
		
		label2 = new JLabel("숫자2");
		label2.setBounds(200,20,60,60);
		label2.setFont(font1);
		this.add(label2);
		
		
		label3 = new JLabel();
		label3.setBounds(10, 250, 130, 50);
		label3.setBorder(new TitledBorder("결과확인"));
		label3.setOpaque(true);
		label3.setFont(font1);
		this.add(label3);
	}

	public static void main(String[] args) {
		new Ex05Practice("계산기");
	}

}
