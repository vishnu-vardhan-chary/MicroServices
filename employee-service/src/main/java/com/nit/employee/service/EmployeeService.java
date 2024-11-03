package com.nit.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nit.employee.entity.Employee;
import com.nit.employee.exception.EmployeeNotFoundException;
import com.nit.employee.model.Department;
import com.nit.employee.model.EmployeeResponse;
import com.nit.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeResponse employeeResponse;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeResponse getEmployee(Long id) throws EmployeeNotFoundException {
		Optional<Employee> optEmp = employeeRepository.findById(id);
		Employee emp = null;
		if (optEmp.isPresent()) {
			emp = optEmp.get();
			employeeResponse.setEmp(emp);
		}else {
			throw new EmployeeNotFoundException("Employee is not found!!");
		}
		//Get the department object .....
		Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/getDepartment/"+emp.getDeptId(), Department.class);
		employeeResponse.setDept(dept);
		return employeeResponse;
	}
	
	public Employee saveEmployee(Employee emp){
		return employeeRepository.save(emp);
	}
}
