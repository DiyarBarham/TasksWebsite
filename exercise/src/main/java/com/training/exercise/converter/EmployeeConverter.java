package com.training.exercise.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.training.exercise.dto.EmployeeDto;
import com.training.exercise.entities.Employee;

@Component
public class EmployeeConverter {

	public EmployeeDto entityToDto(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(employee.getId());
		dto.setFName(employee.getFName());
		dto.setLName(employee.getLName());
		dto.setTasks(employee.getTasks());
		dto.setDepartment(employee.getDepartment());
		dto.setQualifications(employee.getQualifications());
		return dto;
	}
	public Employee dtoToEntity(EmployeeDto dto) {
		Employee employee = new Employee();
		employee.setId(dto.getId());
		employee.setFName(dto.getFName());
		employee.setLName(dto.getLName());
		employee.setTasks(dto.getTasks());
		employee.setDepartment(dto.getDepartment());
		employee.setQualifications(dto.getQualifications());
		return employee;
	}
	
	public List<EmployeeDto> entityToDto(List<Employee> employees){
		return employees.stream().map(employee -> entityToDto(employee)).collect(Collectors.toList());
	}
	
	public List<Employee> dtoToEntity(List<EmployeeDto> dtos){
		return dtos.stream().map(dto -> dtoToEntity(dto)).collect(Collectors.toList());
	}
}
