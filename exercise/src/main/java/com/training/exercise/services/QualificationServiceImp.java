package com.training.exercise.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.exercise.entities.Department;
import com.training.exercise.entities.Qualification;
import com.training.exercise.repositories.QualificationRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class QualificationServiceImp implements QualificationService {

	private QualificationRepository repo;
	
	@Override
	public List<Qualification> ListAll() {
		return (List<Qualification>) repo.findAll();
	}

	@Override
	public Qualification save(Qualification qualification) {
		return repo.save(qualification);
	}
	
	@Override
	public Qualification FindById(int id) {
		Optional<Qualification> p = repo.findById(id);
		if(p.isPresent()) return p.get();
		return null;
	}

}
