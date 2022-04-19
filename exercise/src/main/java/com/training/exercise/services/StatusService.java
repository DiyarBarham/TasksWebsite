package com.training.exercise.services;

import java.util.List;

import com.training.exercise.entities.Project;
import com.training.exercise.entities.Status;
import com.training.exercise.entities.Task;

public interface StatusService {
	public List<Status> ListAll();
	public Status save(Status status);
	public Status FindById(int id);
}
