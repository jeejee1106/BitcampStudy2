package day0817;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//����ȭ�� ���� Ŭ����
class Apple implements Serializable{ //����ȭ�� ���ؼ��� Serializable�������̽��� �� �ݵ�� �����������
	String name;
	int age;
	
	Apple(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void write() {
		System.out.println("�̸� : " + name + "���� : " + age);
	}
	
}
public class Ex01ObjectFile {

	public static void main(String[] args) {
		//���Ͽ� ������Ʈ ��°�� �����ϱ�
		Apple a1 = new Apple("ĵ��", 20);
		
		FileOutputStream fs = null;
		ObjectOutputStream ob = null;
		try {
			fs = new FileOutputStream("C:\\Users\\PC\\Desktop\\study\\wlrfufghk.txt");
			ob = new ObjectOutputStream(fs);
			//��ü����
			ob.writeObject(a1);
			System.out.println("wlrfufghk.txt ���Ͽ� �����");
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
