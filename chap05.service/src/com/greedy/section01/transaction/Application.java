package com.greedy.section01.transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.greedy.common.JDBCTemplate.*;

public class Application {

	public static void main(String[] args) {
		
		Connection conn = getConnection();
		
		/*COMMIT 상태 확인
		 *원래는 자동 커밋 되어 있음*/
		try {
			System.out.println("Auto Commit 확인 : " + conn.getAutoCommit());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		int result1 = 0;
		int result2 = 0;
		
		
		try {
			Properties prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			String query1 = prop.getProperty("insertCategory");
			String query2 = prop.getProperty("insertMenu");
			
			/*TBL_CATEGORY에 1 행 삽입*/
			pstmt1 = conn.prepareStatement(query1);
			pstmt1.setString(1, "트랜잭션T카테고리");
			pstmt1.setInt(2, 1);
			
			result1 = pstmt1.executeUpdate();
			
			/*TBL_MENU에 1 행 삽입*/
			pstmt2 = conn.prepareStatement(query2);
			pstmt2.setString(1, "트랜잭션T메뉴");
			pstmt2.setInt(2, 50000);
			/* TBL_CATEGORY에 존재하지 않는 CATEGORY_CODE를 삽입하려고 하면
			 * 부모키를 찾지 못하는 외래키 제약조건 위반 오류가 발생.*/
			pstmt2.setInt(3, 16);
			pstmt2.setString(4, "N");
			
			result2 = pstmt2.executeUpdate();
			
			System.out.println("result1 : " + result1);
			System.out.println("result2 : " + result2);
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
			
			/*트랜잭션(논리적인 기능 수행 단위) 관리를 위해 2개의 insert가 모두 잘 동작하였는지 판단하여
			 *잘 동작했을 경우 commit, 둘 중 하나라도 동작하지 않았을 경우 rollback을 수행*/
			if(result1 > 0 && result2 > 0) {
				/*매번 try-catch 구문으로 작성하면 코드가 복잡해지므로 메소드 작성해서 호출*/
				//conn.commit();
				commit(conn);
			}else {
				//conn.rollback();
				rollback(conn);
			}
			
			close(conn);
		}
		
	}

}
