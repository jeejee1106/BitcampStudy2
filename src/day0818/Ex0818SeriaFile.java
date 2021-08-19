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
			list = (Vector<Sawon>)oi.readObject(); //파일에 저장된 벡터형태의 리스트를 읽어온다.
			System.out.println("총 " + list.size() + "개의 리스트를 불러옵니다."); //여기까진 생성할 때 저장되어 있는 데이터를 불러오기 위한거임

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다." + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //Sawon클래스가 없을까봐 생기는 Exception
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
			System.out.println("회원 목록이 없습니다.");
			return;
		}
		System.out.println("\t**전체 사원 목록입니다.**");
		System.out.println("사원명\t핸드폰번호\t주소");
		System.out.println("===================================");
		for(Sawon sa : list) {
			System.out.println(sa.getName() + "\t" + sa.getHp() + "\t" + sa.getAddr());
		}
	}



	public void process() {
		while(true) {
			System.out.println("1.사원추가\t 2.사원삭제\t 3.전체출력\t 4.종료");
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
				System.out.println("저장되었습니다. 종료합니다.");
				System.exit(0);
			default:
				System.out.println("1~4번중에 선택해주세요");
			}
		}
	}

	public static void main(String[] args) {

		Ex0818SeriaFile ex = new Ex0818SeriaFile(); //디폴트 생성자를 호출한거임. 그래서 FileRead();메서드가 제일 먼저 실행되서 파일을 읽은 후 
													//그 다음에process() 메서드를 실행한다.
//		ex.process();

	}

}
