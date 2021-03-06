import java.util.Scanner;
import java.sql.*;
import java.io.*;
import java.util.*;

public class word {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.DB관리,2.단어장");
		int sel = scan.nextInt();
		if(sel == 1) {
			JDBC_p Jp = new JDBC_p();
		}
		else if(sel == 2) {
			System.out.println("1.DB단어 사용2.직접써서 사용");
			System.out.println("시작 => //start");
			int dis = scan.nextInt();
			if(dis == 1) {
				JDBC_cnt_pr JCP = new JDBC_cnt_pr();
			}
			else if(dis == 2) {
				int cnt=0;
				int num;
				int add_cnt=0;
				int a[] = new int[cnt];
				String start = "//start";
				String stop = "//stop";
				String Answer_scan ;
				System.out.println("단어 개수를 입력하세요");
				cnt = scan.nextInt();
				String[] Questions = new String[cnt];
				String[] Answer = new String[cnt];
				for(int i=0;i<Questions.length;i++) {
					System.out.println("단어를 입려하세요");
					Questions[i] = scan.next();
					System.out.println("정답을 입력하세요");
					Answer[i] = scan.next();
				}
				while(start.equals("//start")) {
					num = (int) ((Math.random()*cnt));
					System.out.println("-------------");
					System.out.println(Questions[num]);
					System.out.println("-------------");
					Answer_scan = scan.next();
					if(Answer[num].equals(Answer_scan)) {
						System.out.println("정답");
					}
					else if(stop.equals(Answer_scan)) {
						System.out.println("끝냄");
						break;
					}
					else {
						System.out.println("오답"+Answer[num]);
					}
				}
	
			}
		}
	}

}

