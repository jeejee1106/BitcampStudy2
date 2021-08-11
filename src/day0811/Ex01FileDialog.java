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
		super("파일 다이얼로그");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setBounds(800,100,400,400);
		this.setVisible(true);
	}

	public void setDesign() {
		this.setLayout(null);

		btnOpen = new JButton("파일 불러오기");
		btnOpen.setBounds(40, 20, 120, 30);
		this.add(btnOpen);
		btnOpen.addActionListener(new ActionListener() { //익명 내부 클래스

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex01FileDialog.this, "파일열기", FileDialog.LOAD); //
				dlg.setVisible(true);
				//선택한 디렉토리
				String dir = dlg.getDirectory(); //아무개 폴더의
				//선택할 파일명
				String file = dlg.getFile(); //아무개 파일을 불러올 것이다!
				System.out.println(dir + "\n" + file); //이건 어떤 파일이 선택됐나 확인하려고 넣은 코드(콘솔창에 파일경로가 출력된다.)
				//만약 취소를 눌렀다면 메서드 종료
				if(dir==null) { //만약 받아온 디렉토리(getDirectory)가 없다면(null) 메서드종료(return)
					return;
				}
				FileReader fr = null;
				BufferedReader br = null;

				try {
					fr = new FileReader(dir+file);
					br = new BufferedReader(fr);
					//전에 불러온 데이터 삭제 후 다른 데이터 불러오기
					area.setText(""); //그래서 날짜도 삭제됨
					while(true) {
						String s = br.readLine();
						if(s==null) {
							break;
						}
						
						//읽은 데이터를 area에 추가
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

		btnSave = new JButton("파일 저장하기");
		this.btnSave.setBounds(200, 20, 120, 30);
		this.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex01FileDialog.this, "파일저장", FileDialog.SAVE);
				dlg.setVisible(true);
				String dir = dlg.getDirectory();
				String file = dlg.getFile();
				
				if(dir==null) { //만약 받아온 디렉토리(getDirectory)가 없다면(null) 메서드종료(return)
					return;
				}
				
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(dir+file);
					//area의 내용을 가져와서 파일에 저장
					fw.write(area.getText() + "\n");
					//area에 저장 메세지를 넣어보자. 필수는 아닌데 저장이 잘 됐는지 확인해보기 위해
					area.setText(file + "파일로 저장됨"); 
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
		area.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		//area를 스크롤이 가능한 패널에 넣어서 프레임에 추가
		JScrollPane js = new JScrollPane(area);
		js.setBounds(20, 70, 350, 260);
		this.add(js);
//		this.add(area); //스크롤패널이 없는 기존 add
	}

	public static void main(String[] args) {
		new Ex01FileDialog();

	}

}
