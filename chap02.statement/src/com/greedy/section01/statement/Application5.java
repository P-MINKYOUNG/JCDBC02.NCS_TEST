package com.greedy.section01.statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.greedy.common.JDBCTemplate.*;
import com.greedy.model.dto.EmployeeDTO;

public class Application5 {

	public static void main(String[] args) {
		
		String query = "SELECT * FROM EMPLOYEE";
		
		/*한 행의 정보를 담을 EmployeeDTO*/
		EmployeeDTO row = null;
		
		/*여러 DTO를 하나의 인스턴스로 묶기 위한 List*/
		List<EmployeeDTO> empList = null;
		
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
		
			empList = new ArrayList<>();
			
			while(rset.next()) {
				row = new EmployeeDTO();
				
				row.setEmpID(rset.getString("EMP_ID"));
				row.setEmpName(rset.getString("EMP_NAME"));
				row.setEmpNo(rset.getString("EMP_NO"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setDeptCode(rset.getString("DEPT_CODE"));
				row.setJobCode(rset.getString("JOB_CODE"));
				row.setSalary(rset.getInt("SALARY"));
				row.setBonus(rset.getDouble("BONUS"));
				row.setManagerId(rset.getString("MANAGER_ID"));
				row.setHireDate(rset.getDate("HIRE_DATE"));
				row.setEntDate(rset.getDate("ENT_DATE"));
				row.setEntYn(rset.getString("ENT_YN"));	
				
				empList.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(stmt);
			close(rset);
		}
		
		for(EmployeeDTO arr : empList) {
			System.out.println(arr);
		}
		
		
		

	}

}
