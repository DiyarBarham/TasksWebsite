package com.training.exercise.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.exercise.entities.Department;
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
	
	@Override
	public Employee FindById(int id) {
		Optional<Employee> p = repo.findById(id);
		if(p.isPresent()) return p.get();
		return null;
	}
	
	@Override
	public List<Employee> ListAllFree() {
		List<Employee> list = new ArrayList<Employee>();
		for(Employee emp : repo.findAll()) {
			if(emp.getDepartment() == null) {
				list.add(emp);
			}
		}
		return list;
	} 

}
