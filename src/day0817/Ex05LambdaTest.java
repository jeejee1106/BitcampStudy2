package day0817;
// ���ٽ� �ڵ� ¥�� �� ������!!!!! //���� �� �����̴� ��....//������ �����ұ�//��ū�� ��� ����°ž�//��ð�°��..//������ �ϴ� ��..
@FunctionalInterface
interface Orange { //public void show(); ---> ����ǥ�������� ������ ��� �߻�޼���� �Ѱ��� ���� �� �ִ�.
	public void write();
}

public class Ex05LambdaTest {
	
	public void abstMethod1() {
		Orange or = new Orange() {

			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("���� �͸� ���� ��������!");
			}
		};
		or.write();
	}
	
	//���ٽ����� �������̵��ϱ�
	public void abstMethod2() {
		Orange or = ()->System.out.println("���� ���ٽ� ��������.");
		or.write();
		
		System.out.println("�ȿ� �������� �ڵ��� ���");
		Orange or2 = ()->{
			System.out.println("�߰�ȣ�� ���");
			System.out.println("�������� ����� �� �ִ�.");
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
