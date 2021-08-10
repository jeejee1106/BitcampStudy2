package day0810;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Ex04SettingSave extends JFrame {
	int fsize;
	boolean italic, bold;
	//���ϸ�
	static final String FILENAME = "D:\\bitjava0719\\javawork\\setting.txt";
	JCheckBox cbItalic, cbBold;
	JRadioButton[] rbFont = new JRadioButton[4];
	JLabel lblResult;
	
	
	public Ex04SettingSave() {
		super("���ð� �����ϱ�");
		this.setBounds(700,100,400,300);
		this.readSetting(); //���ð��� ���Ͽ��� �ҷ��;� �����ο� �ݿ��ϹǷ� �����κ��� ���� ȣ��
		this.setDesign();
		//�����̺�Ʈ
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//���ð� ���Ͽ� ����
				saveSetting();
				//�޼���
				JOptionPane.showMessageDialog(Ex04SettingSave.this, "���ð� ���� �� �����մϴ�.");
				//����
				System.exit(0);
			}
		});
		
		
		this.setVisible(true);
	}
	
	
	//������ ���ð� �ҷ����� �޼���
	public void readSetting() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			fsize = Integer.parseInt(br.readLine());
			italic = Boolean.parseBoolean(br.readLine()); //true, false�� ���ڿ� ���·� �о���Ƿ�  boolean���� ��ȯ
			bold = Boolean.parseBoolean(br.readLine());
		} catch (FileNotFoundException e) {
			fsize = 15;
			italic = false;
			bold = false;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Ȯ��:fsize" + fsize + ",italic:" + italic + ",blod:" + bold);
		} try {
			if(br!=null) br.close();
			if(fr!=null) fr.close();
		} catch(IOException e) {
			
		}
	}
	
	//����� ���ð� �����ϴ� �޼���
	public void saveSetting() {
		//�о� �� ������� �����ؾ��Ѵ�. fsize -> italic -> blod
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			//����
			fw.write(fsize+"\n");
			fw.write(italic+"\n");
			fw.write(bold+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setDesign() {
		this.setLayout(null);
		
		lblResult = new JLabel("Have a Nice Day!!", JLabel.CENTER);
		changeFont();
		lblResult.setBorder(new LineBorder(Color.green,5));
		lblResult.setBounds(20,30,350,80);
		this.add(lblResult);
		
		//�۲û�����
		int init = 10;
		int xpos= 50;
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i<rbFont.length; i++) {
			int idx = i;
			rbFont[i] = new JRadioButton(String.valueOf(init), init==fsize?true:false);
			init+=5;
			bg.add(rbFont[i]);
			rbFont[i].setBounds(xpos, 140, 40, 30);
			this.add(rbFont[i]);
			xpos+=60;
			
			//�̺�Ʈ
			rbFont[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fsize = Integer.parseInt(rbFont[idx].getText());
					changeFont();
				}
			});
			
			
		}
		//italic
		cbItalic = new JCheckBox("����",italic);
		cbItalic.setBounds(60, 180, 80, 30);
		this.add(cbItalic);
		
		//bold
		cbBold = new JCheckBox("����", bold);
		cbBold.setBounds(150, 180, 80, 30);
		this.add(cbBold);
		//�̺�Ʈ
		cbItalic.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				italic = cbItalic.isSelected();
				changeFont();
			}
		});
		
		cbBold.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				bold = cbBold.isSelected(); //���1
//				JCheckBox ob = (JCheckBox)e.getSource(); //���2
//				bold = ob.isSelected();
				changeFont();
			}
		});
		
	}
	
	public void changeFont() {
		if(italic && bold) {
			lblResult.setFont(new Font("Comic Sans MS",Font.BOLD|Font.ITALIC,fsize));
		} else if(italic && !bold) {
			lblResult.setFont(new Font("Comic Sans MS",Font.ITALIC,fsize));
		} else if(!italic && bold) {
			lblResult.setFont(new Font("Comic Sans MS",Font.BOLD,fsize));
		} else {
			lblResult.setFont(new Font("Comic Sans MS",Font.PLAIN,fsize));
		}
	}
	

	public static void main(String[] args) {
		new Ex04SettingSave();
	}

}
