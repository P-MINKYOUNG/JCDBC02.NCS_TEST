package com.greedy.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application2 {

	public static void main(String[] args) {
		
		/* 변수 이용해서 작성한 문자열이 어떤 의미인지 알 수 있도록 코드를 개선한다. */
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##EMPLOYEE";
		String pwd = "EMPLOYEE";
			
		/*DB 접속을 위한 Connection 인스턴스 생성
		 *나중에 finally 블럭에서 사용하기 위해 try 블럭 밖에 미리 변수를 선언함*/
		Connection conn = null;
		
		try {
			/*1. 사용할 드라이버 등록
			 *JRE System Library에 없기 때문에 따로 오라클 드라이버를 설치해준다*/
			Class.forName(driver);
			
			/*2. DriverManager를 이용해 Connection 객체 생성*/
			//jdbc:oracle:thin:@ip주소:포트번호:버전정보
			conn = DriverManager.getConnection(url,user,pwd);
			
			System.out.println(conn);
			
		} catch (ClassNotFoundException e) {
			// 드라이버 클래스명에 오타가 있거나 라이브러리가 추가 되지 않았을 경우 해당 클래스를 찾지 못했다는 exception 발생 가능
			e.printStackTrace();
		} catch (SQLException e) {
			/* 주소값 / 계정명 / 비밀번호 등이 올바르게 입력되지 않아 연결 불가능할 경우 exception 발생 */
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
