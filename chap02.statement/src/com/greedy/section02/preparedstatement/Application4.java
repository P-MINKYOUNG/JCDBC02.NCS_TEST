package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application4 {

	public static void main(String[] args) {
		
		System.out.println("사번 입력 받아 해당 사원 조회하기");
		System.out.print("조회하려는 사번을 입력해 주세요 : ");
		
		Scanner sc = new Scanner(System.in);
		String empId = sc.nextLine();
		
		/* 1. Connection 생성 */
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO selectedEmp = null;
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ";
		
		try {
			/* 2. PreparedStatement 생성 */
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empId);
			
			/* 3. executeQuery()로 쿼리문 실행하고 결과를 ResultSet으로 반환 */
			rset = pstmt.executeQuery();
			
			/* 4. ResultSet에 담긴 결과 값을 컬럼 이름을 통해서 꺼내오기 */
			//getString("컬럼명" 혹은 컬럼 번호)
			if(rset.next()) {
				selectedEmp = new EmployeeDTO();
				
				selectedEmp.setEmpID(rset.getString("EMP_ID"));
				selectedEmp.setEmpName(rset.getString("EMP_NAME"));
				selectedEmp.setEmpNo(rset.getString("EMP_NO"));
				selectedEmp.setEmail(rset.getString("EMAIL"));
				selectedEmp.setPhone(rset.getString("PHONE"));
				selectedEmp.setDeptCode(rset.getString("DEPT_CODE"));
				selectedEmp.setJobCode(rset.getString("JOB_CODE"));
				selectedEmp.setSalary(rset.getInt("SALARY"));
				selectedEmp.setBonus(rset.getDouble("BONUS"));
				selectedEmp.setManagerId(rset.getString("MANAGER_ID"));
				selectedEmp.setHireDate(rset.getDate("HIRE_DATE"));
				selectedEmp.setEntDate(rset.getDate("ENT_DATE"));
				selectedEmp.setEntYn(rset.getString("ENT_YN"));								
				
			}else {
				System.out.println("해당 사번으로 조회되는 사원이 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(conn);
			close(pstmt);
		}
		
		System.out.println("selectedEmp : " + selectedEmp.toString());

	}

}
