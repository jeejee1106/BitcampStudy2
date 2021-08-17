package day0813;

public class Ex02Runnable_Interface implements Runnable {
	String name;
	int num;
	
	public Ex02Runnable_Interface(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	@Override
	public void run() {
		for(int i = 1; i<300; i++) {
			System.out.println(name + "쓰레드 차례 =>" + i);
		}
	}

	
	public static void main(String[] args) {

		Ex02Runnable_Interface a = new Ex02Runnable_Interface("1번", 300);
		Ex02Runnable_Interface b = new Ex02Runnable_Interface("2번", 300);
		Ex02Runnable_Interface c = new Ex02Runnable_Interface("3번", 300);
		
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		Thread t3 = new Thread(c);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
