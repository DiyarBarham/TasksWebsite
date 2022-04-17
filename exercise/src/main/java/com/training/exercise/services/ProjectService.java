package com.training.exercise.services;

import java.util.List;
import com.training.exercise.entities.Project;
import com.training.exercise.entities.Task;

public interface ProjectService {
	public List<Project> ListAll();
	public Project save(Project project);
	public Project FindById(int id);
}
