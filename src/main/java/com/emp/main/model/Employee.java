package com.emp.main.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long empId;
	@NotNull
	private String empName;	
	@NotNull
	private BigDecimal salary;
	private Long departmentNumber;
	
	
	public Long getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(Long departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	
	public Long getEmpId() {
		return empId;
	}
	
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() { 	 
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	

}
