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
	//파일명
	static final String FILENAME = "D:\\bitjava0719\\javawork\\setting.txt";
	JCheckBox cbItalic, cbBold;
	JRadioButton[] rbFont = new JRadioButton[4];
	JLabel lblResult;
	
	
	public Ex04SettingSave() {
		super("셋팅값 저장하기");
		this.setBounds(700,100,400,300);
		this.readSetting(); //셋팅값을 파일에서 불러와야 디자인에 반영하므로 디자인보다 먼저 호출
		this.setDesign();
		//종료이벤트
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//셋팅값 파일에 저장
				saveSetting();
				//메세지
				JOptionPane.showMessageDialog(Ex04SettingSave.this, "셋팅값 저장 후 종료합니다.");
				//종료
				System.exit(0);
			}
		});
		
		
		this.setVisible(true);
	}
	
	
	//생성시 셋팅값 불러오는 메서드
	public void readSetting() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			fsize = Integer.parseInt(br.readLine());
			italic = Boolean.parseBoolean(br.readLine()); //true, false를 문자열 형태로 읽어오므로  boolean으로 변환
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
			System.out.println("확인:fsize" + fsize + ",italic:" + italic + ",blod:" + bold);
		} try {
			if(br!=null) br.close();
			if(fr!=null) fr.close();
		} catch(IOException e) {
			
		}
	}
	
	//종료시 셋팅값 저장하는 메서드
	public void saveSetting() {
		//읽어 온 순서대로 저장해야한다. fsize -> italic -> blod
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			//저장
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
		
		//글꼴사이즈
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
			
			//이벤트
			rbFont[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fsize = Integer.parseInt(rbFont[idx].getText());
					changeFont();
				}
			});
			
			
		}
		//italic
		cbItalic = new JCheckBox("기울게",italic);
		cbItalic.setBounds(60, 180, 80, 30);
		this.add(cbItalic);
		
		//bold
		cbBold = new JCheckBox("굵게", bold);
		cbBold.setBounds(150, 180, 80, 30);
		this.add(cbBold);
		//이벤트
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
				bold = cbBold.isSelected(); //방법1
//				JCheckBox ob = (JCheckBox)e.getSource(); //방법2
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
