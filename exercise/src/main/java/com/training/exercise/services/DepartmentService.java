package com.training.exercise.services;

import java.util.List;

import com.training.exercise.entities.Department;
import com.training.exercise.entities.Project;

public interface DepartmentService {
	public List<Department> ListAll();
	public Department save(Department department);
	public Department FindById(int id);
}
