package com.greedy.section01.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.greedy.section01.DTO.CategoryDTO;
import com.greedy.section01.DTO.MenuDTO;

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


	/*1. 카테고리 전체 조회*/
	public List<CategoryDTO> selectAllCategory(Connection conn) {
		
		ResultSet rset = null;
		List<CategoryDTO> categoryList = null;
		
		try {
			
			String query = prop.getProperty("selectAllCategory");
			
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			categoryList = new ArrayList<>();
			
			while(rset.next()) {
				CategoryDTO categoryDTO = new CategoryDTO();
				
				categoryDTO.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				categoryDTO.setCategoryName(rset.getString("CATEGORY_NAME"));
				categoryDTO.setRefCategoryCode(rset.getInt("REF_CATEGORY_CODE"));
				
				categoryList.add(categoryDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return categoryList;
	}

	
	/*2. 신규 메뉴 등록*/
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
