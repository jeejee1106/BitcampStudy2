package day0813;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex07ServerChat extends JFrame implements Runnable{
	JTextArea area;
	ServerSocket serverSocket;
	Vector<ClientList> list = new Vector<ClientList>(); //클라이언트 정보를 담을 리스트 변수

	public Ex07ServerChat() {
		super("서버입니다.");
		this.setBounds(100, 100, 300, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	//클라이언트를 담을 내부 클래스
	class ClientList extends Thread{
		Socket socket;
		BufferedReader br;
		PrintWriter pw;
		String nickName;

		public ClientList(Socket socket) {
			this.socket = socket;
			//네트워크를 통해서 메세지를 읽고 쓰기 위한 io 변수 생성
			try {
				pw = new PrintWriter(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				//e.printStackTrace();
			}

		}
		//##run2 - 다시 읽어서 클라이언트한테 보내기 위함
		@Override
		public void run() {
			while(true) {
				try {
					String msg = br.readLine(); //클라이언트가 보낸 메세지를 한 줄 단위로 읽는다.
					
					//분리
					StringTokenizer st = new StringTokenizer(msg,"|");
					String num = st.nextToken();
					String data = st.nextToken();
					switch(num) {
					case "1" :{
						//모든 클라이언트에게 입장했다는 메세지를 보낸다.
						this.nickName = data; //1일 경우엔 두 번째 인자가 닉네임이다.
						for(ClientList cc:list) {
							cc.pw.write(nickName + "님이 입장했습니다.\n"); //반드시 \n을 해야 네크워크로 전송이됨
							cc.pw.flush(); //flush 를 해야 비로소 네크워크로 전송. 이 두 가지를 무조건 써줘야함
						}
					}
					break;

					case "2" :
						//모든 클리어언트한테 메세지를 보낸다
						String send = st.nextToken(); //보낸 사람의 닉네임
						for(ClientList cc:list) {
							cc.pw.write(send + ">>" + data + "\n"); //반드시 \n을 해야 네크워크로 전송이됨
							cc.pw.flush(); //flush 를 해야 비로소 네크워크로 전송. 이 두 가지를 무조건 써줘야함
						}
						break;

					case "9" :
						//data가 퇴장하는 사람의 닉네임이므로 찾아서 벡터에서 삭제
						for(int i = 0; i<list.size(); i++) {
							ClientList cc = list.get(i);
							if(data.equals(cc.nickName)) {
								list.remove(i);
								break;
							}
						}
						for(int i = 0; i<list.size(); i++) {
							ClientList cc = list.get(i);
							cc.pw.write(data + "님이 퇴장했습니다.\n");
							cc.pw.flush();
						}
					}
				} catch (IOException e) {
					//					e.printStackTrace();
				}
			}
		}
	}

	//##run1
	@Override
	public void run() {
		//서버 소켓 생성
		try {
			serverSocket = new ServerSocket(6000);
			area.append("서버소켓 생성 성공!!\n");
		} catch (IOException e) {
			area.append("서버소켓 생성 실패 ㅠㅠ" + e.getMessage());
		}

		//접속을 시도하는 클라이언트들을 허용하기 위해서 대기상태
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				area.append(socket.getInetAddress().getHostAddress() + " IP로 접속함\n");
				//벡터에 접속한 클라이언트 추가
				ClientList client = new ClientList(socket);
				list.add(client); //리스트에 접속한 클라이언트 추가
				client.start(); //run2 호출
			} catch (IOException e) {
				area.append("클라이언트 접속 실패! : " + e.getMessage());
			}
		}
	}

	private void setDesign() {
		area = new JTextArea();
		area.setFont(new Font("", Font.BOLD, 16));
		this.add(new JScrollPane(area));	

	}

	public static void main(String[] args) {
		Ex07ServerChat ex = new Ex07ServerChat();

		Thread th = new Thread(ex);
		th.start(); //run1 호출

	}


}
