package com.training.exercise.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.training.exercise.dto.ProjectDto;
import com.training.exercise.entities.Project;

@Component
public class ProjectConverter {

	public ProjectDto entityToDto(Project project) {
		ProjectDto dto = new ProjectDto();
		dto.setId(project.getId());
		dto.setName(project.getName());
		dto.setStatus(project.getStatus());
		dto.setEmployee(project.getEmployee());
		return dto;
	}
	public Project dtoToEntity(ProjectDto dto) {
		Project project = new Project();
		project.setId(dto.getId());
		project.setName(dto.getName());
		project.setStatus(dto.getStatus());
		project.setEmployee(dto.getEmployee());
		return project;
	}
	
	public List<ProjectDto> entityToDto(List<Project> projects){
		return projects.stream().map(project -> entityToDto(project)).collect(Collectors.toList());
	}
	
	public List<Project> dtoToEntity(List<ProjectDto> dtos){
		return dtos.stream().map(dto -> dtoToEntity(dto)).collect(Collectors.toList());
	}
}
