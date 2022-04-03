package com.training.exercise.dto;


import java.util.Set;

import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Status;
import lombok.Data;

@Data
public class ProjectDto {

	private Integer id;
	private String name;
	private Set<Status> status;
	private Employee employee;
}
