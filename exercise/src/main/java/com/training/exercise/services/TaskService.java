package com.training.exercise.services;

import java.util.List;

import com.training.exercise.entities.Project;
import com.training.exercise.entities.Task;

public interface TaskService {
	public List<Task> ListAll();
	public Task save(Task task);
	public Task FindById(int id);
}
