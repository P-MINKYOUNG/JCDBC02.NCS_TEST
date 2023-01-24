package com.greedy.section02.service.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.greedy.section02.service.model.dto.CategoryDTO;
import com.greedy.section02.service.model.dto.MenuDTO;

import static com.greedy.common.JDBCTemplate.close;

/* DAO(Data Access Object) : 데이터베이스 접근용 객체
 *CRUD 연산을 담당하는 메소드들의 집합으로 이루어진 클래스*/
public class MenuDAO {

	private Properties prop;
	private PreparedStatement pstmt = null;

	public MenuDAO() {

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 1. 신규 카테고리 등록 */
	public int insertNewCategory(Connection conn, CategoryDTO newCategory) {
		int result = 0;

		try {
			String query = prop.getProperty("insertCategory");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newCategory.getCategoryName());
			pstmt.setObject(2, newCategory.getRefCategoryCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/* 2. 마지막 카테고리 코드 조회 */
	public int selectLastCategoryCode(Connection conn) {

		ResultSet rset = null;
		int newCategoryCode = 0;

		try {

			String query = prop.getProperty("getCurrentSequence");

			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next())
				newCategoryCode = rset.getInt("CURRVAL");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return newCategoryCode;
	}

	/* 3. 신규 메뉴 등록 */
	public int insertNewMenu(Connection conn, MenuDTO newMenu) {

		int result = 0;

		try {

			String query = prop.getProperty("insertMenu");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newMenu.getMenuName());
			pstmt.setInt(2, newMenu.getMenuPrice());
			pstmt.setInt(3, newMenu.getCategoryCode());
			pstmt.setString(4, newMenu.getOrderableStatus());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
}
