package com.nit.employee.model;

import org.springframework.stereotype.Component;

import com.nit.employee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmployeeResponse {
	private Employee emp;
	private Department dept;
}
