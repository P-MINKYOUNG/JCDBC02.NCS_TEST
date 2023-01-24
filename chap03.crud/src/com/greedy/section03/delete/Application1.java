package com.greedy.section03.delete;

import static com.greedy.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Application1 {

	public static void main(String[] args) {
		
		/*입력 받은 메뉴 코드에 해당하는 행 삭제*/
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 메뉴 코드를 입력해주세요 : ");
		int menuCode = sc.nextInt();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Properties prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			String query = prop.getProperty("deleteMenu");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, menuCode);
			
			result = pstmt.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		if(result > 0) System.out.println("메뉴 삭제에 성공하셨습니다.");
		else System.out.println("메뉴 삭제에 실패하셨습니다.");
		
	}

}
