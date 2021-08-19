package day0817;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex03Object_ShopSave {
	ArrayList<Shop> list = new ArrayList<Shop>();
	Scanner sc = new Scanner(System.in);
	
	//Ű����� �Է��ϸ� list�� �߰�
	public void addShop() {
		System.out.println("��ǰ���� �Է��ϼ���");
		String sang = sc.nextLine();
		System.out.println("������?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("�ܰ���?");
		int dan = Integer.parseInt(sc.nextLine());
		
		//Shop��ü ����
		Shop s = new Shop(sang, su, dan);
		//list�� �߰�
		list.add(s);
		System.out.println(list.size() + "��° ��ǰ�� �߰��Ǿ����ϴ�.");
	}
	
	//list�� ���Ͽ� ����(����ȭ �̿�)
	public void writeFile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; //����ȭ �ڵ�
		
		try {
			fos = new FileOutputStream("C:\\Users\\PC\\Desktop\\study\\shop0817.txt");
//			fos = new FileOutputStream("D:\\bitjava0719\\javawork\\shop0817.txt");
			oos = new ObjectOutputStream(fos);
			//���Ͽ� ������Ʈ ��ä�� ����
			oos.writeObject(list);
			System.out.println("���Ͽ� list ��ü ����");
			
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
	
	//���ο��� ȣ��Ǵ� �޼���
	public void process() {
		while(true) {
			System.out.println("1. shop���� �߰�");
			System.out.println("2. ��ü ��� ���Ͽ� ����");
			System.out.println("3. �ý��� ����");
			int n = Integer.parseInt(sc.nextLine());
			switch(n) {
			case 1:
				this.addShop();
				break;
			case 2:
				this.writeFile();
				break;
			default:
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
				
			}
		}
	}
	
	public static void main(String[] args) {
		Ex03Object_ShopSave ex = new Ex03Object_ShopSave();
		ex.process();
	}

}
