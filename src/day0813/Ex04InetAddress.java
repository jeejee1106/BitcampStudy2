package day0813;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex04InetAddress {

	public static void main(String[] args) {
		InetAddress myAddr = null;
		
		try {
			myAddr = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터의 이름:" + myAddr.getHostName());
			System.out.println("내 컴퓨터의 IP:" + myAddr.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}

}