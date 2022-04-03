package com.training.exercise.taskservices;

import java.util.List;
import com.training.exercise.entities.Task;

public interface TaskService {
	public List<Task> ListAll();
	public Task save(Task task);
}
