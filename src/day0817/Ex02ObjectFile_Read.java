package day0817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex02ObjectFile_Read {

	public static void main(String[] args) {
		
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		
		try {
			fi = new FileInputStream("C:\\Users\\PC\\Desktop\\study\\wlrfufghk.txt");
			oi = new ObjectInputStream(fi);
			Apple a = (Apple) oi.readObject();
			System.out.println("**파일에서 읽은 Apple 데이터**");
			a.write();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oi.close();
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
