package com.training.exercise.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
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

}
