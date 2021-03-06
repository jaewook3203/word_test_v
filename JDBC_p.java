import java.sql.*;
import java.io.*;
import java.util.*;

public class JDBC_p {
	JDBC_p(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("error"+e);
		}
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
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
		System.out.println("1.DB�ܾ��߰�,2.DB�ܾ����");
		int sel = sc.nextInt();
		if(sel == 1) {
			System.out.println("�ܾ�");
			String Qus = sc.next();
			System.out.println("����=");
			String Ans = sc.next();
			try {
				query = "insert into test values(?,?)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Qus);
				pstmt.setString(2, Ans);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println("�߰� �Ϸ�");
			}catch(SQLException e){
				System.out.println("error"+e);
			}
		}
		else if(sel == 2) {
			try {
				stmt = conn.createStatement();
				query = "select * from test";
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					String Qus = rs.getString("Questions");
					String Ans = rs.getString("Answer");
					System.out.println(Qus+" "+Ans);
				}
			}catch(SQLException e) {
				System.out.println("error"+e);
			}
		}
		
	}
}
