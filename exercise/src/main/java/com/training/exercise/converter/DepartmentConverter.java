package com.training.exercise.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.training.exercise.dto.DepartmentDto;
import com.training.exercise.entities.Department;

@Component
public class DepartmentConverter {

	public DepartmentDto entityToDto(Department department) {
		DepartmentDto dto = new DepartmentDto();
		dto.setId(department.getId());
		dto.setName(department.getName());
		return dto;
	}
	public Department dtoToEntity(DepartmentDto dto) {
		Department department = new Department();
		department.setId(dto.getId());
		department.setName(dto.getName());
		return department;
	}
	
	public List<DepartmentDto> entityToDto(List<Department> departments){
		return departments.stream().map(department -> entityToDto(department)).collect(Collectors.toList());
	}
	
	public List<Department> dtoToEntity(List<DepartmentDto> dtos){
		return dtos.stream().map(dto -> dtoToEntity(dto)).collect(Collectors.toList());
	}
}
