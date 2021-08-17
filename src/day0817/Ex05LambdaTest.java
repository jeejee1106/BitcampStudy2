package day0817;
// 람다식 코드 짜는 법 맛보기!!!!! //깃이 또 말썽이다 하....//언제쯤 성공할까//토큰을 어떻게 쓰라는거야//몇시간째니..//아직도 하는 중..
@FunctionalInterface
interface Orange { //public void show(); ---> 람다표현식으로 구현할 경우 추상메서드는 한개만 넣을 수 있다.
	public void write();
}

public class Ex05LambdaTest {
	
	public void abstMethod1() {
		Orange or = new Orange() {

			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("나는 익명 내부 오렌지다!");
			}
		};
		or.write();
	}
	
	//람다식으로 오버라이드하기
	public void abstMethod2() {
		Orange or = ()->System.out.println("나는 람다식 오렌지다.");
		or.write();
		
		System.out.println("안에 여러줄의 코드일 경우");
		Orange or2 = ()->{
			System.out.println("중괄호로 묶어서");
			System.out.println("여러줄을 출력할 수 있다.");
		};
		or2.write();
	}

	public static void main(String[] args) {
		Ex05LambdaTest ex = new Ex05LambdaTest();
		ex.abstMethod1();
		System.out.println("===================");
		ex.abstMethod2();
	}

}
