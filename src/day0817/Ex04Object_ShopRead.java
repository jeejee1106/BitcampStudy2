package day0817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex04Object_ShopRead {
	ArrayList<Shop> list = new ArrayList<Shop>();
	
	public void fileObjectRead() {
		//파일에서 읽어서 출력하시오(역직렬화)
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("C:\\Users\\PC\\Desktop\\study\\shop0817.txt");
//			fis = new FileInputStream("D:\\bitjava0719\\javawork\\shop0817.txt");
			ois = new ObjectInputStream(fis);
			list = (ArrayList<Shop>)ois.readObject();
			
			System.out.println("상품명\t수량\t단가");
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
