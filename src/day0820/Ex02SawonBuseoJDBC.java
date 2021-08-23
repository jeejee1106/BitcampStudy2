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
		Connection conn = null; //로컬 oracle sql developer  계정과 연결하기 위해 선언. 인터페이스 임포트
		Statement stmt = null; //SQL 문을 실행하고 생성하는 결과를 반환하는 데 사용되는 개체임. 인터페이스 임포트
		ResultSet rs = null; //데이터베이스 결과 집합을 나타내는 데이터 테이블.일반적으로 데이터베이스 쿼리문을 실행하여 생성됨. 인터페이스 임포트
		String sql = "select buseo, count(buseo) count, round(avg(pay),0) avgpay, max(pay) maxpay, min(pay) minpay from sawon group by buseo";
		
		try {
			conn = DriverManager.getConnection(OLACLE_LOCAL, "angel", "a1234");//드라이버매니저를 통해 주소, 아이디. 비번을 받아옴!
			System.out.println("oracle sql developer와 연결됨!!");
			
			stmt = conn.createStatement(); //conn에 있는 SQL문을 받아서(createStatement) stmt에 넣겠다. stmt는 SQL문을 실행할거임.
			
			//select는 ResultSet이 필요하므로 무조건 executeQuery
			rs = stmt.executeQuery(sql); //Query로 sql문을 실행하여 ResultSet개체인 rs를 반환. rs데이터 테이블에 데이터를 넣겠다.(넣는건 밑에 while문으로)
			//여기까지가 oracle sql developer를 연동해 데이터를 불러오는 코드였음.
			//밑에는 불러온 데이터를 출력하는 코드!!!!!
			System.out.println("**부서별 급여 현황**");
			System.out.println("부서명\t인원수\t평균급여\t최고급여\t최저급여");
			System.out.println("===============================================");
			while(rs.next()) { //rs데이터 테이블에 데이터 넣을거임!
				//ResultSrt은 '행'을 한줄한줄 읽고, 더 이상 읽을 행이 없을 땐 false를 반환한다.
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
