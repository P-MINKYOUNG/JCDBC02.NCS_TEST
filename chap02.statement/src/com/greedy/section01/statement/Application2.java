package com.greedy.section01.statement;

import java.sql.*;
import static com.greedy.common.JDBCTemplate.*;

public class Application2 {

	public static void main(String[] args) {
		
		/* 1. Connection 생성 */
		Connection conn = getConnection();
		
		Statement stmt = null;
		ResultSet rset = null;
		try {
			/* 2. Statement 생성 */
			stmt = conn.createStatement();
			
			String empId = "213";
			String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
			System.out.println(query);
			
			/* 3. executeQuery()로 쿼리문 실행하고 결과를 ResultSet으로 반환 */
			rset = stmt.executeQuery(query);
			
			/* 4. ResultSet에 담긴 결과 값을 컬럼 이름을 통해서 꺼내오기 */
			//getString("컬럼명" 혹은 컬럼 번호)
			if(rset.next()) {
				System.out.println(rset.getString(1) + ", " + rset.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(conn);
			close(stmt);
		}

	}

}
