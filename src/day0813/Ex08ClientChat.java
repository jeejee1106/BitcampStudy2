package day0813;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex08ClientChat extends JFrame implements Runnable, ActionListener{
	JTextArea area;
	String nickName;
	JTextField tfServerIp, tfNickName, tfMessage;
	JButton btnConnect, btnSend;
	Socket socket; //소켓이 있어야 서버와 대화를 주고 받을 수 있음
	
	//서버와의 통신을 위한 변수선언
	BufferedReader br;
	PrintWriter pw;
	
	public Ex08ClientChat() {
		super("클라이언트 입니다.");
		this.setBounds(800, 100, 500, 600);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//종료시 이벤트
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//서버에 9번과 닉네임을 보내서 퇴장함을 알림 후 종료
				pw.write("9|" + tfNickName.getText() + "\n");
				pw.flush();
			
				System.exit(0);
			}
		});
		
		this.setDesign();
		this.setVisible(true);
	}
	
	private void setDesign() {
		this.setLayout(null);
		JLabel lbl1 = new JLabel("서버 IP");
		lbl1.setBounds(20, 20, 80, 30);
		this.add(lbl1);
		
		tfNickName = new JTextField("김민지");
		tfNickName.setBounds(90, 20, 80, 30);
		this.add(tfNickName);

		tfServerIp = new JTextField("127.0.0.1");
		tfServerIp.setBounds(190, 20, 100, 30);
		this.add(tfServerIp);
		
		btnConnect = new JButton("접속");
		btnConnect.setBounds(300, 20, 80, 30);
		this.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//서버 아이피를 읽어온다
				String serverIp = tfServerIp.getText().trim();
				//서버에 접속
				try {
					socket = new Socket(serverIp, 6000);
					area.append("서버에 성공적으로 접속함\n");
					
					//네트워크를 통해서 메세지를 읽고 쓰기 위한 io 변수 생성
					try {
						pw = new PrintWriter(socket.getOutputStream());
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
						//창 제목을 닉네임으로 변경
						Ex08ClientChat.this.setTitle(tfNickName.getText()+"님의 채팅창");
						
						//서버에 메세지 보내기
						pw.write("1|"+tfNickName.getText().trim()+"\n"); //입장할 때 닉네임 보내기 위함임
						pw.flush();
						
						//run메서드 호출
						Thread th = new Thread(Ex08ClientChat.this); //익명내부라서 외부클래스의 this를 보내야한다
						th.start();
						
					} catch (IOException e1) {
						//e1.printStackTrace();
					}
					
				} catch (UnknownHostException e1) {
					area.append("서버주소나 포트 다시 확인" + e1.getMessage());
				} catch (IOException e1) {
					area.append("접속오류 : " + e1.getMessage()+"\n");
				}
			}
		});
		
		area = new JTextArea();
		area.setFont(new Font("", Font.BOLD, 16));
		JScrollPane js = new JScrollPane(area);
		js.setBounds(20, 80, 360, 330);
		this.add(js);
		
		tfMessage = new JTextField();
		tfMessage.setBounds(20, 430, 260, 30);
		this.add(tfMessage);
		
		btnSend = new JButton("전송");
		btnSend.setBounds(290, 430, 60, 30);
		this.add(btnSend);
		
		tfMessage.addActionListener(this); // 엔터치면 메세지 전송
		btnSend.addActionListener(this); //전송 버튼 클릭 시 메세지 전송
		
	}

	public static void main(String[] args) {
		Ex08ClientChat ex = new Ex08ClientChat();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); 
		if(ob==tfMessage || ob==btnSend) {
			pw.write("2|" + tfMessage.getText().trim() + "|" + tfNickName.getText()+"\n");
			pw.flush();
			
			//입력창에 메세지 띄우기
			tfMessage.setText("");
			//
			tfMessage.requestFocus();
			
		}
	}

	@Override
	public void run() { //24시간 대기모드로 있어야함
		while(true) {
			//서버가 보내준 메세지를 읽는다.
			try {
				String msg = br.readLine();
				//area에 출력하기
				area.append(msg+"\n");
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
	}

}