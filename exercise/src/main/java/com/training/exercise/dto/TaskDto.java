package com.training.exercise.dto;

import java.util.HashSet;
import java.util.Set;

import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Project;
import com.training.exercise.entities.Qualification;
import com.training.exercise.entities.Status;
import com.training.exercise.entities.Task;

import lombok.Data;

@Data
public class TaskDto {

	private Integer id;
	private String title;
	private String description;
	private Set<Status> status;
	private Set<Employee> employees = new HashSet<>();
	private Set<Qualification> qualifications = new HashSet<>();
	private Task task;
	private Project project;
}
