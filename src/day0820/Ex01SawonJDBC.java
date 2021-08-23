package day0820;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01SawonJDBC {
	static final String ORACLEDRIVER = "oracle.jdbc.driver.OracleDriver";
//	static final String ORACLE_CLOUD = "jdbc:oracle:thin:@bitcamp_high?TNS_ADMIN=D:/bitjava0719/OracleCloud"; //오라클 클라우드 쓸때!!!!!!!!!!!!!!!!!!!
	static final String ORACLE_CLOUD = "jdbc:oracle:thin:@bitcamp_high?TNS_ADMIN=C:/Users/PC/Desktop/study/OracleCloud"; //오라클 클라우드 쓸때!!!!!!!!!!!!!!!!!!!
	static final String OLACLE_LOCAL = "jdbc:oracle:thin:@localhost:1521:xe"; //로컬로 오라클 연결할 때!!!!!!!!!!	
	
	
	
	//드라이버는 한번만 실행하므로 주로 생성자에서 코드를 추가한다.
	public Ex01SawonJDBC() {
		//문자열인 클래스를 클래스인스턴스로 변환
		try {
			Class.forName(ORACLEDRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패:" + e.getMessage()); //클래스가 들어있는 자료파일이 없는 것
		}
	}
	
	//오라클 클라우드에 19c 추가한 사람들은 이 메서드 추가
	public void connectCloudSawon() { //강사님 아이디랑 비번 빌린거임!
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; //select sql문은 ResultSet을 얻어야 데이터를 가져올 수 있다.
		String sql = "select * from sawon order by num";
		
		try {
			conn = DriverManager.getConnection(ORACLE_CLOUD, "admin", "Moon2549466**");
			System.out.println("클라우드의 오라클 서버에 연결 성공");
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			//여러줄을 가져와야 할 경우 while문으로 가져온다.
			//rs.next() : 다음 데이터로 이동하면서 true반환, 더 이상 데이터가 없으면 false반환
			while(rs.next()) {
				//DB로부터 데이터 가져오기
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");
				System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("실패 : " + e.getMessage());
			
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
	
	
	//자기 컴퓨터 로컬의 오라클 연결하려는 메서드!!!!!!!!!!
	public void connectLocalFood() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select f.num, j.name, f.food, f.price, j.addr from food f, jumun j where f.num = j.num";
		
		try {
			conn = DriverManager.getConnection(OLACLE_LOCAL, "angel", "a1234");
			System.out.println("로컬 오라클 angel계정 연결 성공");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("배민 주문 고객 리스트");
			System.out.println("주문번호\t주문자\t음식명\t가격\t주소");
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
			System.out.println("로컬 오라클 angel계정 연결 실패");
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
