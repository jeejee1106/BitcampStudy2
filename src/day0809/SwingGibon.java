package day0809;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGibon extends JFrame{
	
	public SwingGibon(String title) {
		super(title);
		
		//������ġ(���� �� �𼭸��� ��ǥx,y), �ʺ�, ����
		this.setBounds(500,100,300,300);
		
		//���� ���#1
		//���α׷��� ��ü �������ִ� �޼��带 ������(�ٸ� ���� �޼��嵵 ����)
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������#2
		//����� ó���� �ڵ尡 ���� ��쿡�� �̺�Ʈ �ڵ鷯�� ������ش�.
		//�̺�Ʈ �ڵ鷯? �̺�Ʈ �߻� �� ȣ��Ǵ� �޼���
		//�͸� ����Ŭ���� �������� �̺�Ʈ �ڵ鷯�� ������
//		this.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				//�ܺ�Ŭ������ this�� ù��° ���ڷ� ������.(JFrame ��ӹ޴� Ŭ����)
//				JOptionPane.showMessageDialog(SwingGibon.this, "�������� �����մϴ�.");
//			}
//		});
		
		//������#3
		//����� ȣ��Ǵ� �̺�Ʈ�� ����Ŭ������ ������
		this.addWindowListener(new FrameExit());
		
		//���� �ٲٱ�
		//������ ������ ���� �����̳ʸ� ���� �� �����ؾ� �Ѵ�.
		this.getContentPane().setBackground(Color.green); //static����� �̿��� �� ����
		//���ϴ� ������ �����ؼ� �����ϱ�
		this.getContentPane().setBackground(new Color(191,240,207));
		
		//������ ���̰� �ϱ�
		this.setVisible(true);
	}
	
	class FrameExit extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	

	public static void main(String[] args) {
		
		new SwingGibon("�⺻");
		
	}

}
