package com.training.exercise.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.exercise.entities.Department;
import com.training.exercise.entities.Status;
import com.training.exercise.entities.Task;
import com.training.exercise.repositories.StatusRepository;
import com.training.exercise.repositories.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class StatusServiceImp implements StatusService {

	private StatusRepository repo;
	
	@Override
	public List<Status> ListAll() {
		return (List<Status>) repo.findAll();
	}

	@Override
	public Status save(Status status) {
		return repo.save(status);
	}
	
	@Override
	public Status FindById(int id) {
		Optional<Status> p = repo.findById(id);
		if(p.isPresent()) return p.get();
		return null;
	}

}
