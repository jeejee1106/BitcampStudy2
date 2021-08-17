package day0813;
//Thread를 상속받아서 Ex01Thread_extends 클래스가 하나의 쓰레드가 되었다!!
public class Ex01Thread_extends extends Thread {
	String name;
	int num;
	
	public Ex01Thread_extends(String name, int num) {
		this.name=name;
		this.num=num;
	}
	
	@Override
	public void run() {
		super.run();
		
		for(int i = 1; i<300; i++) {
			System.out.println(name + "쓰레드 차례 =>" + i);
		}
	}
	
	public static void main(String[] args) {
		
		Ex01Thread_extends t1 = new Ex01Thread_extends("1번", 300);		
		Ex01Thread_extends t2 = new Ex01Thread_extends("2번", 300);		
		Ex01Thread_extends t3 = new Ex01Thread_extends("3번", 300);  //쓰레드 총 3개 생성했음
 
		t1.start();
		t2.start();
		t3.start();
		
		//멀티 쓰레드는 호출순서에 따라 출력되지 않는다. OS스케줄러에 의해 출력시간과 순서가 결정된다.
		
	}

}
