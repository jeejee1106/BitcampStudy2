package day0818;

import java.io.Serializable;

public class Sawon implements Serializable {
	String name;
	int hp;
	String addr;
	
	public Sawon() {
		
	}
	
	public Sawon(String name, int hp, String addr) {
		this.name = name;
		this.hp = hp;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
