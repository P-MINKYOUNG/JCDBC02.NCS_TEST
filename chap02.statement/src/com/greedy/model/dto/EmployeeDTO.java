package com.greedy.model.dto;

import java.sql.Date;

public class EmployeeDTO {
	
	private String empID;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bonus;
	private String managerId;
	private java.sql.Date hireDate;
	private java.sql.Date entDate;
	private String entYn;
	private String deptTitle;
	
	//생성자
	public EmployeeDTO() {}

	public EmployeeDTO(String empID, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDate,
			String entYn, String deptTitle) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
		this.deptTitle = deptTitle;
	}

	//getters & setters
	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}
	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public java.sql.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.sql.Date hireDate) {
		this.hireDate = hireDate;
	}

	public java.sql.Date getEntDate() {
		return entDate;
	}

	public void setEntDate(java.sql.Date entDate) {
		this.entDate = entDate;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	//toString()
	@Override
	public String toString() {
		return "EmployeeDTO [empID=" + empID + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel=" + salLevel
				+ ", salary=" + salary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", entDate=" + entDate + ", entYn=" + entYn + ", deptTitle = " + deptTitle + "]";
	}
	
	
	/*EMP_ID	VARCHAR2(3 BYTE)
	EMP_NAME	VARCHAR2(20 BYTE)
	EMP_NO		CHAR(14 BYTE)
	EMAIL		VARCHAR2(25 BYTE)
	PHONE		VARCHAR2(12 BYTE)
	DEPT_CODE	CHAR(2 BYTE)
	JOB_CODE	CHAR(2 BYTE)
	SAL_LEVEL	CHAR(2 BYTE)
	SALARY		NUMBER
	BONUS		NUMBER
	MANAGER_ID	VARCHAR2(3 BYTE)
	HIRE_DATE	DATE
	ENT_DATE	DATE
	ENT_YN		CHAR(1 BYTE)*/

}
