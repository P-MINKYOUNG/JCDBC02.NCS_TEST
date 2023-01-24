package com.greedy.section01.model.dao;

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

import com.greedy.section01.model.dto.CategoryDTO;
import com.greedy.section01.model.dto.MenuDTO;

public class OrderDAO {

	private Properties prop;
	private PreparedStatement pstmt = null;

	public OrderDAO() {

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/order-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 1. 카테고리 전체 조회 */
	public List<CategoryDTO> selectAllCategory(Connection conn) {

		ResultSet rset = null;
		List<CategoryDTO> categoryList = null;

		try {

			String query = prop.getProperty("selectAllCategory");

			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			categoryList = new ArrayList<>();

			while (rset.next()) {
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

	public List<MenuDTO> selectMenuByCategory(Connection conn, int categoryCode) {

		ResultSet rset = null;
		List<MenuDTO> menuList = null;

		try {

			String query = prop.getProperty("selectMenuByCategoryCode");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, categoryCode);

			rset = pstmt.executeQuery();

			menuList = new ArrayList<>();

			while (rset.next()) {
				MenuDTO menuDTO = new MenuDTO();

				menuDTO.setMenuCode(rset.getInt("MENU_CODE"));
				menuDTO.setMenuName(rset.getString("MENU_NAME"));
				menuDTO.setMenuPrice(rset.getInt("MENU_PRICE"));
				menuDTO.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				menuDTO.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

				menuList.add(menuDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return menuList;
	}
}
