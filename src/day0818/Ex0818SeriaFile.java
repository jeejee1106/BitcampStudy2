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
		System.out.println("추가할 사원명을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("핸드폰 번호를 입력해 주세요");
		int hp = Integer.parseInt(sc.nextLine());
		System.out.println("주소를 입력해 주세요");
		String addr = sc.nextLine();
		
		Sawon sa = new Sawon(name, hp, addr);
		list.add(sa);
		System.out.println("추가되었습니다.");
	}
	
	public void deleteSawon() {
		System.out.println("삭제할 사원명을 입력해주세요");
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
			System.out.println(name + "님을 삭제했습니다.");
		} else {
			System.out.println(name + "님은 명단에 없습니다.");
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
			
			System.out.println("사원명\t핸드폰번호\t주소");
			System.out.println("===================================");
			Sawon s = new Sawon(name, hp, addr);
			list.add(s);
			for(Sawon sa : list) {
				System.out.println(sa.getName() + "\t" + sa.getHp() + "\t" + sa.getAddr());
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다." + e.getMessage());
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
			System.out.println("1. 사원추가\t2.사원삭제\t3.전체 사원 출력\t4.종료");
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
				System.out.println("저장되었습니다. 종료합니다.");
				System.exit(0);
			default:
				System.out.println("1~4번중에 선택해주세요");
			}
		}
	}

	public static void main(String[] args) {
		
		Ex0818SeriaFile ex = new Ex0818SeriaFile();
		ex.process();
		
	}

}
