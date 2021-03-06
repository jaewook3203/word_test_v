import java.sql.*;
import java.util.*;

public class JDBC_cnt_pr {
	String rs_cnt;
	JDBC_cnt_pr(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("eroor"+e);
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/word?serverTimezone=UTC";
		String id = "root";
		String pass = "1234";
		String query = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
		}catch(SQLException e) {
			System.out.println("error"+e);
		}
		try {
			stmt = conn.createStatement();
			query = "select * from test"; 
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				this.rs_cnt = rs.getString(2);
				System.out.println(rs_cnt);
			}
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			System.out.println("¿À·ù:error"+e);
		}
	}
}
