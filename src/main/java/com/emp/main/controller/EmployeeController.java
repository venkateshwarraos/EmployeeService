package com.emp.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.main.model.Employee;
import com.emp.main.model.EmployeeDetails;
import com.emp.main.repository.DepartmentService;
import com.emp.main.repository.EmployeeServiceRepo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/emp")
public class EmployeeController {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	
	@Autowired
	private EmployeeServiceRepo empServiceRepo;
	
	@Autowired
	private DepartmentService departmentService;
	
	@ApiOperation(value="to display employee and department details",response=EmployeeDetails.class)
	@GetMapping(value="/employees")
	@ResponseBody
	public List<EmployeeDetails> getEmployeeList()  {	
		
		List<Employee> dataList = null;
		List<EmployeeDetails> employeeList = new  ArrayList<EmployeeDetails>();
		EmployeeDetails  employeeDetails = null;
		dataList = empServiceRepo.findAll();	
		for(Employee employee:dataList) {			
			employeeDetails = getEmployeeDetails(employee);			
			employeeList.add(employeeDetails);
		}
		
		
		
		return employeeList;		
	}
	
	@ApiOperation(value="To dispaly emplyee with his department details",response=EmployeeDetails.class)
	@GetMapping(value="/employeedata")
	@ResponseBody
	public List<EmployeeDetails> getEmployeeData() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		EmployeeDetails  employeeDetails = null;
		List<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();
		
		List<Employee> dataList= empServiceRepo.findAll();
		for(Employee employee:dataList) {			
			employeeDetails = getEmployeeDetails(employee);			
			employeeList.add(employeeDetails);
		}
		return employeeList;
	}
	
	private EmployeeDetails getEmployeeDetails(Employee employee) {
		EmployeeDetails  employeeDetails = new EmployeeDetails();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap = (Map<String, Object>) departmentService.getDepartmentDetails(employee.getDepartmentNumber());
		employeeDetails.setEmpId(employee.getEmpId());
		employeeDetails.setEmployeeName(employee.getEmpName());
		employeeDetails.setSalary(employee.getSalary());
		employeeDetails.setDepartmentNumber(employee.getDepartmentNumber());
		employeeDetails.setDepartName((String) dataMap.get("departmentName"));
		
		return employeeDetails;
	}
	
	@ApiOperation(value="To get employee details based on id ", response=EmployeeDetails.class)
	@GetMapping(value="/employee/{id}")
	@ResponseBody
	public EmployeeDetails findById(@PathVariable final Long id)  {		
		Optional<Employee> employeeOptional =  empServiceRepo.findByEmpId(id);
		return 	getEmployeeDetails(employeeOptional.get());
	}
	
	@ApiOperation(value="To insert  employee details",response=Employee.class)
	@PostMapping(value="/employee")
	@ResponseBody
	public Optional<Employee> insertEmployeeRecord(@RequestBody  Employee employee)  {
		
		empServiceRepo.save(employee);
		return empServiceRepo.findById(employee.getEmpId());
	}
	
	
	@ApiOperation(value="To delete employee record",response=String.class)
	@DeleteMapping(value="/employee/{id}")
	@ResponseBody
	public String deleteEmployee(@PathVariable long id)  {
		empServiceRepo.deleteById(id);
		return "employee with "+id+"  deleted ";
	}
	
	
	@ApiOperation(value="To update employee details",response=Employee.class)
	@PutMapping(value="/employee")
	@ResponseBody
	public Employee  updateEmployee(@RequestBody  Employee employee) throws Exception  {
		Optional<Employee> employeeOptional =  empServiceRepo.findByEmpId(employee.getEmpId());
		if(employeeOptional.isPresent()) {
			if(employeeOptional.get().getEmpId().equals(employee.getEmpId())) {
				employeeOptional.get().setEmpName(employee.getEmpName());
				employeeOptional.get().setSalary(employee.getSalary());
				employeeOptional.get().setDepartmentNumber(employee.getDepartmentNumber());
				empServiceRepo.save(employeeOptional.get());
				return empServiceRepo.findById(employee.getEmpId()).get();
			} 
			
		}
		return new Employee();
	}
	
	
	
}
