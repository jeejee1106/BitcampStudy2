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
	Vector<ClientList> list = new Vector<ClientList>(); //Ŭ���̾�Ʈ ������ ���� ����Ʈ ����

	public Ex07ServerChat() {
		super("�����Դϴ�.");
		this.setBounds(100, 100, 300, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	//Ŭ���̾�Ʈ�� ���� ���� Ŭ����
	class ClientList extends Thread{
		Socket socket;
		BufferedReader br;
		PrintWriter pw;
		String nickName;

		public ClientList(Socket socket) {
			this.socket = socket;
			//��Ʈ��ũ�� ���ؼ� �޼����� �а� ���� ���� io ���� ����
			try {
				pw = new PrintWriter(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				//e.printStackTrace();
			}

		}
		//##run2 - �ٽ� �о Ŭ���̾�Ʈ���� ������ ����
		@Override
		public void run() {
			while(true) {
				try {
					String msg = br.readLine(); //Ŭ���̾�Ʈ�� ���� �޼����� �� �� ������ �д´�.
					
					//�и�
					StringTokenizer st = new StringTokenizer(msg,"|");
					String num = st.nextToken();
					String data = st.nextToken();
					switch(num) {
					case "1" :{
						//��� Ŭ���̾�Ʈ���� �����ߴٴ� �޼����� ������.
						this.nickName = data; //1�� ��쿣 �� ��° ���ڰ� �г����̴�.
						for(ClientList cc:list) {
							cc.pw.write(nickName + "���� �����߽��ϴ�.\n"); //�ݵ�� \n�� �ؾ� ��ũ��ũ�� �����̵�
							cc.pw.flush(); //flush �� �ؾ� ��μ� ��ũ��ũ�� ����. �� �� ������ ������ �������
						}
					}
					break;

					case "2" :
						//��� Ŭ�����Ʈ���� �޼����� ������
						String send = st.nextToken(); //���� ����� �г���
						for(ClientList cc:list) {
							cc.pw.write(send + ">>" + data + "\n"); //�ݵ�� \n�� �ؾ� ��ũ��ũ�� �����̵�
							cc.pw.flush(); //flush �� �ؾ� ��μ� ��ũ��ũ�� ����. �� �� ������ ������ �������
						}
						break;

					case "9" :
						//data�� �����ϴ� ����� �г����̹Ƿ� ã�Ƽ� ���Ϳ��� ����
						for(int i = 0; i<list.size(); i++) {
							ClientList cc = list.get(i);
							if(data.equals(cc.nickName)) {
								list.remove(i);
								break;
							}
						}
						for(int i = 0; i<list.size(); i++) {
							ClientList cc = list.get(i);
							cc.pw.write(data + "���� �����߽��ϴ�.\n");
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
		//���� ���� ����
		try {
			serverSocket = new ServerSocket(6000);
			area.append("�������� ���� ����!!\n");
		} catch (IOException e) {
			area.append("�������� ���� ���� �Ф�" + e.getMessage());
		}

		//������ �õ��ϴ� Ŭ���̾�Ʈ���� ����ϱ� ���ؼ� ������
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				area.append(socket.getInetAddress().getHostAddress() + " IP�� ������\n");
				//���Ϳ� ������ Ŭ���̾�Ʈ �߰�
				ClientList client = new ClientList(socket);
				list.add(client); //����Ʈ�� ������ Ŭ���̾�Ʈ �߰�
				client.start(); //run2 ȣ��
			} catch (IOException e) {
				area.append("Ŭ���̾�Ʈ ���� ����! : " + e.getMessage());
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
		th.start(); //run1 ȣ��

	}


}
