package com.emp.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.main.model.Employee;

@Repository
public interface EmployeeServiceRepo extends JpaRepository<Employee, Long> {

	Employee findByEmpName(String name);

	Optional<Employee> findByEmpId(Long empId);

}
