import java.sql.*;
import java.util.*;
import java.io.*;

public class JDBC_cnt_pr {
	int rs_cnt;
	int num;
	int i=0;
	String program;
	String stop = "//stop";
	String help = "//help";
	Scanner sc = new Scanner(System.in);
	String Answer_scan;
	JDBC_cnt_pr(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("eroor"+e);
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
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
			query = "select count(*) as cnt from test"; 
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				this.rs_cnt = rs.getInt(1);
			}
		}catch(SQLException e) {
			System.out.println("오류:error"+e);
		}
		this.program = sc.next();
		while(this.program.equals("//start")) {
			String [] Questions = new String[rs_cnt];
			String [] Answer = new String[rs_cnt];
			try {
				stmt = conn.createStatement();
				query = "select * from test";
				rs2 = stmt.executeQuery(query);
				while(rs2.next()) {
					Questions[i] = rs2.getString("Questions");
					Answer[i] = rs2.getString("Answer");
					i++;
					if(i>=rs_cnt) {
						i = 0;
						break;
					}
				}
				
			}catch(SQLException e) {
				System.out.println("error"+e);
			}
			num = (int)((Math.random()*this.rs_cnt));
			System.out.println("------------");
			System.out.println(Questions[num]);
			System.out.println("------------");
			Answer_scan = sc.next();
			if(Answer[num].equals(Answer_scan)) {
				System.out.println("정답");
			}else if(program.equals("//stop")) {
				System.out.println("끝냄");
				break;
			}else {
				System.out.println("오답"+Answer[num]);
			}
		}
		
		
	}
}
