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
	
	
	Vector<Sawon> list = new Vector<Sawon>();
	Scanner sc = new Scanner(System.in);
	
	public Ex0818SeriaFile() {
		FileRead();
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
	
	public void FileWrite() {
		FileOutputStream fo = null;
		ObjectOutputStream oo = null;
		
		try {
			fo = new FileOutputStream("D:\\bitjava0719\\javawork\\sawon0818.txt");
			oo = new ObjectOutputStream(fo);
			oo.writeObject(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oo.close();
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void FileRead() {
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		String name = "";
		int hp = 0;
		String addr = "";
		
		try {
			fi = new FileInputStream("D:\\bitjava0719\\javawork\\sawon0818.txt");
			oi = new ObjectInputStream(fi);
			list = (Vector<Sawon>)oi.readObject();
			
			System.out.println("�����\t�ڵ�����ȣ\t�ּ�");
			System.out.println("===================================");
			Sawon s = new Sawon(name, hp, addr);
			list.add(s);
			for(Sawon sa : list) {
				System.out.println(sa.getName() + "\t" + sa.getHp() + "\t" + sa.getAddr());
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�." + e.getMessage());
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	
	public void process() {
		while(true) {
			System.out.println("1. ����߰�\t2.�������\t3.��ü ��� ���\t4.����");
			int n = Integer.parseInt(sc.nextLine());
			switch(n){
			case 1:
				addSawon();
				break;
			case 2:
				deleteSawon();
				break;
			case 3:
				FileRead();
				break;
			case 4:
				FileWrite();
				System.out.println("����Ǿ����ϴ�. �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("1~4���߿� �������ּ���");
			}
		}
	}

	public static void main(String[] args) {
		
		Ex0818SeriaFile ex = new Ex0818SeriaFile();
		ex.process();
		
	}

}
