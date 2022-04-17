package com.training.exercise.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.exercise.entities.Department;
import com.training.exercise.repositories.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

	private DepartmentRepository repo;
	
	@Override
	public List<Department> ListAll() {
		return (List<Department>) repo.findAll();
	}

	@Override
	public Department save(Department department) {
		return repo.save(department);
	}

}
