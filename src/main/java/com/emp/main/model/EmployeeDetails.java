package com.emp.main.model;

import java.math.BigDecimal;

public class EmployeeDetails {
	
	private Long empId;
	private String employeeName;
	private String departName;
	private Long departmentNumber;
	private BigDecimal salary;
	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", employeeName=" + employeeName + ", departName=" + departName
				+ ", departmentNumber=" + departmentNumber + ", salary=" + salary + "]";
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public Long getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(Long departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public EmployeeDetails(Long empId, String employeeName, String departName, Long departmentNumber, BigDecimal salary) {
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.departName = departName;
		this.departmentNumber = departmentNumber;
		this.salary = salary;
	};
	
	public EmployeeDetails() {
		
	}
	

}
