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
	Socket socket; //������ �־�� ������ ��ȭ�� �ְ� ���� �� ����
	
	//�������� ����� ���� ��������
	BufferedReader br;
	PrintWriter pw;
	
	public Ex08ClientChat() {
		super("Ŭ���̾�Ʈ �Դϴ�.");
		this.setBounds(800, 100, 500, 600);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//����� �̺�Ʈ
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//������ 9���� �г����� ������ �������� �˸� �� ����
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
		JLabel lbl1 = new JLabel("���� IP");
		lbl1.setBounds(20, 20, 80, 30);
		this.add(lbl1);
		
		tfNickName = new JTextField("�����");
		tfNickName.setBounds(90, 20, 80, 30);
		this.add(tfNickName);

		tfServerIp = new JTextField("127.0.0.1");
		tfServerIp.setBounds(190, 20, 100, 30);
		this.add(tfServerIp);
		
		btnConnect = new JButton("����");
		btnConnect.setBounds(300, 20, 80, 30);
		this.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���� �����Ǹ� �о�´�
				String serverIp = tfServerIp.getText().trim();
				//������ ����
				try {
					socket = new Socket(serverIp, 6000);
					area.append("������ ���������� ������\n");
					
					//��Ʈ��ũ�� ���ؼ� �޼����� �а� ���� ���� io ���� ����
					try {
						pw = new PrintWriter(socket.getOutputStream());
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
						//â ������ �г������� ����
						Ex08ClientChat.this.setTitle(tfNickName.getText()+"���� ä��â");
						
						//������ �޼��� ������
						pw.write("1|"+tfNickName.getText().trim()+"\n"); //������ �� �г��� ������ ������
						pw.flush();
						
						//run�޼��� ȣ��
						Thread th = new Thread(Ex08ClientChat.this); //�͸��ζ� �ܺ�Ŭ������ this�� �������Ѵ�
						th.start();
						
					} catch (IOException e1) {
						//e1.printStackTrace();
					}
					
				} catch (UnknownHostException e1) {
					area.append("�����ּҳ� ��Ʈ �ٽ� Ȯ��" + e1.getMessage());
				} catch (IOException e1) {
					area.append("���ӿ��� : " + e1.getMessage()+"\n");
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
		
		btnSend = new JButton("����");
		btnSend.setBounds(290, 430, 60, 30);
		this.add(btnSend);
		
		tfMessage.addActionListener(this); // ����ġ�� �޼��� ����
		btnSend.addActionListener(this); //���� ��ư Ŭ�� �� �޼��� ����
		
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
			
			//�Է�â�� �޼��� ����
			tfMessage.setText("");
			//
			tfMessage.requestFocus();
			
		}
	}

	@Override
	public void run() { //24�ð� ������ �־����
		while(true) {
			//������ ������ �޼����� �д´�.
			try {
				String msg = br.readLine();
				//area�� ����ϱ�
				area.append(msg+"\n");
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
	}

}