package day0820;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01SawonJDBC {
	static final String ORACLEDRIVER = "oracle.jdbc.driver.OracleDriver";
//	static final String ORACLE_CLOUD = "jdbc:oracle:thin:@bitcamp_high?TNS_ADMIN=D:/bitjava0719/OracleCloud"; //����Ŭ Ŭ���� ����!!!!!!!!!!!!!!!!!!!
	static final String ORACLE_CLOUD = "jdbc:oracle:thin:@bitcamp_high?TNS_ADMIN=C:/Users/PC/Desktop/study/OracleCloud"; //����Ŭ Ŭ���� ����!!!!!!!!!!!!!!!!!!!
	static final String OLACLE_LOCAL = "jdbc:oracle:thin:@localhost:1521:xe"; //���÷� ����Ŭ ������ ��!!!!!!!!!!	
	
	
	
	//����̹��� �ѹ��� �����ϹǷ� �ַ� �����ڿ��� �ڵ带 �߰��Ѵ�.
	public Ex01SawonJDBC() {
		//���ڿ��� Ŭ������ Ŭ�����ν��Ͻ��� ��ȯ
		try {
			Class.forName(ORACLEDRIVER);
			System.out.println("����Ŭ ����̹� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹� ����:" + e.getMessage()); //Ŭ������ ����ִ� �ڷ������� ���� ��
		}
	}
	
	//����Ŭ Ŭ���忡 19c �߰��� ������� �� �޼��� �߰�
	public void connectCloudSawon() { //����� ���̵�� ��� ��������!
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; //select sql���� ResultSet�� ���� �����͸� ������ �� �ִ�.
		String sql = "select * from sawon order by num";
		
		try {
			conn = DriverManager.getConnection(ORACLE_CLOUD, "admin", "Moon2549466**");
			System.out.println("Ŭ������ ����Ŭ ������ ���� ����");
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			//�������� �����;� �� ��� while������ �����´�.
			//rs.next() : ���� �����ͷ� �̵��ϸ鼭 true��ȯ, �� �̻� �����Ͱ� ������ false��ȯ
			while(rs.next()) {
				//DB�κ��� ������ ��������
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");
				System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("���� : " + e.getMessage());
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//�ڱ� ��ǻ�� ������ ����Ŭ �����Ϸ��� �޼���!!!!!!!!!!
	public void connectLocalFood() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select f.num, j.name, f.food, f.price, j.addr from food f, jumun j where f.num = j.num";
		
		try {
			conn = DriverManager.getConnection(OLACLE_LOCAL, "angel", "a1234");
			System.out.println("���� ����Ŭ angel���� ���� ����");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("��� �ֹ� �� ����Ʈ");
			System.out.println("�ֹ���ȣ\t�ֹ���\t���ĸ�\t����\t�ּ�");
			System.out.println("====================================");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String addr = rs.getString("addr");
				System.out.println(num + "\t" + name + "\t" + food + "\t" + price + "\t" + addr);
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("���� ����Ŭ angel���� ���� ����");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex01SawonJDBC ex = new Ex01SawonJDBC();
		ex.connectCloudSawon();
		System.out.println("==============================================");
		ex.connectLocalFood();
	}

}
