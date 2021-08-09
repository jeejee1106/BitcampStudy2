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
		this.setDesign(); //���� ������Ʈ ���� �� �̺�Ʈ ���� �ڵ�
		this.setVisible(true);
	}
	
	public void setDesign() {
		
		//Frame�� �⺻ ���̾ƿ��� BorderLayout���� �����������θ� ��ġ�� ������ ����.
		//���̾ƿ��� �ƿ� ���ְ� ���� ��ġ�� �غ���
		 
		this.setLayout(null); //���̾ƿ� ���ֱ�
		//��ư1 ����
		btn1 = new JButton("Hello");
		//ũ�� �� ��ġ ����
		btn1.setBounds(10,20,80,30); //x,y,width,height
		//�����ӿ� �߰�
		this.add(btn1);
		
		//��ư2 ����
		btn2 = new JButton("�����", new ImageIcon(ICON2));
		btn2.setBounds(10,60,100,150);
		this.add(btn2);
		
		//��ư3����
		btn3 = new JButton(new ImageIcon(ICON1));
		btn3.setBounds(130,20,150,150);
		btn3.setPressedIcon(new ImageIcon(ICON3));
		this.add(btn3);
		
		//��ư�� �׼��̺�Ʈ �߰�
		btn1.addActionListener(this); //�̺�Ʈ �޼��带 ������ �ִ� Ŭ������ �ν��Ͻ�
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new EX01SwingButton("��ư����");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); //�̺�Ʈ�� �߻��� ������Ʈ
//		JButton ob = (JButton)e.getSource();// ��ư���� ����ȯ �ص���
		if(ob==btn1) {
			JOptionPane.showMessageDialog(this,  "��ư1�� Hello�� Ŭ���߾��");
		} else if(ob==btn2) {
			JOptionPane.showMessageDialog(this, "��ư2�� ����̸� Ŭ���߾��");
		} else if(ob==btn3) {
			JOptionPane.showMessageDialog(this, "���������� ������");
		}
	}

}
