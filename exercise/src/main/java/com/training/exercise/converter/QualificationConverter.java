package com.training.exercise.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.training.exercise.dto.QualificationDto;
import com.training.exercise.entities.Qualification;

@Component
public class QualificationConverter {
	public QualificationDto entityToDto(Qualification qualification) {
		QualificationDto dto = new QualificationDto();
		dto.setId(qualification.getId());
		dto.setName(qualification.getName());

		return dto;
	}
	public Qualification dtoToEntity(QualificationDto dto) {
		Qualification qualification = new Qualification();
		qualification.setId(dto.getId());
		qualification.setName(dto.getName());

		return qualification;
	}
	
	public List<QualificationDto> entityToDto(List<Qualification> qualifications){
		return qualifications.stream().map(qualification -> entityToDto(qualification)).collect(Collectors.toList());
	}
	
	public List<Qualification> dtoToEntity(List<QualificationDto> dtos){
		return dtos.stream().map(dto -> dtoToEntity(dto)).collect(Collectors.toList());
	}
}
