package day0812;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex03PhotoInfo extends JFrame {
	JButton btnPhoto;
	Image imagePhoto;
	PhotoCanvas canvas;
	String photoFile = "D:\\bitjava0719\\image\\pp\\2.JPG";
	
	JButton btnSave, btnOpen;
	JTextField tfName, tfHp;
	
	public Ex03PhotoInfo(String title) {
		super(title);
		this.setBounds(700, 100, 300, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setDesign();
		this.setVisible(true);
	}

	private void setDesign() {
		this.setLayout(null);
		
		btnPhoto = new JButton("���� �ҷ�����");
		btnPhoto.setBounds(20, 20, 100, 30);
		this.add(btnPhoto);
		
		imagePhoto = new ImageIcon(photoFile).getImage(); //�ʱ� �̹���
		
		canvas = new PhotoCanvas();
		canvas.setBounds(20, 60, 110, 130);
		this.add(canvas);
		
		btnPhoto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex03PhotoInfo.this, "���Ͽ���", FileDialog.LOAD); 
				dlg.setVisible(true);
				if(dlg.getDirectory()==null) {
					return;
				}
				
			photoFile = dlg.getDirectory()+dlg.getFile();
			imagePhoto = new ImageIcon(photoFile).getImage();
			canvas.repaint();
			
			
			}
		});
		
		JLabel lbl1 = new JLabel("�̸�");
		lbl1.setBounds(10, 230, 60, 30);
		this.add(lbl1);
		
		JLabel lbl2 = new JLabel("�ڵ���");
		lbl2.setBounds(10, 270, 60, 30);
		this.add(lbl2);
		
		tfName = new JTextField();
		tfName.setBounds(80, 230, 80, 30);
		this.add(tfName);
		
		tfHp = new JTextField();
		tfHp.setBounds(80, 270, 100, 30);
		this.add(tfHp);
		
		btnSave = new JButton("�����ϱ�");
		btnSave.setBounds(150, 70, 100, 30);
		this.add(btnSave);
		
		btnOpen = new JButton("�ҷ�����");
		btnOpen.setBounds(150, 110, 100, 30);
		this.add(btnOpen);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText().trim();
				if(name.length()==0) {
					JOptionPane.showConfirmDialog(Ex03PhotoInfo.this, "�̸��� �Է����ּ���");
					return;
				}
				
				String hp = tfHp.getText().trim();
				if(hp.length()==0) {
					JOptionPane.showConfirmDialog(Ex03PhotoInfo.this, "�ڵ��� ��ȣ�� �Է����ּ���");
					return;
				}
				
				FileWriter fw = null;
				try {
					fw = new FileWriter("D:\\bitjava0719\\javawork\\" + name + ".txt");
					fw.write(photoFile+"\n");
					fw.write(name+"\n");
					fw.write(hp+"\n");
					
					JOptionPane.showMessageDialog(Ex03PhotoInfo.this, "����Ǿ����ϴ�.");
					tfName.setText("");
					tfHp.setText("");
					
					}catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex03PhotoInfo.this, "������������", FileDialog.LOAD);
				dlg.setVisible(true);
				if(dlg.getDirectory()==null) {
					return;
				}
				
				String fileName = dlg.getDirectory()+dlg.getFile();
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(fileName);
					br = new BufferedReader(fr);
					
					photoFile = br.readLine();
					imagePhoto = new ImageIcon(photoFile).getImage();
					canvas.repaint();
					
					String name = br.readLine();
					String hp = br.readLine();
					tfName.setText(name);
					tfHp.setText(hp);
					
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				
				
			}
		});
		
		
	}
	
	class PhotoCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
		
			g.drawImage(imagePhoto, 10, 10, 110, 130, this);
		
		
		}
	}
	public static void main(String[] args) {

		new Ex03PhotoInfo("������������");
		
	}

}
