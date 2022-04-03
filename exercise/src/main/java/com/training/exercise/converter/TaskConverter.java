package com.training.exercise.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.training.exercise.dto.TaskDto;
import com.training.exercise.entities.Task;

@Component
public class TaskConverter {

	public TaskDto entityToDto(Task task) {
		TaskDto dto = new TaskDto();
		dto.setId(task.getId());
		dto.setTitle(task.getTitle());
		dto.setDescription(task.getDescription());
		dto.setStatus(task.getStatus());
		dto.setEmployees(task.getEmployees());
		dto.setQualifications(task.getQualifications());
		dto.setTask(task.getTask());
		dto.setProject(task.getProject());
		return dto;
	}
	public Task dtoToEntity(TaskDto dto) {
		Task task = new Task();
		task.setId(dto.getId());
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.getStatus());
		task.setEmployees(dto.getEmployees());
		task.setQualifications(dto.getQualifications());
		task.setTask(dto.getTask());
		task.setProject(dto.getProject());
		return task;
	}
	
	public List<TaskDto> entityToDto(List<Task> tasks){
		return tasks.stream().map(task -> entityToDto(task)).collect(Collectors.toList());
	}
	
	public List<Task> dtoToEntity(List<TaskDto> dtos){
		return dtos.stream().map(dto -> dtoToEntity(dto)).collect(Collectors.toList());
	}
}
