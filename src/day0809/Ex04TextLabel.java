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

public class Ex04TextLabel extends JFrame{ //1.JFrame ��� �����鼭 ����Ʈ�ֱ�
	JTextField text1, text2; //2.JTextField ����Ʈ �ֱ�
	JLabel label1, label2, label3, label4, label5;// 3.JLable ����Ʈ �ֱ�
	Icon icon1 = new ImageIcon("C:\\Users\\PC\\Desktop\\study\\image\\01.png"); //4. Icon, ImageIcon ����Ʈ �ֱ�
	Icon icon2 = new ImageIcon("C:\\Users\\PC\\Desktop\\study\\image\\02.png");
	
	public Ex04TextLabel(String title) {
		super(title);
		this.setBounds(800,100,600,600);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //���� ������Ʈ ���� �� �̺�Ʈ ���� �ڵ�
		this.setVisible(true);
	}
	
	public void setDesign() {
		this.setLayout(null); //���̾ƿ� ���ֱ�!
		
		text1 = new JTextField();
		text1.setBounds(10,20,80,30);
		this.add(text1);
		
		text2 = new JTextField("Have a Nice Day");
		text2.setBounds(10,60,150,30);
		this.add(text2);
		
		label1 = new JLabel("�ȳ��ϼ���", JLabel.CENTER); //���� ���ϴ� ���� ���ڸ� ��Ÿ�� �� �ִ�.(��������, ����������, ��� ���� ��)
		label1.setBounds(10,100,200,30);
		label1.setBackground(Color.orange);
		label1.setOpaque(true); //���� �⺻ ������ false(����)���� �Ǿ��ֱ� ������ true(������)���� �س��� ���� ������ ������ ��Ÿ����
		this.add(label1);
		
		label2 = new JLabel("happy Day", icon1, JLabel.RIGHT);
		label2.setBounds(10,150,200,30);
		label2.setBorder(new LineBorder(Color.green)); //Border �������̽��� ������ LineBorder, TitleBorder�� ���� ����Ѵ�.
		this.add(label2);
		
		label3 = new JLabel("�ڹ� ���� �����ϱ�", icon2, JLabel.CENTER);
		label3.setBounds(10,210,300,80);
		label3.setBorder(new TitledBorder("�̰��� Ÿ��Ʋ ����"));
		this.add(label3);
		
		label4 = new JLabel("�� ����� �� �ٹ̱�", icon1, JLabel.CENTER);
		label4.setBounds(10, 300, 400, 100);
		label4.setBorder(new LineBorder(Color.blue));
		label4.setBorder(new TitledBorder("������!"));
		label4.setBackground(Color.green);
		label4.setOpaque(true);
		this.add(label4);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm��");
		label5 = new JLabel(sdf.format(new Date()), icon2, JLabel.CENTER);
		label5.setBounds(10, 450, 400, 80);
		label5.setBorder(new LineBorder(Color.pink, 10));
		this.add(label5);
		
	}

	public static void main(String[] args) {
		new Ex04TextLabel("Text & Label");

	}

}
