package day0809;
//���� ���� �͵� �̸� �ۼ��س��� �����ϱ� ���� ����.
import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon2 extends JFrame{
	
	public SwingGibon2(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //���� ������Ʈ ���� �� �̺�Ʈ ���� �ڵ�
		this.setVisible(true);
	}
	
	public void setDesign() {
		
	}
	public static void main(String[] args) {
		new SwingGibon("�⺻2");
	}

}
