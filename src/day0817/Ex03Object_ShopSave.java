package day0817;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex03Object_ShopSave {
	ArrayList<Shop> list = new ArrayList<Shop>();
	Scanner sc = new Scanner(System.in);
	
	//키보드로 입력하면 list에 추가
	public void addShop() {
		System.out.println("상품명을 입렵하세여");
		String sang = sc.nextLine();
		System.out.println("수량은?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가는?");
		int dan = Integer.parseInt(sc.nextLine());
		
		//Shop객체 생성
		Shop s = new Shop(sang, su, dan);
		//list에 추가
		list.add(s);
		System.out.println(list.size() + "번째 상품이 추가되었습니다.");
	}
	
	//list를 파일에 저장(직렬화 이용)
	public void writeFile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; //직렬화 코드
		
		try {
			fos = new FileOutputStream("C:\\Users\\PC\\Desktop\\study\\shop0817.txt");
//			fos = new FileOutputStream("D:\\bitjava0719\\javawork\\shop0817.txt");
			oos = new ObjectOutputStream(fos);
			//파일에 오브젝트 통채로 저장
			oos.writeObject(list);
			System.out.println("파일에 list 전체 저장");
			
 		} catch(Exception e){
 			e.printStackTrace();
 		} finally {
 			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
 		}
	}
	
	//메인에서 호출되는 메서드
	public void process() {
		while(true) {
			System.out.println("1. shop정보 추가");
			System.out.println("2. 전체 목록 파일에 저장");
			System.out.println("3. 시스템 종료");
			int n = Integer.parseInt(sc.nextLine());
			switch(n) {
			case 1:
				this.addShop();
				break;
			case 2:
				this.writeFile();
				break;
			default:
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
				
			}
		}
	}
	
	public static void main(String[] args) {
		Ex03Object_ShopSave ex = new Ex03Object_ShopSave();
		ex.process();
	}

}
