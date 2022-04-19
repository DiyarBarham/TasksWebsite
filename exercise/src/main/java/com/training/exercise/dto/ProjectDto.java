package com.training.exercise.dto;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Status;
import com.training.exercise.entities.Task;

import lombok.Data;

@Data
public class ProjectDto {

	private Integer id;
	private String name;
	private Set<Status> status;
	private Employee employee;
	private Set<Task> tasks = new HashSet<>();
	

}
