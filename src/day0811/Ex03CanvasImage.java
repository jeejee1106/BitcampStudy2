package day0811;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex03CanvasImage extends JFrame {
	Image image;
	JButton btnimg;
	MyCanvas myCan;
	
	public Ex03CanvasImage() {
		super("ĵ����");
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(Color.white);
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void setDesign() {
		this.setLayout(null);
		
		//ó�� ��Ÿ�� �ʱ� �̹��� ����
		image = new ImageIcon("D:\\bitjava0719\\image\\c5.png").getImage();
		myCan = new MyCanvas();
		myCan.setBounds(10, 70, 380, 300);
		this.add(myCan);
		
		btnimg = new JButton("�̹��� �ҷ�����");
		btnimg.setBounds(80,20,150,30);
		this.add(btnimg);
		btnimg.addActionListener(new ActionListener() { //��ư �̺�Ʈ�� �͸���Ŭ������ �������
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex03CanvasImage.this, "�̹��� ����", FileDialog.LOAD); //������, ����, ����(?)
				dlg.setVisible(true);
				if(dlg.getDirectory()==null) {
					return;
				}
				String fileImageName = dlg.getDirectory()+dlg.getFile(); //���ϰ�θ� String������ �־���.
				//�̹��� ����
				image = new ImageIcon(fileImageName).getImage();
				//ĵ���� Ŭ������ paint�޼ҵ� ȣ��
				myCan.repaint();
//				dlg.getDirectory();
//				dlg.getFile();
			}
		});
	}
	
	//canvas�� ��ӹ޴� ���� Ŭ����
	class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			//�̹��� ���
			g.drawImage(image, 30,30,this);
		}
	}
	
	public static void main(String[] args) {
		new Ex03CanvasImage();
	}

}
