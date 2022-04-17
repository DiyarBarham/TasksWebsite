package com.training.exercise.services;

import java.util.List;

import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Project;

public interface EmployeeService {
	public List<Employee> ListAll();
	public Employee save(Employee employee);
	public Employee FindById(int id);
}
