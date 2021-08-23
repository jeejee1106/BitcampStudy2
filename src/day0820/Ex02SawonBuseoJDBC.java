package day0820;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02SawonBuseoJDBC {
	static final String ORACLEDRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String OLACLE_LOCAL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public Ex02SawonBuseoJDBC() {
		try {
			Class.forName(ORACLEDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void sawonBuseo() {
		Connection conn = null; //���� oracle sql developer  ������ �����ϱ� ���� ����. �������̽� ����Ʈ
		Statement stmt = null; //SQL ���� �����ϰ� �����ϴ� ����� ��ȯ�ϴ� �� ���Ǵ� ��ü��. �������̽� ����Ʈ
		ResultSet rs = null; //�����ͺ��̽� ��� ������ ��Ÿ���� ������ ���̺�.�Ϲ������� �����ͺ��̽� �������� �����Ͽ� ������. �������̽� ����Ʈ
		String sql = "select buseo, count(buseo) count, round(avg(pay),0) avgpay, max(pay) maxpay, min(pay) minpay from sawon group by buseo";
		
		try {
			conn = DriverManager.getConnection(OLACLE_LOCAL, "angel", "a1234");//����̹��Ŵ����� ���� �ּ�, ���̵�. ����� �޾ƿ�!
			System.out.println("oracle sql developer�� �����!!");
			
			stmt = conn.createStatement(); //conn�� �ִ� SQL���� �޾Ƽ�(createStatement) stmt�� �ְڴ�. stmt�� SQL���� �����Ұ���.
			
			//select�� ResultSet�� �ʿ��ϹǷ� ������ executeQuery
			rs = stmt.executeQuery(sql); //Query�� sql���� �����Ͽ� ResultSet��ü�� rs�� ��ȯ. rs������ ���̺� �����͸� �ְڴ�.(�ִ°� �ؿ� while������)
			//��������� oracle sql developer�� ������ �����͸� �ҷ����� �ڵ忴��.
			//�ؿ��� �ҷ��� �����͸� ����ϴ� �ڵ�!!!!!
			System.out.println("**�μ��� �޿� ��Ȳ**");
			System.out.println("�μ���\t�ο���\t��ձ޿�\t�ְ�޿�\t�����޿�");
			System.out.println("===============================================");
			while(rs.next()) { //rs������ ���̺� ������ ��������!
				//ResultSrt�� '��'�� �������� �а�, �� �̻� ���� ���� ���� �� false�� ��ȯ�Ѵ�.
				String buseo = rs.getString("buseo");
				int count = rs.getInt("count");
				int avgpay = rs.getInt("avgpay");
				int maxpay = rs.getInt("maxpay");
				int minpay = rs.getInt("minpay");
				System.out.println(buseo + "\t" + count + "\t" + avgpay + "\t" + maxpay + "\t" + minpay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public static void main(String[] args) {
		Ex02SawonBuseoJDBC ex = new Ex02SawonBuseoJDBC();
		ex.sawonBuseo();
	}
}
