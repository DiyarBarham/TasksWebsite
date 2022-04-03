package com.training.exercise.employeeservices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.exercise.entities.Employee;
import com.training.exercise.repositories.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepository repo;
	
	@Override
	public List<Employee> ListAll() {
		return (List<Employee>) repo.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return repo.save(employee);
	}

}
