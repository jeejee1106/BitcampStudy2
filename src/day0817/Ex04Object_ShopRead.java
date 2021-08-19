package day0817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex04Object_ShopRead {
	ArrayList<Shop> list = new ArrayList<Shop>();
	
	public void fileObjectRead() {
		//���Ͽ��� �о ����Ͻÿ�(������ȭ)
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("C:\\Users\\PC\\Desktop\\study\\shop0817.txt");
//			fis = new FileInputStream("D:\\bitjava0719\\javawork\\shop0817.txt");
			ois = new ObjectInputStream(fis);
			list = (ArrayList<Shop>)ois.readObject();
			
			System.out.println("��ǰ��\t����\t�ܰ�");
			System.out.println("========================");
			for(Shop s:list) {
				System.out.println(s.getSang() + "\t" + s.getSu() + "\t" + s.getDan());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args) {
		Ex04Object_ShopRead ex = new Ex04Object_ShopRead();
		ex.fileObjectRead();
		
	}

}
