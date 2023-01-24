package com.greedy.section01.model.service;

import static com.greedy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.greedy.section01.model.dao.OrderDAO;
import com.greedy.section01.model.dto.CategoryDTO;
import com.greedy.section01.model.dto.MenuDTO;

public class OrderService {

	OrderDAO orderDAO = new OrderDAO();

	public List<CategoryDTO> selectAllCategory() {
		
		/*1. Connection 생성*/
		Connection conn = getConnection();
		
		/*2. DAO의 메소드 호출하여 결과 리턴 받기*/
		List<CategoryDTO> categoryList = orderDAO.selectAllCategory(conn);
		
		/*3. 트랜젝션 관리(SELECT의 경우 commit, rollback 불필요)*/
		/*4. Connection 반납*/
		close(conn);
		
		return categoryList;
	}

	public List<MenuDTO> selectMenuByCategory(int categoryCode) {
		
		/*1. Connection 생성*/
		Connection conn = getConnection();
		
		/*2. DAO의 메소드 호출하여 결과 리턴 받기*/
		List<MenuDTO> menuList = orderDAO.selectMenuByCategory(conn, categoryCode);
		
		
		/*3. 트랜젝션 관리(SELECT의 경우 commit, rollback 불필요)*/
		/*4. Connection 반납*/
		close(conn);
		
		return menuList;
	}

}
