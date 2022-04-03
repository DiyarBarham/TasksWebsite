package com.training.exercise.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.training.exercise.entities.Department;
import com.training.exercise.entities.Qualification;
import com.training.exercise.entities.Task;

import lombok.Data;

@Data
public class EmployeeDto {

	private Integer id;
	private String fName;
	private String lName;
	private List<Task> tasks;
	private Set<Qualification> qualifications = new HashSet<>();
	private Department department;
}
