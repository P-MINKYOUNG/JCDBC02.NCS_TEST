package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

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

import com.greedy.model.dto.EmployeeDTO;

public class Application7 {

	public static void main(String[] args) {
		
		/*employee-query.xml에서 수행할 구문을 읽어와서 처리하는 방법으로 변경한다.*/
		/*EMPLOYEE 테이블에서 조회할 사원의 이름의 성을 입력 받아 해당 성씨를 가진 사원 정보를 모두 출력한다.*/
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 이름의 성을 입력하세요 : ");
		String empName = sc.nextLine();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO employee = null;
		List<EmployeeDTO> empList = null;
		
		try {
			Properties prop = new Properties();
			prop.loadFromXML(new FileInputStream("src/com/greedy/section02/preparedstatement/employee-query.xml"));
			String query = prop.getProperty("selectEmpByFamilyName2");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empName);
			
			rset = pstmt.executeQuery();
			
			// rset까지 수행이 잘 된다면, 조회한 결과를 담을 리스트를 생성
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
				employee.setDeptTitle(rset.getString("DEPT_TITLE"));
				
				empList.add(employee);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			//생성했던 순서 역순
			close(rset);
			close(pstmt);
			close(conn);
		}
		
		for(EmployeeDTO e : empList) {
			System.out.println(e.toString());
		}

	}

}
