package com.nit.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.employee.entity.Employee;
import com.nit.employee.exception.EmployeeNotFoundException;
import com.nit.employee.model.EmployeeResponse;
import com.nit.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("getEmployee/{id}")
	public EmployeeResponse getEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("saveEmployee")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
}
