package com.training.exercise.services;

import java.util.List;

import com.training.exercise.entities.Department;

public interface DepartmentService {
	public List<Department> ListAll();
	public Department save(Department department);
}
