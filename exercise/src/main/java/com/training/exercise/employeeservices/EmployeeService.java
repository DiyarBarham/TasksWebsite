package com.training.exercise.employeeservices;

import java.util.List;

import com.training.exercise.entities.Employee;

public interface EmployeeService {
	public List<Employee> ListAll();
	public Employee save(Employee employee);
}
