package day0813;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex05InerAddress {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String host;
		System.out.println("host url �Է��ϱ�");
		
		host = sc.nextLine();
		
		System.out.println("["+host+"] �� ��ǻ���̸��� ���� ip�˾ƺ���");
		InetAddress[] inet = null;
		try {
			inet = InetAddress.getAllByName(host);
			
			for(InetAddress ia : inet) {
				System.out.println("��ǻ�� �̸�:" + ia.getHostName());
				System.out.println("������ IP" + ia.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}