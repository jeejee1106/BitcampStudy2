package day0818;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class Ex0818SeriaFile {

	static final String FILENAME = "C:\\Users\\PC\\Desktop\\study\\sawon0818.txt";
	//	static final String FILENAME = "D:\\bitjava0719\\javawork\\sawon0818.txt";
	Vector<Sawon> list = new Vector<Sawon>();
	Scanner sc = new Scanner(System.in);

	public Ex0818SeriaFile() {
		fileRead();
		process();
	}

	public void addSawon() {
		System.out.println("�߰��� ������� �Է����ּ���");
		String name = sc.nextLine();
		System.out.println("�ڵ��� ��ȣ�� �Է��� �ּ���");
		int hp = Integer.parseInt(sc.nextLine());
		System.out.println("�ּҸ� �Է��� �ּ���");
		String addr = sc.nextLine();

		Sawon sa = new Sawon(name, hp, addr);
		list.add(sa);
		System.out.println("�߰��Ǿ����ϴ�.");
	}

	public void deleteSawon() {
		System.out.println("������ ������� �Է����ּ���");
		String name = sc.nextLine();
		boolean find = false;
		for(int i = 0; i<list.size(); i++) {
			Sawon s = list.get(i);
			if(s.getName().equals(name)) {
				find = true;
				list.remove(i);
				break;
			}
		}
		if(find) {
			System.out.println(name + "���� �����߽��ϴ�.");
		} else {
			System.out.println(name + "���� ��ܿ� �����ϴ�.");
		}
	}

	public void fileWrite() {
		FileOutputStream fo = null;
		ObjectOutputStream oo = null;

		try {
			fo = new FileOutputStream(FILENAME);
			oo = new ObjectOutputStream(fo);
			oo.writeObject(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oo!=null); oo.close();
				if(fo!=null); fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileRead() {
		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			fi = new FileInputStream(FILENAME);
			oi = new ObjectInputStream(fi);
			list = (Vector<Sawon>)oi.readObject(); //���Ͽ� ����� ���������� ����Ʈ�� �о�´�.
			System.out.println("�� " + list.size() + "���� ����Ʈ�� �ҷ��ɴϴ�."); //������� ������ �� ����Ǿ� �ִ� �����͸� �ҷ����� ���Ѱ���

		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�." + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //SawonŬ������ ������� ����� Exception
			e.printStackTrace();
		} finally {
			try {
				if(oi!=null)oi.close();
				if(fi!=null)fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void allData() {
		int num = 0;
		if(list.size()==0) {
			System.out.println("ȸ�� ����� �����ϴ�.");
			return;
		}
		System.out.println("\t**��ü ��� ����Դϴ�.**");
		System.out.println("�����\t�ڵ�����ȣ\t�ּ�");
		System.out.println("===================================");
		for(Sawon sa : list) {
			System.out.println(sa.getName() + "\t" + sa.getHp() + "\t" + sa.getAddr());
		}
	}



	public void process() {
		while(true) {
			System.out.println("1.����߰�\t 2.�������\t 3.��ü���\t 4.����");
			int n = Integer.parseInt(sc.nextLine());
			switch(n){
			case 1:
				addSawon();
				break;
			case 2:
				deleteSawon();
				break;
			case 3:
				allData();
				break;
			case 4:
				fileWrite();
				System.out.println("����Ǿ����ϴ�. �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("1~4���߿� �������ּ���");
			}
		}
	}

	public static void main(String[] args) {

		Ex0818SeriaFile ex = new Ex0818SeriaFile(); //����Ʈ �����ڸ� ȣ���Ѱ���. �׷��� FileRead();�޼��尡 ���� ���� ����Ǽ� ������ ���� �� 
													//�� ������process() �޼��带 �����Ѵ�.
//		ex.process();

	}

}
