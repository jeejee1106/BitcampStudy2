package day0817;

import java.io.Serializable;
//직렬화를 위한 데이터 클래스
public class Shop implements Serializable{
	private String sang;
	private int su;
	private int dan;
	
	public Shop() {
		
	}

	public Shop(String sang, int su, int dan) {
		super();
		this.sang = sang;
		this.su = su;
		this.dan = dan;
	}
	
	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}



	public static void main(String[] args) {
		

	}

}
