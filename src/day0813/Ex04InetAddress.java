package day0813;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex04InetAddress {

	public static void main(String[] args) {
		InetAddress myAddr = null;
		
		try {
			myAddr = InetAddress.getLocalHost();
			System.out.println("�� ��ǻ���� �̸�:" + myAddr.getHostName());
			System.out.println("�� ��ǻ���� IP:" + myAddr.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}

}