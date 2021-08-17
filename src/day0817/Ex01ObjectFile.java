package day0817;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//직렬화를 위한 클래스
class Apple implements Serializable{ //직렬화를 위해서는 Serializable인터페이스를 을 반드시 구현해줘야함
	String name;
	int age;
	
	Apple(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void write() {
		System.out.println("이름 : " + name + "나이 : " + age);
	}
	
}
public class Ex01ObjectFile {

	public static void main(String[] args) {
		//파일에 오브젝트 통째로 저장하기
		Apple a1 = new Apple("캔디", 20);
		
		FileOutputStream fs = null;
		ObjectOutputStream ob = null;
		try {
			fs = new FileOutputStream("C:\\Users\\PC\\Desktop\\study\\wlrfufghk.txt");
			ob = new ObjectOutputStream(fs);
			//객체저장
			ob.writeObject(a1);
			System.out.println("wlrfufghk.txt 파일에 저장됨");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ob.close();
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
