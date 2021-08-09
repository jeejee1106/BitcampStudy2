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
		this.setDesign(); //���� ������Ʈ ���� �� �̺�Ʈ ���� �ڵ�
		this.setVisible(true);
	}
	
	public void setDesign() {
		//�������� �⺻ ���̾ƿ��� BorderLayout�ε�, FlowLayout���� �����ϱ�
		this.setLayout(new FlowLayout());
		//��ư1���� �� �̺�Ʈ �ֱ�(�͸� ����Ŭ��������)
		btn1=new JButton("������ ����ũ�� ����");
		this.add(btn1);
		btn1.addActionListener(new ActionListener() { //���׼ǿ��� �ڵ� �������̵� �������ֱ�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ex02SwingButton.this.getContentPane().setBackground(Color.magenta);
			}
		});
		
		
		//��ư2
		this.setLayout(new FlowLayout());
		btn2 = new JButton("���� �׸����� ����");
		this.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ex02SwingButton.this.getContentPane().setBackground(Color.GREEN);
			}
		});
		
	}

	public static void main(String[] args) {
		new Ex02SwingButton("��ư����2");
	}

}
