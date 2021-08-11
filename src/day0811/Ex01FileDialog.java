package day0811;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex01FileDialog extends JFrame{
	JTextArea area;
	JButton btnOpen, btnSave;

	public Ex01FileDialog() {
		super("���� ���̾�α�");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setBounds(800,100,400,400);
		this.setVisible(true);
	}

	public void setDesign() {
		this.setLayout(null);

		btnOpen = new JButton("���� �ҷ�����");
		btnOpen.setBounds(40, 20, 120, 30);
		this.add(btnOpen);
		btnOpen.addActionListener(new ActionListener() { //�͸� ���� Ŭ����

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex01FileDialog.this, "���Ͽ���", FileDialog.LOAD); //
				dlg.setVisible(true);
				//������ ���丮
				String dir = dlg.getDirectory(); //�ƹ��� ������
				//������ ���ϸ�
				String file = dlg.getFile(); //�ƹ��� ������ �ҷ��� ���̴�!
				System.out.println(dir + "\n" + file); //�̰� � ������ ���õƳ� Ȯ���Ϸ��� ���� �ڵ�(�ܼ�â�� ���ϰ�ΰ� ��µȴ�.)
				//���� ��Ҹ� �����ٸ� �޼��� ����
				if(dir==null) { //���� �޾ƿ� ���丮(getDirectory)�� ���ٸ�(null) �޼�������(return)
					return;
				}
				FileReader fr = null;
				BufferedReader br = null;

				try {
					fr = new FileReader(dir+file);
					br = new BufferedReader(fr);
					//���� �ҷ��� ������ ���� �� �ٸ� ������ �ҷ�����
					area.setText(""); //�׷��� ��¥�� ������
					while(true) {
						String s = br.readLine();
						if(s==null) {
							break;
						}
						
						//���� �����͸� area�� �߰�
						area.append(s+"\n");
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(br!=null); br.close();
						if(fr!=null); fr.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		btnSave = new JButton("���� �����ϱ�");
		this.btnSave.setBounds(200, 20, 120, 30);
		this.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex01FileDialog.this, "��������", FileDialog.SAVE);
				dlg.setVisible(true);
				String dir = dlg.getDirectory();
				String file = dlg.getFile();
				
				if(dir==null) { //���� �޾ƿ� ���丮(getDirectory)�� ���ٸ�(null) �޼�������(return)
					return;
				}
				
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(dir+file);
					//area�� ������ �����ͼ� ���Ͽ� ����
					fw.write(area.getText() + "\n");
					//area�� ���� �޼����� �־��. �ʼ��� �ƴѵ� ������ �� �ƴ��� Ȯ���غ��� ����
					area.setText(file + "���Ϸ� �����"); 
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(fw==null); fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String day = sdf.format(new Date());
		
		area = new JTextArea(day);
		area.setFont(new Font("���� ���", Font.BOLD, 20));
		//area�� ��ũ���� ������ �гο� �־ �����ӿ� �߰�
		JScrollPane js = new JScrollPane(area);
		js.setBounds(20, 70, 350, 260);
		this.add(js);
//		this.add(area); //��ũ���г��� ���� ���� add
	}

	public static void main(String[] args) {
		new Ex01FileDialog();

	}

}
