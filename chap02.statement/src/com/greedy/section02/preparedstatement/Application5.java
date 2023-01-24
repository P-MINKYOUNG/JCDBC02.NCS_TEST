package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application5 {

	public static void main(String[] args) {
		
		/*EMPLOYEE 테이블에서 조회할 사원의 이름의 성을 입력 받아 해당 성씨를 가진 사원 정보를 모두 출력한다.*/
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 이름의 성을 입력하세요 : ");
		String empName = sc.nextLine();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO employee = null;
		List<EmployeeDTO> empList = null;
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE ? || '%' ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empName);
			
			rset = pstmt.executeQuery();
			
			// rset까지 수행이 잘 된다면, 조회한 결과를 담을 리스트를 생성
			// rset에 수행한 쿼리문을 담기 전까지 오류가 생긴다면 오류가 catch로 넘어가서 while문 이후로 구문 실행이 안됨
			// 그 후, 만약 catch구문 이후 어떠한 구문을 실행할 경우(EX : if(empList != null)) 
			// List에 담긴 내용이 없으므로, null이 되고, 그것에 대한 오류를 쉽게 알아낼 수 있도록 하기 위해 rset에 값을 넣은 이후 ArrayList 인스턴스 생성
			empList = new ArrayList<>();
			
			while(rset.next()) {
				employee = new EmployeeDTO();
				
				employee.setEmpID(rset.getString("EMP_ID"));
				employee.setEmpName(rset.getString("EMP_NAME"));
				employee.setEmpNo(rset.getString("EMP_NO"));
				employee.setEmail(rset.getString("EMAIL"));
				employee.setPhone(rset.getString("PHONE"));
				employee.setDeptCode(rset.getString("DEPT_CODE"));
				employee.setJobCode(rset.getString("JOB_CODE"));
				employee.setSalary(rset.getInt("SALARY"));
				employee.setBonus(rset.getDouble("BONUS"));
				employee.setManagerId(rset.getString("MANAGER_ID"));
				employee.setHireDate(rset.getDate("HIRE_DATE"));
				employee.setEntDate(rset.getDate("ENT_DATE"));
				employee.setEntYn(rset.getString("ENT_YN"));
				
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//생성했던 순서 역순
			close(rset);
			close(pstmt);
			close(conn);
		}
		
		for(EmployeeDTO e : empList) {
			System.out.println(e);
		}

	}

}
