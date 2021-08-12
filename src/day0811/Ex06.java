package day0811;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//Ex05 ������ ���� ����� �ڵ�
public class Ex06 extends JFrame {

	JComboBox<String> box;
	String[] shapes = {"��", "��", "�簢��", "���ڿ�", "�̹���"};
	ComboDraw cbDraw;
	static final String IMAGENAME = "D:\\bitjava0719\\image\\c2.png";
	int idx = 4; //�̹����� �⺻������


	public Ex06() {
		super("�������� �����ϱ�");
		this.setBounds(800, 100, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setDesign();
		this.setVisible(true);
	}

	private void setDesign() {
		this.setLayout(null);

		box = new JComboBox<String>(shapes);
		box.setBounds(40, 20, 100, 30);
		box.setSelectedIndex(idx); //�޺��ڽ��� �ʱⰪ ����
		this.add(box);
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				idx = box.getSelectedIndex(); //���� ������ �޺��ڽ���  idx(����)�� �־��ش�.
				cbDraw.repaint(); //���� Ŭ������ paint �޼��� ȣ��
			}
		});

		cbDraw = new ComboDraw();
		cbDraw.setBounds(10, 70, 580, 600);
		this.add(cbDraw);




	}

	//�÷� �������� ���ϱ�(�޼���� ���� �ʿ��� ���� ȣ��)
	public Color getRandomColor() {
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		return new Color(r,g,b);
	}

	class ComboDraw extends Canvas{
		@Override
		public void paint(Graphics g) {

			super.paint(g);

			Image image = null;
			Color co = null;
			int x = 0, y=0, x1=0, y1=0;

			switch(idx) {
			case 0:{
				for(int i = 1; i<=20; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*600)+1;
					y = (int)(Math.random()*600)+1;
					x1 = (int)(Math.random()*600)+1;
					y1 = (int)(Math.random()*600)+1;
					g.drawLine(x,y,x1,y1);
				}
				break;
			}
			case 1:{
				for(int i = 1; i<=20; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*500)+1;
					y = (int)(Math.random()*500)+1;
					g.fillOval(x, y, 30, 30);
				}
				break;
			}
			case 2:{
				for(int i = 1; i<=20; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*500)+1;
					y = (int)(Math.random()*500)+1;
					g.fillRect(x, y, 30, 30);
				}
				break;
			}
			case 3:{
				g.setFont(new Font("Arial", Font.BOLD, 23));
				for(int i = 1; i<=10; i++) {
					co = getRandomColor();
					g.setColor(co);
					x = (int)(Math.random()*500)+1;
					y = (int)(Math.random()*500)+1;
					g.drawString("Happy Java!!", x, y);
				}
				break;
			}
			case 4:{
				image = new ImageIcon(IMAGENAME).getImage();
				g.drawImage(image, 100, 100, this);
				break;
			}

			}
		}
	}

	public static void main(String[] args) {

		new Ex06();

	}

}
