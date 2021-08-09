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
		this.setDesign(); //���� ������Ʈ ���� �� �̺�Ʈ ���� �ڵ�
		this.setVisible(true);
	}
	
	public void setDesign() {
		//���̾ƿ� ���ֱ�
		this.setLayout(null); //null���� ���̾ƿ� ���ִ� ��
		//������ġ����
		int top = 20;
		//��ư�� �� �ؽ�Ʈ ��
		String[] text = {"����", "�Ķ�", "�ʷ�", "��Ȳ", "������", "��ȫ"};
		for(int i = 0; i<btn.length; i++) {
			btn[i] = new JButton(text[i]); //������ ��ư ����
			btn[i].setBounds(20, top, 90, 30); //��ġ �� ũ��
			top += 35;
			//�迭�� ������ ��ư ���� ����
//			btn[i].setBackground(colors[i]);
			//�迭�� ������ ��ư ���ڻ� ����
			btn[i].setForeground(colors[i]);
			this.add(btn[i]); //�����ӿ� �߰�
			btn[i].addActionListener(new MyButton()); //��ư �̺�Ʈ �߻�
		}
		
	}
	//����Ŭ����
	class MyButton implements ActionListener{ //MyButton���� �ڵ� �������̵� �����

		@Override
		public void actionPerformed(ActionEvent e) {
			Object ob = e.getSource(); //�̺�Ʈ�� �߻��� ��ư�� ��ġ���� ��ȯ. ��ư�� �������� �� ���� ����
			for(int i = 0; i<btn.length;i++) {
				if(ob==btn[i]){
					Ex03ArrayButton.this.getContentPane().setBackground(colors[i]);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new Ex03ArrayButton("�迭��ư");

	}

}
