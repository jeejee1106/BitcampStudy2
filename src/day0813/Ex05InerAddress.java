package day0813;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex05InerAddress {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String host;
		System.out.println("host url 입력하기");
		
		host = sc.nextLine();
		
		System.out.println("["+host+"] 의 컴퓨터이름과 서버 ip알아보기");
		InetAddress[] inet = null;
		try {
			inet = InetAddress.getAllByName(host);
			
			for(InetAddress ia : inet) {
				System.out.println("컴퓨터 이름:" + ia.getHostName());
				System.out.println("서버의 IP" + ia.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}