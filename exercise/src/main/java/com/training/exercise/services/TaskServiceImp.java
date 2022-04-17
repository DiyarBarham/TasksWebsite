package com.training.exercise.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.exercise.entities.Department;
import com.training.exercise.entities.Task;
import com.training.exercise.repositories.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

	private TaskRepository repo;
	
	@Override
	public List<Task> ListAll() {
		return (List<Task>) repo.findAll();
	}

	@Override
	public Task save(Task task) {
		return repo.save(task);
	}
	
	@Override
	public Task FindById(int id) {
		Optional<Task> p = repo.findById(id);
		if(p.isPresent()) return p.get();
		return null;
	}

}
